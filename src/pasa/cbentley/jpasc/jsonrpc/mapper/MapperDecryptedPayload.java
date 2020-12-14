package pasa.cbentley.jpasc.jsonrpc.mapper;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.DecryptedPayload;
import pasa.cbentley.jpasc.pcore.rpc.model.DecryptedPayloadMethod;

public class MapperDecryptedPayload extends MapperAbstract<DecryptedPayload> {

   public MapperDecryptedPayload(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public DecryptedPayload getT(JSONObjectGetter get) {
      DecryptedPayload or = new DecryptedPayload(pc);
      or.setDecryptPassword(get.getString("fee"));
      or.setEncodedPubKey(get.getString("fee"));
      or.setOriginalPayload(get.getString("fee"));
      DecryptedPayloadMethod method = DecryptedPayloadMethod.KEY;
      or.setPayloadMethod(method);
      or.setResult(get.getBoolean("result"));
      or.setUnencryptedPayload(get.getString("fee"));
      or.setUnencryptedPayloadHex(get.getString("fee"));
      return or;
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, MapperDecryptedPayload.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, MapperDecryptedPayload.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
