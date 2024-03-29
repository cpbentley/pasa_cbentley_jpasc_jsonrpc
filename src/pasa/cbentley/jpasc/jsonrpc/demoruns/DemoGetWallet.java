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

public class DemoGetWallet extends DemoAbstract {

   public DemoGetWallet() {
      super();
   }

   public static void main(String[] args) {
      DemoGetWallet demo = new DemoGetWallet();
      demo.run();
   }

   public void run() {
      createSession();
      requestKeys(mySession);
   }

   private void requestKeys(JSONRPC2Session mySession) {
      String method = "getwalletcoins";
      Map<String, Object> params = new HashMap<>();
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

         System.out.println(result.getClass().getName());



      } else {
         System.out.println(response.getError().getMessage());
      }
   }

}
