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

public class DemoFindAccountsNamesBentley extends DemoAbstract {

   public DemoFindAccountsNamesBentley() {
      super();
   }

   public static void main(String[] args) {
      DemoFindAccountsNamesBentley demo = new DemoFindAccountsNamesBentley();
      demo.run();
   }

   public void run() {
      createSession();
      
      
      System.out.println("-------STARTSWITH----------");
      requestKeys(mySession, "bentley", ITechPascRPC.NAMESEARCHTYPE_STARTSWITH);
      System.out.println("-----------------");
      
      System.out.println("--------EXACT---------");
      requestKeys(mySession, "bentley", ITechPascRPC.NAMESEARCHTYPE_EXACT);
      System.out.println("-----------------");
      
      System.out.println("--------ANY---------");
      requestKeys(mySession, "bentley", ITechPascRPC.NAMESEARCHTYPE_ANY);
      System.out.println("-----------------");
      
      System.out.println("--------None---------");
      requestKeys(mySession, "bentley", ITechPascRPC.NAMESEARCHTYPE_NONE);
      System.out.println("-----------------");
      
      System.out.println("--------NOT_CONTAINS---------");
      requestKeys(mySession, "bentley", ITechPascRPC.NAMESEARCHTYPE_NOT_CONTAINS);
      System.out.println("-----------------");
      
      System.out.println("--------NOT_STARTWITH---------");
      requestKeys(mySession, "bentley", ITechPascRPC.NAMESEARCHTYPE_NOT_STARTSWITH);
      System.out.println("-----------------");
      
      
      System.out.println("--------ENDSWITH---------");
      requestKeys(mySession, "bentley", ITechPascRPC.NAMESEARCHTYPE_ENDS_WITH);
      System.out.println("-----------------");
      
      System.out.println("--------CONTAINS---------");
      requestKeys(mySession, "bentley", ITechPascRPC.NAMESEARCHTYPE_CONTAINS);
      System.out.println("-----------------");
   }

   private void requestKeys(JSONRPC2Session mySession, String name, String namesearchtype) {
      String method = "findaccounts";
      Map<String, Object> params = new HashMap<>();
      params.put("start", 0);
      params.put("max", 10);
      if (name != null && !"".equals(name))
         params.put("name", name);
      if (namesearchtype != null)
         params.put("namesearchtype", namesearchtype);
      
      int requestID = 0;
      JSONRPC2Request request = new JSONRPC2Request(method, params, requestID);
      sendRequestArray(request);
   }

}
