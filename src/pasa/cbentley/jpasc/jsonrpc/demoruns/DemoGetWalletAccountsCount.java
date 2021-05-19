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

public class DemoGetWalletAccountsCount extends DemoAbstract {

   public DemoGetWalletAccountsCount() {
      super();
   }

   public static void main(String[] args) {
      DemoGetWalletAccountsCount demo = new DemoGetWalletAccountsCount();
      demo.run();
   }

   public void run() {
      createSession();
      
      request(mySession);
   }

   private void request(JSONRPC2Session mySession) {
      // Construct new request
      String method = "getwalletaccountscount";
      Map<String, Object> params = new HashMap<>();

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

            AccountJava acc = new AccountJava(pc);
            Object accountJson = jo.get("account");
            acc.setAccount(((Long) accountJson).intValue());
            acc.setEncPubkey((String) jo.get("enc_pubkey"));

            for (String key : jo.keySet()) {
               Object object = jo.get(key);
               System.out.println(key + " -> " + object);
            }

            System.out.println(acc.toString());
         }
      } else {
         System.out.println(response.getError().getMessage());
      }
   }

}
