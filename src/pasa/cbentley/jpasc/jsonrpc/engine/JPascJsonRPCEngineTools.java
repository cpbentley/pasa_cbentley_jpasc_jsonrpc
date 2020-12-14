package pasa.cbentley.jpasc.jsonrpc.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;

import net.minidev.json.JSONObject;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperNodeStatus;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperOpHashResult;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperOperation;
import pasa.cbentley.jpasc.pcore.client.IPascalCoinClientTools;
import pasa.cbentley.jpasc.pcore.rpc.model.Connection;
import pasa.cbentley.jpasc.pcore.rpc.model.DecodeOpHashResult;
import pasa.cbentley.jpasc.pcore.rpc.model.DecryptedPayload;
import pasa.cbentley.jpasc.pcore.rpc.model.NodeStatus;
import pasa.cbentley.jpasc.pcore.rpc.model.Operation;
import pasa.cbentley.jpasc.pcore.rpc.model.SignResult;

public class JPascJsonRPCEngineTools extends JPascJsonRPCEngineAbstract implements IPascalCoinClientTools {

   public JPascJsonRPCEngineTools(JPascJsonRpcCtx jjc, JSONRPC2Session session) {
      super(jjc, session);
   }

   public Integer addNode(String nodes) {
      Map<String, Object> params = new HashMap<>();
      params.put("nodes", nodes);

      Long obj = (Long) super.launchRequest("addnode", params);
      return new Integer(obj.intValue());
   }

   public Boolean lock() {
      Boolean obj = (Boolean) super.launchRequest("lock", null);
      return obj;
   }

   public NodeStatus getNodeStatus() {
      JSONObject obj = (JSONObject) super.launchRequest("nodestatus", null);
      MapperNodeStatus mapper = jjc.getMappers().getMapperNodeStatus();
      NodeStatus t = mapper.getT(obj);
      return t;
   }

   public DecodeOpHashResult decodeOpHash(String ophash) {
      Map<String, Object> params = new HashMap<>();
      if (ophash == null)
         throw new IllegalArgumentException("Operation hash param is mandatory");
      params.put("ophash", ophash);

      JSONObject obj = (JSONObject) super.launchRequest("decodeophash", params);
      MapperOpHashResult mapper = jjc.getMappers().getMapperOpHashResult();
      DecodeOpHashResult b = mapper.getT(obj);
      return b;
   }

   public Boolean unlock(String pwd) {
      Map<String, Object> params = new HashMap<>();
      params.put("pwd", pwd);
      Boolean obj = (Boolean) super.launchRequest("unlock", params);
      return obj;
   }

   public SignResult verifySign(String digest, String encPubKey, String signature) {
      Map<String, Object> params = new HashMap<>();
      if (digest == null || encPubKey == null || signature == null)
         throw new IllegalArgumentException("Missing mandatory params. You have to specify digest, encPubKey and signature");
      if (encPubKey != null)
         params.put("enc_pubkey", encPubKey);
      if (signature != null)
         params.put("signature", signature);
      if (digest != null)
         params.put("digest", digest);

      JSONObject obj = (JSONObject) super.launchRequest("verifysign", params);

      return null;
   }

   public Boolean setWalletPassword(String pwd) {
      Map<String, Object> params = new HashMap<>();
      return null;
   }

   public Boolean stopNode() {
      Map<String, Object> params = new HashMap<>();
      return null;
   }

   public Boolean startNode() {
      Map<String, Object> params = new HashMap<>();
      return null;
   }

   public DecryptedPayload payloadDecrypt(String payload, String[] pwds) {
      Map<String, Object> params = new HashMap<>();
      return null;
   }

   public String payloadEncrypt(String payload, String payloadMethod, String pwd, String encPubKey, String b58PubKey) {
      Map<String, Object> params = new HashMap<>();
      return null;
   }

   public List<Connection> getConnections() {
      Map<String, Object> params = new HashMap<>();
      return null;
   }

   public SignResult signMessage(String digest, String encPubKey, String b58PubKey) {
      // TODO Auto-generated method stub
      return null;
   }

}
