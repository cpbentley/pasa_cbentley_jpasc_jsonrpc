package pasa.cbentley.jpasc.jsonrpc.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.ctx.ObjectJascJsonRpc;
import pasa.cbentley.jpasc.pcore.client.IPascalCoinClient;
import pasa.cbentley.jpasc.pcore.ctx.IPascalCoinClientFactory;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;

public class JPascJsonRPCClientFactory extends ObjectJascJsonRpc implements IPascalCoinClientFactory {

   public JPascJsonRPCClientFactory(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   /**
    * Connected client. 
    */
   public IPascalCoinClient createClient(PCoreCtx pc, String address, int port) {
      JPascJsonRPCEngine client = new JPascJsonRPCEngine(jjc);
      client.connect(address, port);
      return client;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, JPascJsonRPCClientFactory.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, JPascJsonRPCClientFactory.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
