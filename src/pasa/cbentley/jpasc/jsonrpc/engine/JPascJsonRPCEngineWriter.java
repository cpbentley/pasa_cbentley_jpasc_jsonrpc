package pasa.cbentley.jpasc.jsonrpc.engine;

import java.util.List;

import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;

import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
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
      // TODO Auto-generated method stub
      return null;
   }

   public PublicKey addNewKey(KeyType ecNid, String name) {
      // TODO Auto-generated method stub
      return null;
   }

}
