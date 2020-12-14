package pasa.cbentley.jpasc.jsonrpc.mapper;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.NodeServer;
import pasa.cbentley.jpasc.pcore.rpc.model.OpReceiver;
import pasa.cbentley.jpasc.pcore.rpc.model.OpSender;

public class MapperNodeServer extends MapperAbstract<NodeServer> {

   public MapperNodeServer(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public NodeServer getT(JSONObjectGetter get) {
      NodeServer nodeServer = new NodeServer(pc);
      nodeServer.setIP(get.getString("ip"));
      nodeServer.setPort(get.getShort("port"));
      nodeServer.setAttempts(get.getInteger("attempts"));
      nodeServer.setLastConnect(get.getLong("lastcon"));
      return nodeServer;
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, MapperNodeServer.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, MapperNodeServer.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
