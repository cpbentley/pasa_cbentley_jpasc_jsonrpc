package pasa.cbentley.jpasc.jsonrpc.mapper;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.OpReceiver;
import pasa.cbentley.jpasc.pcore.rpc.model.OpSender;

public class MapperSender extends MapperAbstract<OpSender> {

   public MapperSender(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public OpSender getT(JSONObjectGetter get) {
      OpSender or = new OpSender(pc);
      or.setAccount(get.getInteger("account"));
      or.setAmount(get.getDouble("amount"));
      or.setAmountString(get.getString("amount_s"));
      or.setPayLoad("payload");
      return or;
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, MapperSender.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, MapperSender.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
