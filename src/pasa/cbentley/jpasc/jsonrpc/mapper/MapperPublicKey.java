package pasa.cbentley.jpasc.jsonrpc.mapper;

import net.minidev.json.JSONObject;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.KeyType;
import pasa.cbentley.jpasc.pcore.rpc.model.NodeStatus;
import pasa.cbentley.jpasc.pcore.rpc.model.PublicKey;

public class MapperPublicKey extends MapperAbstract<PublicKey> {

   public MapperPublicKey(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public PublicKey getT(JSONObjectGetter getter) {

      PublicKey pk = new PublicKey(pc);

      pk.setBase58PubKey(getter.getString("b58_pubkey"));
      pk.setEncPubKey(getter.getString("enc_pubkey"));
      pk.setName(getter.getString("name"));
      pk.setX(getter.getString("x"));
      pk.setY(getter.getString("y"));
      pk.setCanUse(getter.getBoolean("can_use"));

      Integer ec = getter.getInteger("ec_nid");
      if (ec != null) {
         switch (ec) {
            case 714:
               pk.setKeyType(KeyType.SECP256K1);
               break;
            case 715:
               pk.setKeyType(KeyType.SECP384R1);
               break;
            case 716:
               pk.setKeyType(KeyType.SECP521R1);
               break;
            case 729:
               pk.setKeyType(KeyType.SECP283K1);
               break;
            default:
               break;
         }
      }
      return pk;

   }
}
