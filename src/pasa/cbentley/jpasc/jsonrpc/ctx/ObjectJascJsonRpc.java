package pasa.cbentley.jpasc.jsonrpc.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;

public class ObjectJascJsonRpc implements IStringable {

   protected final JPascJsonRpcCtx jjc;

   protected final PCoreCtx        pc;

   public ObjectJascJsonRpc(JPascJsonRpcCtx jjc) {
      this.jjc = jjc;
      this.pc = jjc.getPC();
   }

   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, ObjectJascJsonRpc.class, "@line5");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ObjectJascJsonRpc.class);
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return jjc.getUCtx();
   }

   //#enddebug

}
