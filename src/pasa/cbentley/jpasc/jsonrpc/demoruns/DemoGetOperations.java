package pasa.cbentley.jpasc.jsonrpc.demoruns;

//The Client sessions package
import com.thetransactioncompany.jsonrpc2.client.*;

//The Base package for representing JSON-RPC 2.0 messages
import com.thetransactioncompany.jsonrpc2.*;

//The JSON Smart package for JSON encoding/decoding (optional)
import net.minidev.json.*;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src5.ctx.C5Ctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;
import pasa.cbentley.jpasc.pcore.domain.java.AccountJava;

//For creating URLs
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class DemoGetOperations extends DemoAbstract {

   public DemoGetOperations() {
      super();
   }

   public static void main(String[] args) {
      DemoGetOperations demo = new DemoGetOperations();
      demo.run();
   }

   public void run() {
      createSession();
      requestAccount(mySession, 471822);
   }

   private void requestAccount(JSONRPC2Session mySession, Integer block) {
      // Construct new request
      String method = "getblockoperations";
      Map<String, Object> params = new HashMap<>();
      if (block == null) {
         throw new IllegalArgumentException("Cannot specify both last and start/end arguments");
      }
      params.put("block", block);
      params.put("start", 0);
      params.put("max", 10);

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

      if (response.indicatesSuccess()) {
         Object result = response.getResult();
         System.out.println(result);

         JSONArray array = (JSONArray) result;

         if (array.isEmpty()) {
            System.out.println("Array is empty");
            return;
         }

         for (int i = 0; i < array.size(); i++) {
            Object o1 = array.get(i);
            if (o1 instanceof JSONObject) {
               JSONObject jo = (JSONObject) o1;
               for (String key : jo.keySet()) {
                  Object object = jo.get(key);
                  System.out.println(key + " -> " + object);
               }
            }
            System.out.println(array.get(i));
         }

      } else {
         System.out.println(response.getError().getMessage());
      }
   }

}
