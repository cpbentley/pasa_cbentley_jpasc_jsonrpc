package pasa.cbentley.jpasc.jsonrpc.engine;

import java.math.BigDecimal;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class JSONObjectGetter {

   private JSONObject p;

   public JSONObjectGetter(JSONObject p) {
      this.p = p;
   }

   public Short getShort(String key) {
      Object o = p.get(key);
      if (o == null) {
         return null;
      }
      if (o instanceof Short) {
         return (Short) o;
      } else if (o instanceof Long) {
         return new Short(((Long) o).shortValue());
      } else if (o instanceof Integer) {
         return new Short(((Integer) o).shortValue());
      }
      throw new IllegalArgumentException(o.toString() + " is not Short");
   }

   public Integer getInteger(String key) {
      Object o = p.get(key);
      if (o == null) {
         return null;
      }
      if (o instanceof Integer) {
         return (Integer) o;
      } else if (o instanceof Long) {
         return new Integer(((Long) o).intValue());
      }
      throw new IllegalArgumentException(o.toString() + " is not Integer");
   }

   public JSONArray getArray(String key) {
      return (JSONArray) p.get(key);
   }

   public JSONObject getObject(String key) {
      return (JSONObject) p.get(key);
   }

   public String getString(String key) {
      return (String) p.get(key);
   }

   public Boolean getBoolean(String key) {
      return (Boolean) p.get(key);
   }

   public Long getLong(String key) {
      return (Long) p.get(key);
   }

   /**
    * You can 
    * @param key
    * @return
    */
   public Double getDouble(String key) {
      Object o = p.get(key);
      if (o == null) {
         return null;
      }
      if (o instanceof Double) {
         return (Double) o;
      }
      if(o instanceof java.math.BigDecimal) {
         BigDecimal bd = (BigDecimal)o;
         return new Double(bd.doubleValue());
      }

      throw new IllegalArgumentException(o.toString() + " is not Double but is " + o.getClass().getName());
   }
}
