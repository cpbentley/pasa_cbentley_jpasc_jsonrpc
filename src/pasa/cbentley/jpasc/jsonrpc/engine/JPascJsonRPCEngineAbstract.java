package pasa.cbentley.jpasc.jsonrpc.engine;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.ctx.ObjectJascJsonRpc;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperAccount;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperBlock;
import pasa.cbentley.jpasc.jsonrpc.mapper.MapperOperation;
import pasa.cbentley.jpasc.pcore.rpc.exception.RPCApiException;
import pasa.cbentley.jpasc.pcore.rpc.exception.RPCException;

public abstract class JPascJsonRPCEngineAbstract extends ObjectJascJsonRpc {

   public JPascJsonRPCEngineAbstract(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public JPascJsonRPCEngineAbstract(JPascJsonRpcCtx jjc, JSONRPC2Session session) {
      super(jjc);
      this.session = session;
   }

   private JSONRPC2Session session;


   public JSONRPC2Session getSession() {
      if (session == null) {
         throw new IllegalStateException("Session must be set");
      }
      return session;
   }

   public MapperAccount getMapperAccount() {
      return jjc.getMappers().getMapperAccount();
   }

   public MapperOperation getMapperOperation() {
      return jjc.getMappers().getMapperOperation();
   }

   public MapperBlock getMapperBlock() {
      return jjc.getMappers().getMapperBlock();
   }

   public void connect(String ip, int port) {
      URL serverURL = null;
      String urlString = "http://" + ip + ":" + port;
      try {
         serverURL = new URL(urlString);

      } catch (MalformedURLException e) {
         // handle exception...
      }

      // Create new JSON-RPC 2.0 client session
      session = new JSONRPC2Session(serverURL);
   }

   protected Object launchRequest(String method) {
      return launchRequest(method, null);
   }

   protected Object launchRequest(String method, Map<String, Object> params) {
      Long requestID = jjc.getNextRequestID();
      JSONRPC2Request request = new JSONRPC2Request(method, params, requestID);
      // Send request
      JSONRPC2Response response = null;
      try {
         response = session.send(request);
      } catch (JSONRPC2SessionException e) {
         throw new RPCException(e, "while sending request for " + method);
      }

      // Print response result / error
      Long reqR = (Long) response.getID();
      if (requestID.longValue() != reqR.longValue()) {
         throw new RPCApiException("Wrong response ID " + reqR.longValue());
      }

      if (response.indicatesSuccess()) {
         Object o = response.getResult();
         return o;
      } else {
         throw new RPCApiException(response.getError().getMessage());
      }
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, JPascJsonRPCEngineAbstract.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, JPascJsonRPCEngineAbstract.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
