package pasa.cbentley.jpasc.jsonrpc.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperAccount;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperBlock;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperNodeStatus;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperOperation;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperPublicKey;
import pasa.cbentley.jpasc.pcore.client.IPascalCoinClientReader;
import pasa.cbentley.jpasc.pcore.rpc.model.Account;
import pasa.cbentley.jpasc.pcore.rpc.model.Block;
import pasa.cbentley.jpasc.pcore.rpc.model.Connection;
import pasa.cbentley.jpasc.pcore.rpc.model.DecodeOpHashResult;
import pasa.cbentley.jpasc.pcore.rpc.model.DecryptedPayload;
import pasa.cbentley.jpasc.pcore.rpc.model.KeyType;
import pasa.cbentley.jpasc.pcore.rpc.model.NodeStatus;
import pasa.cbentley.jpasc.pcore.rpc.model.Operation;
import pasa.cbentley.jpasc.pcore.rpc.model.PublicKey;

public class JPascJsonRPCEngineReader extends JPascJsonRPCEngineAbstract implements IPascalCoinClientReader {

   public JPascJsonRPCEngineReader(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public JPascJsonRPCEngineReader(JPascJsonRpcCtx jjc, JSONRPC2Session session) {
      super(jjc, session);
   }

   public Account getAccount(Integer account) {
      Map<String, Object> params = new HashMap<>();
      if (account == null) {
         throw new IllegalArgumentException("Arguments cannot be null");
      }
      params.put("account", account);
      JSONObject obj = (JSONObject) super.launchRequest("getaccount", params);
      MapperAccount map = getMapperAccount();
      Account acc = map.getT(obj);
      return acc;
   }

   public List<Account> getWalletAccounts(String encPubKey, String b58PubKey, Integer start, Integer max) {
      Map<String, Object> params = new HashMap<>();
      if (encPubKey != null)
         params.put("enc_pubkey", encPubKey);
      if (b58PubKey != null)
         params.put("b58_pubkey", b58PubKey);
      if (start != null)
         params.put("start", start);
      if (max != null)
         params.put("max", max);

      JSONArray array = (JSONArray) super.launchRequest("getwalletaccounts", params);
      MapperAccount map = jjc.getMappers().getMapperAccount();
      List<Account> list = map.getList(array);
      return list;
   }

   public Integer getWalletAccountsCount(String encPubKey, String b58PubKey) {
      Map<String, Object> params = new HashMap<>();
      if (encPubKey != null)
         params.put("enc_pubkey", encPubKey);
      if (b58PubKey != null)
         params.put("b58_pubkey", b58PubKey);

      Long obj = (Long) super.launchRequest("getwalletaccountscount", params);
      return new Integer(obj.intValue());
   }

   public List<PublicKey> getWalletPubKeys(Integer start, Integer max) {
      Map<String, Object> params = new HashMap<>();
      if (start != null)
         params.put("start", start);
      if (max != null)
         params.put("max", max);
      JSONArray array = (JSONArray) super.launchRequest("getwalletpubkeys", params);
      MapperPublicKey map = jjc.getMappers().getMapperPublicKey();
      List<PublicKey> list = map.getList(array);
      return list;
   }

   public PublicKey getWalletPubKey(String encPubKey, String b58PubKey) {
      Map<String, Object> params = new HashMap<>();
      if (encPubKey != null)
         params.put("enc_pubkey", encPubKey);
      if (b58PubKey != null)
         params.put("b58_pubkey", b58PubKey);
      JSONObject obj = (JSONObject) super.launchRequest("getwalletpubkey", params);
      PublicKey pk = jjc.getMappers().getMapperPublicKey().getT(obj);
      return pk;
   }

   public Double getWalletCoins(String encPubKey, String b58PubKey) {
      Map<String, Object> params = new HashMap<>();
      if (encPubKey != null)
         params.put("enc_pubkey", encPubKey);
      if (b58PubKey != null)
         params.put("b58_pubkey", b58PubKey);

      Object obj = super.launchRequest("getwalletcoins", params);
      if(obj instanceof Double) {
         return (Double)obj;
      } else if(obj instanceof Long)  {
         Long l = (Long)obj;
         return l.doubleValue();
      } else {
         throw new IllegalArgumentException();
      }
   }

   public Block getBlock(Integer block) {
      Map<String, Object> params = new HashMap<>();
      if (block == null) {
         throw new IllegalArgumentException("Arguments cannot be null");
      }
      params.put("block", block);
      JSONObject obj = (JSONObject) super.launchRequest("getblock", params);
      MapperBlock mapper = getMapperBlock();
      Block t = mapper.getT(obj);
      return t;
   }

   public List<Block> getBlocksASC(Integer start, Integer end) {
      Map<String, Object> params = new HashMap<>();
      if (start == null || end == null) {
         throw new IllegalArgumentException("Arguments cannot be null");
      }
      params.put("start", start);
      params.put("end", end);

      JSONArray array = (JSONArray) super.launchRequest("getblocks", params);
      MapperBlock mapper = getMapperBlock();
      List<Block> list = mapper.getList(array);
      return list;
   }

   public List<Block> getBlocks(Integer last, Integer start, Integer end) {
      Map<String, Object> params = new HashMap<>();
      if (last != null && (start != null || end != null)) {
         throw new IllegalArgumentException("Cannot specify both last and start/end arguments");
      }
      if (last != null) {
         params.put("last", last);
      }
      if (start != null) {
         params.put("start", start);
      }
      if (end != null) {
         params.put("end", end);
      }

      JSONArray array = (JSONArray) super.launchRequest("getblocks", params);
      MapperBlock mapper = getMapperBlock();
      List<Block> list = mapper.getList(array);
      return list;
   }

   public Integer getBlockCount() {
      Long l = (Long) super.launchRequest("getblockcount");
      return new Integer(((Long) l).intValue());
   }

   /**
    * 
    */
   public Operation getBlockOperation(Integer block, Integer opblock) {
      Map<String, Object> params = new HashMap<>();
      if (block == null || opblock == null) {
         throw new IllegalArgumentException("Block num and operation number are mandatory arguments");
      }
      params.put("block", block);
      params.put("opblock", opblock);

      JSONObject obj = (JSONObject) super.launchRequest("getblocks", params);
      MapperOperation mapper = getMapperOperation();
      Operation b = mapper.getT(obj);
      return b;
   }

   public List<Operation> getBlockOperations(Integer block, Integer start, Integer max) {
      Map<String, Object> params = new HashMap<>();
      if (block == null)
         throw new IllegalArgumentException("Block param is mandatory");
      params.put("block", block);
      if (start != null)
         params.put("start", start);
      if (max != null)
         params.put("max", max);

      JSONArray array = (JSONArray) super.launchRequest("getblockoperations", params);
      MapperOperation mapper = getMapperOperation();
      List<Operation> list = mapper.getList(array);
      return list;
   }

   public List<Operation> getAccountOperations(Integer account, Integer depth, Integer start, Integer max) {
      return getAccountOperations(account, 0, depth, start, max);
   }

   public List<Operation> getAccountOperations(Integer account, Integer startblock, Integer depth, Integer start, Integer max) {
      Map<String, Object> params = new HashMap<>();
      if (account == null)
         throw new IllegalArgumentException("Account param is mandatory");
      params.put("account", account);
      if (startblock != null)
         params.put("startblock", startblock);
      if (depth != null)
         params.put("depth", depth);
      if (start != null)
         params.put("start", start);
      if (max != null)
         params.put("max", max);

      JSONArray array = (JSONArray) super.launchRequest("getaccountoperations", params);
      MapperOperation mapper = getMapperOperation();
      List<Operation> list = mapper.getList(array);
      return list;
   }

   public List<Operation> getPendings() {
      return getPendings(null, null);
   }

   public List<Operation> getPendings(Integer start, Integer max) {
      Map<String, Object> params = new HashMap<>();
      params.put("start", start);
      params.put("max", max);
      
      JSONArray array = (JSONArray) super.launchRequest("getpendings", params);
      MapperOperation mapper = getMapperOperation();
      List<Operation> list = mapper.getList(array);
      return list;
   }

   public Integer getPendingsCount() {
      Long l = (Long) super.launchRequest("getpendingscount");
      return new Integer(((Long) l).intValue());
   }

   public Operation findOperation(String ophash) {
      Map<String, Object> params = new HashMap<>();
      if (ophash == null)
         throw new IllegalArgumentException("Operation hash param is mandatory");
      params.put("ophash", ophash);

      JSONObject obj = (JSONObject) super.launchRequest("findoperation", params);
      MapperOperation mapper = getMapperOperation();
      Operation b = mapper.getT(obj);
      return b;
   }



   public Operation findNOperation(Integer account, Integer nOperation) {
      Map<String, Object> params = new HashMap<>();
      if (account == null)
         throw new IllegalArgumentException("Account param is mandatory");
      params.put("account", account);
      if (nOperation == null)
         throw new IllegalArgumentException("n_operation param is mandatory");
      params.put("n_operation", nOperation);

      JSONObject obj = (JSONObject) super.launchRequest("findnoperation", params);
      MapperOperation mapper = getMapperOperation();
      Operation b = mapper.getT(obj);
      return b;
   }

   public List<Operation> findNOperations(Integer account, Integer nOperationMin, Integer nOperationMax, Integer startBlock) {
      Map<String, Object> params = new HashMap<>();
      if (account == null)
         throw new IllegalArgumentException("Account param is mandatory");
      params.put("account", account);
      if (nOperationMin == null)
         throw new IllegalArgumentException("n_operation_min param is mandatory");
      params.put("n_operation_min", nOperationMin);
      if (nOperationMax == null)
         throw new IllegalArgumentException("n_operation_max param is mandatory");
      params.put("n_operation_max", nOperationMax);
      if (startBlock == null)
         params.put("start_block", 0);
      else
         params.put("start_block", startBlock);

      JSONArray array = (JSONArray) super.launchRequest("findnoperation", params);
      MapperOperation mapper = getMapperOperation();
      List<Operation> list = mapper.getList(array);
      return list;
   }

   public List<Account> findAccounts(String name, Integer type, Integer start, Integer max) {
      Map<String, Object> params = new HashMap<>();
      if (name != null && !"".equals(name))
         params.put("name", name);
      if (type != null)
         params.put("type", type);
      if (start != null)
         params.put("start", start);
      if (max != null)
         params.put("max", max);

      JSONArray array = (JSONArray) super.launchRequest("findaccounts", params);
      MapperAccount map = jjc.getMappers().getMapperAccount();
      List<Account> list = map.getList(array);
      return list;
   }

   /**
    * see https://github.com/PascalCoin/PascalCoin/blob/master/src/core/UPCRPCFindAccounts.pas
    * @param name
    * @param nameSearchType
    * @param type
    * @param statusType
    * @param minBalance
    * @param maxBalance
    * @param start
    * @param max
    * @return
    */
   public List<Account> findAccounts(String name, String nameSearchType, Integer type, String statusType, Double minBalance, Double maxBalance, Integer start, Integer max) {
      Map<String, Object> params = new HashMap<>();
      if (name != null && !"".equals(name))
         params.put("name", name);
      if (nameSearchType != null)
         params.put("namesearchtype", nameSearchType);
      if (statusType != null)
         params.put("statustype", statusType);
      if (minBalance != null)
         params.put("min_balance", minBalance);
      if (maxBalance != null)
         params.put("max_balance", maxBalance);
      if (type != null)
         params.put("type", type);
      if (start != null)
         params.put("start", start);
      if (max != null)
         params.put("max", max);

      JSONArray array = (JSONArray) super.launchRequest("findaccounts", params);
      MapperAccount map = jjc.getMappers().getMapperAccount();
      List<Account> list = map.getList(array);
      return list;
   }
   
   public List<Account> findAccounts(String name, Boolean exact, Integer type, Boolean listed, Double minBalance, Double maxBalance, Integer start, Integer max) {
      Map<String, Object> params = new HashMap<>();
      if (name != null && !"".equals(name))
         params.put("name", name);
      if (listed != null)
         params.put("listed", listed);
      if (exact != null)
         params.put("exact", exact);
      if (minBalance != null)
         params.put("min_balance", minBalance);
      if (maxBalance != null)
         params.put("max_balance", maxBalance);
      if (type != null)
         params.put("type", type);
      if (start != null)
         params.put("start", start);
      if (max != null)
         params.put("max", max);

      JSONArray array = (JSONArray) super.launchRequest("findaccounts", params);
      MapperAccount map = jjc.getMappers().getMapperAccount();
      List<Account> list = map.getList(array);
      return list;
   }


   public String encodePubKey(KeyType ecNid, String x, String y) {
      if (ecNid == null || x == null || y == null)
         throw new IllegalArgumentException("Params ecNid,x and y are mandatory");

      Map<String, Object> params = new HashMap<>();
      params.put("ec_nid", ecNid);
      params.put("x", x);
      params.put("y", y);

      String str = (String) super.launchRequest("encodepubkey", null);
      return str;
   }

   public PublicKey decodePubKey(String encPubKey, String b58PubKey) {
      Map<String, Object> params = new HashMap<>();
      if (encPubKey != null)
         params.put("enc_pubkey", encPubKey);
      if (b58PubKey != null)
         params.put("b58_pubkey", b58PubKey);

      JSONObject obj = (JSONObject) super.launchRequest("nodestatus", null);
      MapperPublicKey mapper = jjc.getMappers().getMapperPublicKey();
      PublicKey pk = mapper.getT(obj);
      return pk;
   }

   public DecryptedPayload payloadDecrypt(String payload, String[] pwds) {
      Map<String, Object> params = new HashMap<>();
      return null;
   }

}
