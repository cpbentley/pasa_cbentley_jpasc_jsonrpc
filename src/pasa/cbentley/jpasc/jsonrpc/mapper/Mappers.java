package pasa.cbentley.jpasc.jsonrpc.mapper;

import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.ctx.ObjectJascJsonRpc;

public class Mappers extends ObjectJascJsonRpc {

   private MapperAccount    mapperAccount;

   private MapperBlock      mapperBlock;

   private MapperChanger    mapperChanger;

   private MapperDecryptedPayload mapperDecryptedPayload;

   private MapperNodeServer mapperNodeServer;

   private MapperNodeStatus mapperNodeStatus;

   private MapperOperation  mapperOperation;

   private MapperOpHashResult mapperOpHashResult;

   private MapperPublicKey  mapperPublicKey;

   private MapperReceiver   mapperReceiver;

   private MapperSender     mapperSender;

   public Mappers(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public MapperAccount getMapperAccount() {
      if (mapperAccount == null) {
         mapperAccount = new MapperAccount(jjc);
      }
      return mapperAccount;
   }

   public MapperBlock getMapperBlock() {
      if (mapperBlock == null) {
         mapperBlock = new MapperBlock(jjc);
      }
      return mapperBlock;
   }

   public MapperChanger getMapperChanger() {
      if (mapperChanger == null) {
         mapperChanger = new MapperChanger(jjc);
      }
      return mapperChanger;
   }

   public MapperDecryptedPayload getMapperDecryptedPayload() {
      if (mapperDecryptedPayload == null) {
         mapperDecryptedPayload = new MapperDecryptedPayload(jjc);
      }
      return mapperDecryptedPayload;
   }

   public MapperNodeServer getMapperNodeServer() {
      if (mapperNodeServer == null) {
         mapperNodeServer = new MapperNodeServer(jjc);
      }
      return mapperNodeServer;
   }

   public MapperNodeStatus getMapperNodeStatus() {
      if (mapperNodeStatus == null) {
         mapperNodeStatus = new MapperNodeStatus(jjc);
      }
      return mapperNodeStatus;
   }

   public MapperOperation getMapperOperation() {
      if (mapperOperation == null) {
         mapperOperation = new MapperOperation(jjc);
      }
      return mapperOperation;
   }

   public MapperOpHashResult getMapperOpHashResult() {
      if (mapperOpHashResult == null) {
         mapperOpHashResult = new MapperOpHashResult(jjc);
      }
      return mapperOpHashResult;
   }

   public MapperPublicKey getMapperPublicKey() {
      if (mapperPublicKey == null) {
         mapperPublicKey = new MapperPublicKey(jjc);
      }
      return mapperPublicKey;
   }

   public MapperReceiver getMapperReceiver() {
      if (mapperReceiver == null) {
         mapperReceiver = new MapperReceiver(jjc);
      }
      return mapperReceiver;
   }

   public MapperSender getMapperSender() {
      if (mapperSender == null) {
         mapperSender = new MapperSender(jjc);
      }
      return mapperSender;
   }

}
