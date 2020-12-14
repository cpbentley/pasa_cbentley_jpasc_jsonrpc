package pasa.cbentley.jpasc.jsonrpc.mapper;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.DecodeOpHashResult;

public class MapperOpHashResult extends MapperAbstract<DecodeOpHashResult> {

   public MapperOpHashResult(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public DecodeOpHashResult getT(JSONObjectGetter get) {
      DecodeOpHashResult or = new DecodeOpHashResult(pc);
      or.setAccount(get.getInteger("account"));
      or.setBlock(get.getInteger("block"));
      or.setMd160Hash(get.getString("md160hash"));
      or.setnOperation(get.getInteger("n_operation"));
      return or;
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, MapperOpHashResult.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, MapperOpHashResult.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
