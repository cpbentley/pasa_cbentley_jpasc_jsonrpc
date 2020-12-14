package pasa.cbentley.jpasc.jsonrpc.mapper;

import java.util.ArrayList;
import java.util.List;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.ctx.ObjectJascJsonRpc;
import pasa.cbentley.jpasc.jsonrpc.engine.JSONObjectGetter;

public abstract class MapperAbstract<T> extends ObjectJascJsonRpc {

   public MapperAbstract(JPascJsonRpcCtx jjc) {
      super(jjc);
   }

   public List<T> getList(JSONArray array) {
      if (array != null) {
         ArrayList<T> list = new ArrayList<T>(array.size());
         for (int i = 0; i < array.size(); i++) {
            Object obj = array.get(i);
            if (obj instanceof JSONObject) {
               JSONObject o = (JSONObject) obj;
               JSONObjectGetter g = new JSONObjectGetter(o);
               T t = getT(g);
               if (t != null) {
                  list.add(t);
               }
            } else {
               //#debug
               throw new IllegalArgumentException();
            }
         }
         return list;
      }
      return null;
   }

   public T getT(JSONObject o) {
      JSONObjectGetter getter = new JSONObjectGetter(o);
      return getT(getter);
   }

   public abstract T getT(JSONObjectGetter get);
}
