package pasa.cbentley.jpasc.jsonrpc.demoruns;

//The Client sessions package
import com.thetransactioncompany.jsonrpc2.client.*;

//The Base package for representing JSON-RPC 2.0 messages
import com.thetransactioncompany.jsonrpc2.*;

//The JSON Smart package for JSON encoding/decoding (optional)
import net.minidev.json.*;

//For creating URLs
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class DemoGetBlocks extends DemoAbstract {

   public DemoGetBlocks() {
      super();
   }

   public static void main(String[] args) {
      DemoGetBlocks demo = new DemoGetBlocks();
      demo.run();
   }

   public void run() {
      createSession();

      requestBlockCount(mySession);
      requestBlocks(mySession, null, 409000, 409074);
   }

   private void requestBlockCount(JSONRPC2Session mySession) {
      // Construct new request
      String method = "getblockcount";
      int requestID = 0;
      JSONRPC2Request request = new JSONRPC2Request(method, requestID);

      // Send request
      JSONRPC2Response response = null;

      try {
         response = mySession.send(request);

      } catch (JSONRPC2SessionException e) {

         System.err.println(e.getMessage());
         // handle exception...
      }

      // Print response result / error
      if (response.indicatesSuccess()) {
         System.out.println(response.getResult());
      } else {
         System.out.println(response.getError().getMessage());
      }
   }

   private void requestBlocks(JSONRPC2Session mySession, Integer last, Integer start, Integer end) {
      // Construct new request
      String method = "getblocks";
      Map<String, Object> params = new HashMap<>();
      if (last != null && (start != null || end != null))
         throw new IllegalArgumentException("Cannot specify both last and start/end arguments");
      if (last != null)
         params.put("last", last);
      if (start != null)
         params.put("start", start);
      if (end != null)
         params.put("end", end);

      int requestID = 0;
      JSONRPC2Request request = new JSONRPC2Request(method, params, requestID);

      // Send request
      JSONRPC2Response response = null;

      try {
         response = mySession.send(request);

      } catch (JSONRPC2SessionException e) {

         System.err.println(e.getMessage());
         // handle exception...
      }

      // Print response result / error
      if (response.indicatesSuccess()) {
         Object result = response.getResult();
         System.out.println(result);

         JSONArray array = (JSONArray) result;
         Object o1 = array.get(1);
         if (o1 instanceof JSONObject) {
            JSONObject jo = (JSONObject) o1;
            for (String key : jo.keySet()) {
               Object object = jo.get(key);
               System.out.println(key + " -> " + object);
            }
         }
         System.out.println(array.get(1));

      } else {
         System.out.println(response.getError().getMessage());
      }
   }

}
