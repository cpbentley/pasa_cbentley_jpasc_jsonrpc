package pasa.cbentley.jpasc.jsonrpc.demoruns;

import java.net.MalformedURLException;
import java.net.URL;

import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;

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
}
