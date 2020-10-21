package pasa.cbentley.jpasc.jsonrpc.ctx;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;

public class JPascJsonRpcCtx extends ACtx {

   protected final PCoreCtx pc;

   public JPascJsonRpcCtx(PCoreCtx pc) {
      super(pc.getUCtx());
      this.pc = pc;
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

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, JPascJsonRpcCtx.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
