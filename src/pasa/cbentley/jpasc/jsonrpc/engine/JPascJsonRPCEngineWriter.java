package pasa.cbentley.jpasc.jsonrpc.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperOperation;
import pasa.cbentley.jpasc.pcore.client.IPascalCoinClientWriter;
import pasa.cbentley.jpasc.pcore.rpc.model.KeyType;
import pasa.cbentley.jpasc.pcore.rpc.model.Operation;
import pasa.cbentley.jpasc.pcore.rpc.model.PayLoadEncryptionMethod;
import pasa.cbentley.jpasc.pcore.rpc.model.PublicKey;

public class JPascJsonRPCEngineWriter extends JPascJsonRPCEngineAbstract implements IPascalCoinClientWriter {

   public JPascJsonRPCEngineWriter(JPascJsonRpcCtx jjc, JSONRPC2Session session) {
      super(jjc, session);
   }

   public Operation changeKey(Integer account, Integer accountSigner, String newEncPubKey, String newB58PubKey, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      // TODO Auto-generated method stub
      return null;
   }

   public List<Operation> changeKeys(String accounts, String newEncPubKey, String newB58PubKey, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      // TODO Auto-generated method stub
      return null;
   }

   public Operation listAccountForSale(Integer accountTarget, Integer accountSigner, Double price, Integer sellerAccount, String newB58PubKey, String newEncPubKey, Integer lockedUntilBlock, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      // TODO Auto-generated method stub
      return null;
   }

   public Operation delistAccountForSale(Integer accountTarget, Integer accountSigner, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      // TODO Auto-generated method stub
      return null;
   }

   public Operation sendTo(Integer sender, Integer target, Double amount, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      // TODO Auto-generated method stub
      return null;
   }

   public Operation buyAccount(Integer buyerAccount, Integer accountToPurchase, Double price, Integer sellerAccount, String newB58PubKey, String newEncPubKey, Double amount, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      // TODO Auto-generated method stub
      return null;
   }

   public Operation changeAccountInfo(Integer accountTarget, Integer accountSigner, String newEncPubKey, String newB58PubKey, String newName, Short newType, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      String method = "changeaccountinfo";
      Map<String, Object> params = new HashMap<>();
      if (accountTarget != null)
         params.put("account_target", accountTarget);
      if (accountSigner != null)
         params.put("account_signer", accountSigner);
      if (newEncPubKey != null)
         params.put("enc_pubkey", newEncPubKey);
      if (newB58PubKey != null)
         params.put("b58_pubkey", newB58PubKey);
      if (newType != null)
         params.put("new_type", newType);
      if (fee != null)
         params.put("fee", fee);
      if (newName != null)
         params.put("new_name", newName);
      if (payload != null)
         params.put("payload", pc.getPU().hexStringFromByteArray(payload));
      if (payloadMethod != null)
         params.put("payload_method", payloadMethod);
      if (pwd != null)
         params.put("pwd", pwd);

      JSONObject obj = (JSONObject) super.launchRequest(method, params);
      MapperOperation mapper = getMapperOperation();
      Operation op = mapper.getT(obj);
      return op;
   }

   public PublicKey addNewKey(KeyType ecNid, String name) {
      // TODO Auto-generated method stub
      return null;
   }

}
