package pasa.cbentley.jpasc.jsonrpc.mapper;

import net.minidev.json.JSONObject;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;
import pasa.cbentley.jpasc.pcore.rpc.model.Account;
import pasa.cbentley.jpasc.pcore.rpc.model.AccountState;

public class MapperAccount extends MapperAbstract<Account> {

   public MapperAccount(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public Account getT(JSONObjectGetter getter) {
      Account b = new Account(pc);
      b.setAccount(getter.getInteger("account"));
      b.setUpdatedBlockActive(getter.getInteger("updated_b_active_mode"));
      b.setUpdatedBlockPassive(getter.getInteger("updated_b_passive_mode"));
      b.setUpdatedB(getter.getInteger("updated_b"));
      b.setnOperation(getter.getInteger("n_operation"));
      b.setType(getter.getInteger("type"));

      b.setEncPubkey(getter.getString("enc_pubkey"));
      b.setName(getter.getString("name"));
      b.setBalance(getter.getDouble("balance"));
      b.setBalanceString(getter.getString("balance_s"));
      b.setSeal(getter.getString("seal"));
      b.setData(getter.getString("data"));

      String state = getter.getString("state");
      if (state.equals("normal")) {
         b.setState(AccountState.NORMAL);

      } else if (state.equals("listed")) {
         b.setState(AccountState.LISTED);
         b.setPrice(getter.getDouble("price"));
         b.setPriceString(getter.getString("price_s"));
         b.setPrivateSale(getter.getBoolean("private_sale"));
         b.setLockedUntilBlock(getter.getInteger("locked_until_block"));
         b.setSellerAccount(getter.getInteger("seller_account"));
      } else if (state.equals("coin_swap")) {
         b.setState(AccountState.COINSWAP);
         b.setAmountToSwap(getter.getDouble("amount_to_swap"));
         b.setAmountToSwapString(getter.getString("amount_to_swap_s"));
         b.setHashedSecret(getter.getString("hashed_secret"));
         b.setReceiverSwapAccount(getter.getInteger("receiver_swap_account"));
         b.setLockedUntilBlock(getter.getInteger("locked_until_block"));
      } else if (state.equals("account_swap")) {
         b.setLockedUntilBlock(getter.getInteger("locked_until_block"));
         b.setState(AccountState.ACCOUNTSWAP);
         b.setNewEncPubkey(getter.getString("new_enc_pubkey"));
         b.setHashedSecret(getter.getString("hashed_secret"));
      }
      return b;
   }
}
