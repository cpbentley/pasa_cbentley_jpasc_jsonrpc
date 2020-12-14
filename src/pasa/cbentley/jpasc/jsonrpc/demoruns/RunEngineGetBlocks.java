package pasa.cbentley.jpasc.jsonrpc.demoruns;

import java.util.List;

import pasa.cbentley.core.src5.log.StringableList;
import pasa.cbentley.jpasc.pcore.client.IPascalCoinClient;
import pasa.cbentley.jpasc.pcore.rpc.model.Block;

public class RunEngineGetBlocks extends RunEngineAbstract {

   public RunEngineGetBlocks() {
   }

   public static void main(String[] args) {
      RunEngineGetBlocks demo = new RunEngineGetBlocks();
      demo.run();
   }

   public void run(IPascalCoinClient client) {
      
      List<Block> bc = client.getBlocks(null,400000,400001);

      
      //#debug
      toDLog().pAlways("getBlocks 400000 400001", new StringableList(pc.getUCtx(),bc), RunEngineGetBlocks.class, "run", LVL_05_FINE, false);
   }


}
