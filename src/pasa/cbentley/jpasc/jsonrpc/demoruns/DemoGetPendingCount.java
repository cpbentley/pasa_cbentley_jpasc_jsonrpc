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

public class DemoGetPendingCount extends DemoAbstract {

   public DemoGetPendingCount() {
      super();
   }

   public static void main(String[] args) {
      DemoGetPendingCount demo = new DemoGetPendingCount();
      demo.run();
   }

   public void run() {
      createSession();
      
      System.out.println("--------getpendingscount---------");
      request(mySession);
      
   }

   private void request(JSONRPC2Session mySession) {
      String method = "getpendingscount";
      Map<String, Object> params = new HashMap<>();
      int requestID = 0;
      JSONRPC2Request request = new JSONRPC2Request(method, params, requestID);
      sendRequestObj(request);
   }

}
