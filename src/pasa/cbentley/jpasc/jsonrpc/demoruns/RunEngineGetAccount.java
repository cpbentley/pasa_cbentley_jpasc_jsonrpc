package pasa.cbentley.jpasc.jsonrpc.demoruns;

import pasa.cbentley.jpasc.pcore.client.IPascalCoinClient;
import pasa.cbentley.jpasc.pcore.rpc.model.Account;

public class RunEngineGetAccount extends RunEngineAbstract {

   public RunEngineGetAccount() {
   }

   public static void main(String[] args) {
      RunEngineGetAccount demo = new RunEngineGetAccount();
      demo.run();
   }

   public void run(IPascalCoinClient client) {

      Account bc = client.getAccount(145090);

      //#debug
      toDLog().pAlways("Account=", bc, RunEngineGetAccount.class, "run", LVL_05_FINE, false);
   }

}
