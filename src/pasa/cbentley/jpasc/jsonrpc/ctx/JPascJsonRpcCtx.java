package pasa.cbentley.jpasc.jsonrpc.ctx;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.jsonrpc.mapper.Mappers;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;

public class JPascJsonRpcCtx extends ACtx {

   public static final int CTX_ID = 5011;

   private long id = 0L;

   private Mappers          mappers;

   protected final PCoreCtx pc;

   public JPascJsonRpcCtx(PCoreCtx pc) {
      super(pc.getUCtx());
      this.pc = pc;

      mappers = new Mappers(this);
   }

   public int getCtxID() {
      return CTX_ID;
   }

   public Mappers getMappers() {
      return mappers;
   }

   public synchronized Long getNextRequestID() {
      id++;
      return new Long(id);
   }

   public PCoreCtx getPC() {
      return pc;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, JPascJsonRpcCtx.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, JPascJsonRpcCtx.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
