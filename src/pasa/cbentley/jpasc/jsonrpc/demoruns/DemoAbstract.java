package pasa.cbentley.jpasc.jsonrpc.demoruns;

import java.net.MalformedURLException;
import java.net.URL;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src5.ctx.C5Ctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;

public abstract class DemoAbstract {

   protected final JPascJsonRpcCtx jjc;

   protected final PCoreCtx        pc;

   protected JSONRPC2Session       mySession;

   public DemoAbstract() {
      UCtx uc = new UCtx();
      C5Ctx c5 = new C5Ctx(uc);
      pc = new PCoreCtx(uc, c5);
      jjc = new JPascJsonRpcCtx(pc);
   }

   public DemoAbstract(JPascJsonRpcCtx jjc) {
      this.jjc = jjc;
      this.pc = jjc.getPC();
   }

   public void createSession() {
      // The JSON-RPC 2.0 server URL
      URL serverURL = null;

      try {
         serverURL = new URL("http://localhost:4003");

      } catch (MalformedURLException e) {
         // handle exception...
      }

      // Create new JSON-RPC 2.0 client session
      mySession = new JSONRPC2Session(serverURL);
   }
   
   protected void sendRequest(JSONRPC2Request request) {
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
         } else {
            System.out.println("Array found of size "+ array.size());
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
