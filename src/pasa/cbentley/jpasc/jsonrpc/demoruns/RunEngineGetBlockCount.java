package pasa.cbentley.jpasc.jsonrpc.demoruns;

import pasa.cbentley.jpasc.pcore.client.IPascalCoinClient;

public class RunEngineGetBlockCount extends RunEngineAbstract {

   public RunEngineGetBlockCount() {
   }

   public static void main(String[] args) {
      RunEngineGetBlockCount demo = new RunEngineGetBlockCount();
      demo.run();
   }

   public void run(IPascalCoinClient client) {
      
      Integer bc = client.getBlockCount();

      //#debug
      toDLog().pAlways("blockcount="+bc, this, RunEngineGetBlockCount.class, "run", LVL_05_FINE, false);
   }


}
