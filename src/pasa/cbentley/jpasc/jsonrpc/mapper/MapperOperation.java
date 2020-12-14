package pasa.cbentley.jpasc.jsonrpc.mapper;

import java.util.ArrayList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.Block;
import pasa.cbentley.jpasc.pcore.rpc.model.OpReceiver;
import pasa.cbentley.jpasc.pcore.rpc.model.Operation;
import pasa.cbentley.jpasc.pcore.rpc.model.OperationSubType;
import pasa.cbentley.jpasc.pcore.rpc.model.OperationType;

public class MapperOperation extends MapperAbstract<Operation> {

   public MapperOperation(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

  

   public Operation getT(JSONObjectGetter getter) {
      Operation b = new Operation(pc);
      b.setBlock(getter.getInteger("block"));
      b.setAccount(getter.getInteger("account"));
      b.setNOperation(getter.getInteger("n_operation"));
      b.setPayLoad(getter.getString("payload"));
      
      b.setAmount(getter.getDouble("amount"));
      b.setAmountString(getter.getString("amount_s"));
      
      Mappers map = jjc.getMappers();
      JSONArray receivers = getter.getArray("receivers");
      b.setReceivers(map.getMapperReceiver().getList(receivers));
      b.setSenders(map.getMapperSender().getList(getter.getArray("senders")));
      b.setChangers(map.getMapperChanger().getList(getter.getArray("changers")));
     
      
      
      b.setFee(getter.getDouble("fee"));
      b.setFeeString(getter.getString("fee_s"));
      
      b.setMaturation(getter.getInteger("maturation"));
      b.setOperationBlock(getter.getInteger("opblock"));
      
      b.setOpHash(getter.getString("ophash"));
      b.setTime(getter.getLong("time"));
      
      b.setSignerAccount(getter.getInteger("signer_account"));
      b.setSenderAccount(getter.getInteger("sender_account"));
      b.setDestAccount(getter.getInteger("dest_account"));

      b.setTypeDescriptor(getter.getString("optxt"));
      
      Integer optype = getter.getInteger("optype");
      switch (optype.intValue()) {
         case 0:
            b.setType(OperationType.BLOCKCHAINREWARD);
            break;
         case 1:
            b.setType(OperationType.TRANSACTION);
            break;
         case 2:
            b.setType(OperationType.CHANGEKEY);
            break;
         case 3:
            b.setType(OperationType.RECOVERFUNDS);
            break;
         default:
            break;
      }
      Integer opsubtype = getter.getInteger("subtype");
      switch (opsubtype.intValue()) {
         case 11:
            b.setSubType(OperationSubType.TRANSACTION_SENDER);
            break;
         case 12:
            b.setSubType(OperationSubType.TRANSACTION_RECEIVER);
            break;
         case 13:
            b.setSubType(OperationSubType.BUYTRANSACTION_BUYER);
            break;
         case 14:
            b.setSubType(OperationSubType.BUYTRANSACTION_TARGET);
            break;
         case 15:
            b.setSubType(OperationSubType.BUYTRANSACTION_SELLER);
            break;
         case 21:
            b.setSubType(OperationSubType.CHANGE_KEY);
            break;
         case 31:
            b.setSubType(OperationSubType.RECOVER);
            break;
         case 41:
            b.setSubType(OperationSubType.LIST_ACCOUNT_FOR_PUBLIC_SALE);
            break;
         case 42:
            b.setSubType(OperationSubType.LIST_ACCOUNT_FOR_PRIVATE_SALE);
            break;
         case 51:
            b.setSubType(OperationSubType.DELIST_ACCOUNT);
            break;
         case 61:
            b.setSubType(OperationSubType.BUYACCOUNT_BUYER);
            break;
         case 62:
            b.setSubType(OperationSubType.BUYACCONT_TARGET);
            break;
         case 63:
            b.setSubType(OperationSubType.BUYACCOUNT_SELLER);
            break;
         case 71:
            b.setSubType(OperationSubType.CHANGE_KEY_SIGNED);
            break;
         case 81:
            b.setSubType(OperationSubType.CHANGE_ACCOUNT_INFO);
            break;

         default:
            break;
      }
      
      
      return b;
   }

}
