package pasa.cbentley.jpasc.jsonrpc.mapper;

import java.util.ArrayList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.NetProtocol;
import pasa.cbentley.jpasc.pcore.rpc.model.NetStats;
import pasa.cbentley.jpasc.pcore.rpc.model.NodeServer;
import pasa.cbentley.jpasc.pcore.rpc.model.NodeStatus;

public class MapperNodeStatus extends MapperAbstract<NodeStatus> {

   public MapperNodeStatus(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   
   public NodeStatus getT(JSONObjectGetter getter) {
      
      NodeStatus n = new NodeStatus(pc);
      n.setReady(getter.getBoolean("ready"));
      n.setLocked(getter.getBoolean("locked"));
      n.setVersion(getter.getString("version"));
      n.setStatusDescriptor(getter.getString("status_s"));
      n.setReadyDescriptor(getter.getString("ready_s"));
      n.setOpenssl(getter.getString("openssl"));
      n.setPort(getter.getShort("port"));
      n.setTimestamp(getter.getLong("timestamp"));
      
      JSONObject stats =  getter.getObject("netstats");
      JSONObjectGetter gs = new JSONObjectGetter(stats);
      NetStats ns = new NetStats(pc);
      ns.setActive(gs.getInteger("active"));
      
      ns.setTotalClients(gs.getInteger("tclients"));
      ns.setTotalServers(gs.getInteger("tservers"));
      ns.setTotal(gs.getInteger("total"));
      
      ns.setServersT(gs.getInteger("servers_t"));

      ns.setClients(gs.getInteger("clients"));
      ns.setServers(gs.getInteger("servers"));
      
      ns.setBytesReceived(gs.getLong("breceived"));
      ns.setBytesSent(gs.getLong("bsend"));
      
      n.setNetStats(ns);
      
      JSONObject protocol = getter.getObject("netprotocol");
      JSONObjectGetter getterProt = new JSONObjectGetter(protocol);
      
      NetProtocol np = new NetProtocol(pc);
      np.setAvailableVersion(getterProt.getInteger("ver_a"));
      np.setVersion(getterProt.getInteger("ver"));
      n.setNetProtocol(np);

      n.setNodeServers(jjc.getMappers().getMapperNodeServer().getList(getter.getArray("nodeservers")));
      
      return n;
   }
}
