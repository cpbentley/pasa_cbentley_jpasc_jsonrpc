package pasa.cbentley.jpasc.jsonrpc.demoruns;

import java.util.List;

import pasa.cbentley.jpasc.pcore.client.IPascalCoinClient;
import pasa.cbentley.jpasc.pcore.rpc.model.Account;

public class RunEngineGetKeyAccounts extends RunEngineAbstract {

   public RunEngineGetKeyAccounts() {
   }

   public static void main(String[] args) {
      RunEngineGetKeyAccounts demo = new RunEngineGetKeyAccounts();
      demo.run();
   }

   public void run(IPascalCoinClient client) {

      String encPubKey = "CA0220004C854D6AB75D62BB6F02450505DE6C54B83F6130EEA3F702E1887C2A5323EB5020004A2A9F69DE76F090EB1EDAA11A47E98B2EC8AA53B09AEDA364196EDCB549D7F7";
      String b58PubKey = null;
      Integer count = client.getWalletAccountsCount(encPubKey, b58PubKey);

      //#debug
      toDLog().pAlways("count="+count, null, RunEngineGetKeyAccounts.class, "run", LVL_05_FINE, false);
      
      List<Account> walletAccounts = client.getWalletAccounts(encPubKey, b58PubKey,0,count);
      
      int i = 0;
      for (Account ac : walletAccounts) {
         i++;
         //#debug
         toDLog().pAlways("i="+i, ac, RunEngineGetKeyAccounts.class, "run", LVL_05_FINE, false);
      }

   }

}
