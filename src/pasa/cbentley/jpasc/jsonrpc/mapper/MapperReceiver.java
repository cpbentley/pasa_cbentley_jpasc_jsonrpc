package pasa.cbentley.jpasc.jsonrpc.mapper;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.OpReceiver;

public class MapperReceiver extends MapperAbstract<OpReceiver> {

   public MapperReceiver(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public OpReceiver getT(JSONObjectGetter get) {
      OpReceiver or = new OpReceiver(pc);
      or.setAccount(get.getInteger("account"));
      or.setAmount(get.getDouble("amount"));
      or.setAmountString(get.getString("amount_s"));
      or.setPayLoad("payload");
      return or;
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, MapperReceiver.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, MapperReceiver.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
