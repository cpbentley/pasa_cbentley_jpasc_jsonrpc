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
import pasa.cbentley.jpasc.pcore.domain.operations.OperationJavaChangeAccountInfo;

//For creating URLs
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class DemoChangeAccountType extends DemoAbstract {

   public DemoChangeAccountType() {
      super();
   }

   public static void main(String[] args) {
      DemoChangeAccountType demo = new DemoChangeAccountType();
      demo.run();
   }

   public void run() {
      createSession();
      
      request(mySession, 485902, 485900, 2 );
   }

   private void request(JSONRPC2Session mySession, Integer account, Integer signer, Integer newType ) {
      // Construct new request
      String method = "changeaccountinfo";
      Map<String, Object> params = new HashMap<>();
      params.put("account_target", account);
      params.put("account_signer", signer);
      params.put("new_type", newType);
      params.put("fee", 0.0001);

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
         if (result instanceof JSONObject) {
            JSONObject jo = (JSONObject) result;

            for (String key : jo.keySet()) {
               Object object = jo.get(key);
               System.out.println(key + " -> " + object);
            }

         }
      } else {
         System.out.println(response.getError().getMessage());
      }
   }

}
