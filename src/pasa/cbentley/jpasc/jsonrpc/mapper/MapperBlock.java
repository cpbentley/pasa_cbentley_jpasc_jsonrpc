package pasa.cbentley.jpasc.jsonrpc.mapper;

import net.minidev.json.JSONObject;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.Block;

public class MapperBlock extends MapperAbstract<Block> {

   public MapperBlock(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public Block getT(JSONObjectGetter getter) {

      Block b = new Block(pc);
      b.setAvailableVersion(getter.getInteger("ver_a"));
      b.setBlock(getter.getInteger("block"));
      b.setCompactTarget(getter.getInteger("target"));
      b.setEncPubKey(getter.getString("enc_pubkey"));
      b.setFee(getter.getDouble("fee"));
      b.setFeeString(getter.getString("fee_s"));
      b.setLast50HashRateKhs(getter.getLong("hashratekhs"));
      b.setMaturation(getter.getInteger("maturation"));
      b.setNonce(getter.getLong("nonce"));
      b.setOperationCount(getter.getInteger("operations"));
      b.setOperationsHash(getter.getString("oph"));
      b.setPayload(getter.getString("payload"));
      b.setProofOfWork(getter.getString("pow"));
      b.setReward(getter.getDouble("reward"));
      b.setRewardString(getter.getString("reward_s"));
      b.setSafeBoxHash(getter.getString("sbh"));
      b.setTimestamp(getter.getLong("timestamp"));
      b.setVersion(getter.getInteger("ver"));

      return b;
   }
}
