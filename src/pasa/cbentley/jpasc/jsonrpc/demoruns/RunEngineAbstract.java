package pasa.cbentley.jpasc.jsonrpc.demoruns;

import java.net.MalformedURLException;
import java.net.URL;

import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.core.src5.ctx.C5Ctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JPascJsonRPCClientFactory;
import pasa.cbentley.jpasc.pcore.client.IPascalCoinClient;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;

public abstract class RunEngineAbstract implements IStringable {

   protected final JPascJsonRpcCtx jjc;

   protected final PCoreCtx        pc;

   protected String                ip   = "localhost";

   protected int                   port = 4003;

   private IPascalCoinClient       client;

   public RunEngineAbstract() {
      UCtx uc = new UCtx();
      C5Ctx c5 = new C5Ctx(uc);
      pc = new PCoreCtx(uc, c5);
      jjc = new JPascJsonRpcCtx(pc);
   }

   public RunEngineAbstract(JPascJsonRpcCtx jjc) {
      this.jjc = jjc;
      this.pc = jjc.getPC();
   }

   public void run() {
      JPascJsonRPCClientFactory factory = new JPascJsonRPCClientFactory(jjc);
      pc.setPascalCoinClientFactory(factory);
      client = factory.createClient(pc, ip, port);
      pc.setPascalCoinClient(client);
      run(client);
   }

   public abstract void run(IPascalCoinClient client);

   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, RunEngineAbstract.class, "@line5");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, RunEngineAbstract.class);
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return jjc.getUCtx();
   }

   //#enddebug

}
