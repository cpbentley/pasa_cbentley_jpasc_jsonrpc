package pasa.cbentley.jpasc.jsonrpc.demoruns;

import java.util.List;

import pasa.cbentley.jpasc.pcore.client.IPascalCoinClient;
import pasa.cbentley.jpasc.pcore.domain.operations.OperationJavaChangeAccountInfo;
import pasa.cbentley.jpasc.pcore.rpc.model.Account;

public class RunEngineUpdateTypes extends RunEngineAbstract {

   private Short newType = 1;

   private Double fee = 0.0001;
   
   public RunEngineUpdateTypes() {
   }

   public static void main(String[] args) {
      RunEngineUpdateTypes demo = new RunEngineUpdateTypes();
      demo.run();
      
   }

   public void run(IPascalCoinClient client) {
      
      //pc.getRPCConnection().connectLocalhost();
      
      newType = 15;
      fee = 0.0001;
      String encPubKey = "CA0220001BFEB7017228EE18D25DA4CF6014F34B4D12CA49A642FA46EE0CCCFE55CDD72B20009C2887C9E82245FA5D5D880EC61BE2347A76BE591EF4ADC046C9F11C4FECD02A";
      String b58PubKey = null;
      Integer count = client.getWalletAccountsCount(encPubKey, b58PubKey);

      //#debug
      toDLog().pAlways("count=" + count, null, RunEngineUpdateTypes.class, "run", LVL_05_FINE, false);

      List<Account> walletAccounts = client.getWalletAccounts(encPubKey, b58PubKey, 0, count);

      Integer blockCount = client.getBlockCount();
      
      double balance = 2;
      Account payer = getPayer(walletAccounts,balance);

      int i = 0;
      for (Account ac : walletAccounts) {
         i++;
         //#debug
         toDLog().pAlways("i=" + i, ac, RunEngineUpdateTypes.class, "run", LVL_05_FINE, false);

         Integer accountTarget = ac.getAccount();
         Integer accountSigner = payer.getAccount();

         Integer active = ac.getUpdatedBlockActive();
         int diff = blockCount - active;
         if(diff < 100000) {
            //#debug
            toDLog().pAlways("Skipping account " + accountTarget + " diff="+diff, null, RunEngineUpdateTypes.class, "run", LVL_05_FINE, false);

            continue;
         }
         OperationJavaChangeAccountInfo op = new OperationJavaChangeAccountInfo(pc);
         op.setAccountSigner(accountSigner);
         op.setAccountTarget(accountTarget);
         op.setNewType(newType);
         op.setFee(fee);
         
         op.doValidateParams();
         
         boolean success = op.execute();
         
         if(!success) {
            //#debug
            toDLog().pAlways("Failed Op", op, RunEngineUpdateTypes.class, "run", LVL_05_FINE, false);

         }
      }

   }

   private Account getPayer(List<Account> acs, double balance) {
      for (Account ac : acs) {
         if (ac.getBalance() > balance) {
            return ac;
         }
      }
      return null;
   }

}
