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

public class DemoGetWalletAccount extends DemoAbstract {

   public DemoGetWalletAccount() {
      super();
   }

   public static void main(String[] args) {
      DemoGetWalletAccount demo = new DemoGetWalletAccount();
      demo.run();
   }

   public void run() {
      createSession();
      requestAccounts(mySession, "3Ghhboo16Mn1f1KtTf16yEkbbZxRKgCE1PCWvB1sBEXYusYxfEoVb6pMCyzqYoeCgKMdxhurjGVTGSZosZ6i6kbmrhNQMn9bMCXBia", null);
      requestAccounts(mySession, null, "CA0220000BAE8D0F2A32189E1EC913E65827E7D0C826B3F8C318FB9E01DCABCAB861DCAB2000BE879FFE5036FDA17300BC58FDDAF6011A36696BF4C3CB3938C0400E6DF27B8E");
   }

   private void requestAccounts(JSONRPC2Session mySession, String pkey, String encodedPkey) {
      // Construct new request
      String method = "getwalletaccounts";
      Map<String, Object> params = new HashMap<>();
      if (pkey == null) {
         throw new IllegalArgumentException("Cannot specify both last and start/end arguments");
      }
      params.put("b58_pubkey", pkey);
      params.put("enc_pubkey", encodedPkey);
      params.put("start", 0);
      //params.put("max", 10);

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
