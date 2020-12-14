package pasa.cbentley.jpasc.jsonrpc.engine;

import java.util.List;

import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.pcore.client.IPascalCoinClient;
import pasa.cbentley.jpasc.pcore.rpc.model.Account;
import pasa.cbentley.jpasc.pcore.rpc.model.AccountKey;
import pasa.cbentley.jpasc.pcore.rpc.model.Block;
import pasa.cbentley.jpasc.pcore.rpc.model.Connection;
import pasa.cbentley.jpasc.pcore.rpc.model.DecodeOpHashResult;
import pasa.cbentley.jpasc.pcore.rpc.model.DecryptedPayload;
import pasa.cbentley.jpasc.pcore.rpc.model.KeyType;
import pasa.cbentley.jpasc.pcore.rpc.model.MultiOperation;
import pasa.cbentley.jpasc.pcore.rpc.model.NodeStatus;
import pasa.cbentley.jpasc.pcore.rpc.model.OpChanger;
import pasa.cbentley.jpasc.pcore.rpc.model.OpReceiver;
import pasa.cbentley.jpasc.pcore.rpc.model.OpSender;
import pasa.cbentley.jpasc.pcore.rpc.model.Operation;
import pasa.cbentley.jpasc.pcore.rpc.model.PayLoadEncryptionMethod;
import pasa.cbentley.jpasc.pcore.rpc.model.PublicKey;
import pasa.cbentley.jpasc.pcore.rpc.model.RawOperation;
import pasa.cbentley.jpasc.pcore.rpc.model.SignResult;

public class JPascJsonRPCEngine extends JPascJsonRPCEngineAbstract implements IPascalCoinClient {

   private JPascJsonRPCEngineReader engineReader;

   private JPascJsonRPCEngineTools  engineTools;

   private JPascJsonRPCEngineWriter engineWriter;

   public JPascJsonRPCEngine(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public PublicKey addNewKey(KeyType ecNid, String name) {
      return getEngineWriter().addNewKey(ecNid, name);
   }

   public Integer addNode(String nodes) {
      return getEngineTools().addNode(nodes);
   }

   public Operation buyAccount(Integer buyerAccount, Integer accountToPurchase, Double price, Integer sellerAccount, String newB58PubKey, String newEncPubKey, Double amount, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      return getEngineWriter().buyAccount(buyerAccount, accountToPurchase, price, sellerAccount, newB58PubKey, newEncPubKey, amount, fee, payload, payloadMethod, pwd);
   }

   public Operation changeAccountInfo(Integer accountTarget, Integer accountSigner, String newEncPubKey, String newB58PubKey, String newName, Short newType, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      return getEngineWriter().changeAccountInfo(accountTarget, accountSigner, newEncPubKey, newB58PubKey, newName, newType, fee, payload, payloadMethod, pwd);
   }

   public Operation changeKey(Integer account, Integer accountSigner, String newEncPubKey, String newB58PubKey, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      return getEngineWriter().changeKey(account, accountSigner, newEncPubKey, newB58PubKey, fee, payload, payloadMethod, pwd);
   }

   public List<Operation> changeKeys(String accounts, String newEncPubKey, String newB58PubKey, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      return getEngineWriter().changeKeys(accounts, newEncPubKey, newB58PubKey, fee, payload, payloadMethod, pwd);
   }

   public DecodeOpHashResult decodeOpHash(String ophash) {
      return getEngineTools().decodeOpHash(ophash);
   }

   public PublicKey decodePubKey(String encPubKey, String b58PubKey) {
      return getEngineReader().decodePubKey(encPubKey, b58PubKey);
   }

   public Operation delistAccountForSale(Integer accountTarget, Integer accountSigner, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      return getEngineWriter().delistAccountForSale(accountTarget, accountSigner, fee, payload, payloadMethod, pwd);
   }

   public String encodePubKey(KeyType ecNid, String x, String y) {
      return getEngineReader().encodePubKey(ecNid, x, y);
   }

   public List<Operation> executeOperations(String rawOperations) {

      return null;
   }

   public List<Account> findAccounts(String name, Boolean exact, Integer type, Boolean listed, Double minBalance, Double maxBalance, Integer start, Integer max) {
      return getEngineReader().findAccounts(name, exact, type, listed, minBalance, maxBalance, start, max);
   }

   public List<Account> findAccounts(String name, String nameSearchType, Integer type, String statusType, Double minBalance, Double maxBalance, Integer start, Integer max) {
      return getEngineReader().findAccounts(name, nameSearchType, type, statusType, minBalance, maxBalance, start, max);
   }

   public List<Account> findAccounts(String name, Integer type, Integer start, Integer max) {
      return getEngineReader().findAccounts(name, type, start, max);
   }

   public List<Account> findAccountsByName(String name, String nameSearchType, Integer start, Integer max) {
      return this.findAccounts(name, nameSearchType, null, null, null, null, start, max);
   }

   public Operation findNOperation(Integer account, Integer nOperation) {
      return getEngineReader().findNOperation(account, nOperation);
   }

   public List<Operation> findNOperations(Integer account, Integer nOperationMin, Integer nOperationMax, Integer startBlock) {
      return getEngineReader().findNOperations(account, nOperationMin, nOperationMax, startBlock);
   }

   public Operation findOperation(String ophash) {
      return getEngineReader().findOperation(ophash);
   }

   public Account getAccount(Integer account) {
      return getEngineReader().getAccount(account);
   }

   public List<Operation> getAccountOperations(Integer account, Integer depth, Integer start, Integer max) {
      return getEngineReader().getAccountOperations(account, depth, start, max);
   }

   public List<Operation> getAccountOperations(Integer account, Integer startblock, Integer depth, Integer start, Integer max) {
      return getEngineReader().getAccountOperations(account, startblock, depth, start, max);
   }

   public Block getBlock(Integer block) {
      return getEngineReader().getBlock(block);
   }

   public Integer getBlockCount() {
      return getEngineReader().getBlockCount();
   }

   public Operation getBlockOperation(Integer block, Integer opblock) {
      return getEngineReader().getBlockOperation(block, opblock);
   }

   public List<Operation> getBlockOperations(Integer block, Integer start, Integer max) {
      return getEngineReader().getBlockOperations(block, start, max);
   }

   public List<Block> getBlocks(Integer last, Integer start, Integer end) {
      return getEngineReader().getBlocks(last, start, end);
   }

   public List<Connection> getConnections() {
      return getEngineTools().getConnections();
   }

   JPascJsonRPCEngineReader getEngineReader() {
      if (engineReader == null) {
         engineReader = new JPascJsonRPCEngineReader(jjc, getSession());
      }
      return engineReader;
   }

   JPascJsonRPCEngineTools getEngineTools() {
      if (engineTools == null) {
         engineTools = new JPascJsonRPCEngineTools(jjc, getSession());
      }
      return engineTools;
   }

   public JPascJsonRPCEngineWriter getEngineWriter() {
      if (engineWriter == null) {
         engineWriter = new JPascJsonRPCEngineWriter(jjc, getSession());
      }
      return engineWriter;
   }

   public NodeStatus getNodeStatus() {
      return getEngineTools().getNodeStatus();
   }

   public List<Operation> getPendings() {
      return getEngineReader().getPendings();
   }

   public List<Operation> getPendings(Integer start, Integer max) {
      return getEngineReader().getPendings(start, max);
   }

   public Integer getPendingsCount() {
      return getEngineReader().getPendingsCount();
   }

   public List<Account> getWalletAccounts(String encPubKey, String b58PubKey, Integer start, Integer max) {
      return getEngineReader().getWalletAccounts(encPubKey, b58PubKey, start, max);
   }

   public Integer getWalletAccountsCount(String encPubKey, String b58PubKey) {
      return getEngineReader().getWalletAccountsCount(encPubKey, b58PubKey);
   }

   public Double getWalletCoins(String encPubKey, String b58PubKey) {
      return getEngineReader().getWalletCoins(encPubKey, b58PubKey);
   }

   public PublicKey getWalletPubKey(String encPubKey, String b58PubKey) {
      return getEngineReader().getWalletPubKey(encPubKey, b58PubKey);
   }

   public List<PublicKey> getWalletPubKeys(Integer start, Integer max) {
      return getEngineReader().getWalletPubKeys(start, max);
   }

   public Operation listAccountForSale(Integer accountTarget, Integer accountSigner, Double price, Integer sellerAccount, String newB58PubKey, String newEncPubKey, Integer lockedUntilBlock, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      return getEngineWriter().listAccountForSale(accountTarget, accountSigner, price, sellerAccount, newB58PubKey, newEncPubKey, lockedUntilBlock, fee, payload, payloadMethod, pwd);
   }

   public Boolean lock() {
      return getEngineTools().lock();
   }

   public MultiOperation multiOperationAddOperation(String rawoperations, Boolean autoNOperation, List<OpSender> senders, List<OpReceiver> receivers, List<OpChanger> changers) {

      return null;
   }

   public MultiOperation multiOperationDeleteOperation(String rawoperations, Integer index) {

      return null;
   }

   public MultiOperation multiOperationSignOffline(String rawoperations, List<AccountKey> signers) {

      return null;
   }

   public MultiOperation multiOperationSignOnline(String rawoperations) {

      return null;
   }

   public List<Operation> operationsInfo(String rawOperations) {

      return null;
   }

   public DecryptedPayload payloadDecrypt(String payload, String[] pwds) {
      return getEngineReader().payloadDecrypt(payload, pwds);
   }

   public String payloadEncrypt(String payload, String payloadMethod, String pwd, String encPubKey, String b58PubKey) {
      return getEngineTools().payloadEncrypt(payload, payloadMethod, pwd, encPubKey, b58PubKey);
   }

   public Operation sendTo(Integer sender, Integer target, Double amount, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd) {
      return getEngineWriter().sendTo(sender, target, amount, fee, payload, payloadMethod, pwd);
   }

   public Boolean setWalletPassword(String pwd) {
      return getEngineTools().setWalletPassword(pwd);
   }

   public RawOperation signBuyAccount(Integer buyerAccount, Integer accountToPurchase, Double price, Integer sellerAccount, String newB58PubKey, String newEncPubKey, Double amount, Integer lastNOperation, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd,
         String signerB58PubKey, String signerEncPubKey, String rawOperations) {

      return null;
   }

   public Operation signChangeAccountInfo(Integer accountTarget, Integer accountSigner, String newEncPubkey, String newB58PubKey, String newName, Short newType, Integer lastNOperation, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd, String signerB58PubKey,
         String signerEncPubKey, String rawOperations) {

      return null;
   }

   public RawOperation signChangeKey(Integer account, Integer accountSigner, String oldEncPubKey, String oldB58PubKey, String newEncPubKey, String newB58PubKey, Integer lastNOperation, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd, String rawOperations) {

      return null;
   }

   public RawOperation signDelistAccountForSale(Integer accountTarget, Integer accountSigner, Integer lastNOperation, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd, String signerB58PubKey, String signerEncPubKey, String rawOperations) {

      return null;
   }

   public RawOperation signListAccountForSale(Integer accountTarget, Integer accountSigner, Double price, Integer sellerAccount, String newB58PubKey, String newEncPubKey, Integer lockedUntilBlock, Integer lastNOperation, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd,
         String signerB58PubKey, String signerEncPubKey, String rawOperations) {

      return null;
   }

   public SignResult signMessage(String digest, String encPubKey, String b58PubKey) {
      return getEngineTools().signMessage(digest, encPubKey, b58PubKey);
   }

   public RawOperation signSendTo(Integer senderAccount, Integer targetAccount, String senderEncPubKey, String senderB58PubKey, String targetEncPubKey, String targetB58PubKey, Integer lastNOperation, Double amount, Double fee, byte[] payload, PayLoadEncryptionMethod payloadMethod, String pwd,
         String rawoperations) {

      return null;
   }

   public Boolean startNode() {
      return getEngineTools().startNode();
   }

   public Boolean stopNode() {
      return getEngineTools().stopNode();
   }

   public Boolean unlock(String pwd) {
      return getEngineTools().unlock(pwd);
   }

   public SignResult verifySign(String digest, String encPubKey, String signature) {
      return getEngineTools().verifySign(digest, encPubKey, signature);
   }

}
