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
import pasa.cbentley.jpasc.pcore.ctx.ITechPascRPC;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;
import pasa.cbentley.jpasc.pcore.domain.java.AccountJava;

//For creating URLs
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class DemoGetSwapAccount extends DemoAbstract {

   public DemoGetSwapAccount() {
      super();
   }

   public static void main(String[] args) {
      DemoGetSwapAccount demo = new DemoGetSwapAccount();
      demo.run();
   }

   public void run() {
      createSession();

      requestAccounts(mySession, ITechPascRPC.STATUS_TYPE_FOR_SWAP_ACCOUNT);
   }

   private void requestAccounts(JSONRPC2Session mySession, String statustype) {
      String method = "findaccounts";
      Map<String, Object> params = new HashMap<>();
      params.put("start", 0);
      params.put("max", 10);
      if (statustype != null)
         params.put("statustype", statustype);

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
