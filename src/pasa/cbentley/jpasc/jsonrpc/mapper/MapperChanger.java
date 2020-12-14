package pasa.cbentley.jpasc.jsonrpc.mapper;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.OpChanger;
import pasa.cbentley.jpasc.pcore.rpc.model.OpReceiver;

public class MapperChanger extends MapperAbstract<OpChanger> {

   public MapperChanger(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public OpChanger getT(JSONObjectGetter get) {
      OpChanger or = new OpChanger(pc);
      or.setAccount(get.getInteger("account"));
      or.setFee(get.getDouble("fee"));
      return or;
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, MapperChanger.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, MapperChanger.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
