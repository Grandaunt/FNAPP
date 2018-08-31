package com.bcm.havoc.fnapp.Base.utils;

import android.util.Log;

import com.bcm.havoc.fnapp.Base.entity.SectionEntity;
import com.bcm.havoc.fnapp.Base.entity.ServiceListEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TAO_SX on 2016/6/28/028.
 */
public class JsonUtils {
    public static <T> T getPerson(String jsonString, Class<T> cls) {
        T t = null;

        try {
//            Gson gson = new Gson();
            Gson gson  = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
            t = gson.fromJson(jsonString, cls);
        } catch (Exception e) {
            Log.e("json_error:",e.toString());
        }

        return t;
    }
//    public static String  toJson( Object cls) {
//        Gson gson = new GsonBuilder()
//                .serializeNulls()
//                .create();
//        String t = null;
//
//        try {
////            Gson gson = new Gson();
//            Gson gson  = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
//            t = gson.toJson(cls);
//        } catch (Exception e) {
//            Logger.e("json_error:",e.toString());
//        }
//
//        return t;
//    }
    public static <T> ServiceListEntity<T> getServiceListEntity(String jsonString, Class<T> cls) {
        ServiceListEntity<T> listEntity = new ServiceListEntity<T>();

        try {

            JsonObject jsonObjects = new Gson().fromJson(jsonString, JsonObject.class);
            String status = jsonObjects.get("Status").getAsString();
            String msg = jsonObjects.get("Msg").getAsString();
            jsonObjects.get("Data").getAsJsonArray();

            List<T> arrayList = new ArrayList<T>();
            for (JsonElement jsonObject : jsonObjects.get("Data").getAsJsonArray())
            {
                arrayList.add(new Gson().fromJson(jsonObject, cls));
            }
            listEntity.setData(arrayList);
            listEntity.setMsg(msg);
            listEntity.setStatus(status);
        } catch (Exception e) {
            Log.e("json_error:",e.toString());
        }

        return listEntity;
    }

    public static <T> SectionEntity.ServiceEntity<T> getServiceEntity(String jsonString, Class<T> cls) {
        SectionEntity.ServiceEntity<T> entity = new SectionEntity.ServiceEntity<T>();

        try {

            JsonObject jsonObjects = new Gson().fromJson(jsonString, JsonObject.class);
            String status = jsonObjects.get("Status").getAsString();
            String msg = jsonObjects.get("Msg").getAsString();
            T data = new Gson().fromJson(jsonObjects.get("Data").getAsJsonObject(), cls);

            entity.setStatus(status);
            entity.setMsg(msg);
            entity.setData(data);
        } catch (Exception e) {
            Log.e("json_error:",e.toString());
        }

        return entity;
    }
//    public static <T> ServiceAllListEntity<T> getEntityAllList(String jsonString, Class<T> cls){
//        ServiceAllListEntity<T> serviceentity = new ServiceAllListEntity<T>();
//        Stock_ALL<T> alldata = new Stock_ALL<T>();
//        try {
//
//            JsonObject jsonObjects = new Gson().fromJson(jsonString, JsonObject.class);
//            String status = jsonObjects.get("Status").getAsString();
//            String msg = jsonObjects.get("Msg").getAsString();
//
//            T data = (T)jsonObjects.get("Data");
//            JsonObject jda = new Gson().fromJson((JsonElement) data, JsonObject.class);
////            Class cls = e.getClass();
//            Field[] fields = cls.getDeclaredFields();
//            for(int i=0; i<fields.length; i++) {
//                Field f = fields[i];
//                f.setAccessible(true);
////                System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(e));
//                JsonArray stockinAr = (JsonArray) jda.get(f.getName());
//                List<T> arrayList = new ArrayList<T>();
//                Class c = Class.forName("com.bcm.havoc.warehousemanagement.Entity." + f.getName());
//                if (stockinAr.size() >= 1) {
//                    for (JsonElement jsonObject : stockinAr) {
//
//                        arrayList.add((T) new Gson().fromJson(jsonObject, c));//forName(f.getName())"com/bcm/havoc/warehousemanagement/Entity/"+
//                    }
//                }
//
//                switch (i) {
//                    case 0:
//                        alldata.setStock_CHECK((List<Stock_CHECK>) arrayList);
//                        break;
//                    case 1:
//                        alldata.setStock_CHECK_Detail((List<Stock_CHECK_Detail>) arrayList);
//                        break;
//                    case 2:
//                        alldata.setStock_IN((List<Stock_IN>) arrayList);
//                        break;
//                    case 3:
//                        alldata.setStock_IN_Detail((List<Stock_IN_Detail>) arrayList);
//                        break;
//                    case 4:
//                        alldata.setStock_OUT((List<Stock_OUT>) arrayList);
//                        break;
//                    case 5:
//                        alldata.setStock_OUT_Detail((List<Stock_OUT_Detail>) arrayList);
//                        break;
//                }
//            }
//
//
////                T data = arrayList;
////                Stock_ALL alldata= new Stock_ALL();
////                alldata.
////                f.getName();
////                Stock_ALL<T> alldata= new Stock_ALL<T>();
////                alldata.set
////                Object object = new Object();
////                object[f.getName()]=arrayList;
////                        cls.newInstance();
////                StringBuffer s=new StringBuffer();
////                s.append()
////                =arrayList;
////                cls ss = new cls;
////            }
//            serviceentity.setStatus(status);
//            serviceentity.setMsg(msg);
//            serviceentity.setData((T) alldata);
//
////            Stock_ALL stock_all =new Stock_ALL();
////            Stock_IN stock_in =new Stock_IN();
////            List<T> arrayList = new ArrayList<T>();
////            JsonObject data= new Gson().fromJson(jsonObjects.get("Data"), JsonObject.class);
//////            JsonArray stock_inlist =  data.get("Stock_IN").getAsJsonArray();
////                        for (JsonElement jsonObject : data.get("Stock_IN").getAsJsonArray())
////            {
////
////                arrayList.add((T) new Gson().fromJson(jsonObject, (Type) stock_in));
////            }
////            stock_all.setStock_IN_List((ArrayList<Stock_IN>) arrayList);
////            data.get("Stock_IN").getAsJsonArray();
////            Stock_ALL<T> entity = new Stock_ALL<T>();
////            entity.
////            List<T> arrayList = new ArrayList<T>();
////            for (JsonElement jsonObject : data.get("Stock_IN").getAsJsonArray())
////            {
////                arrayList.add(new Gson().fromJson(jsonObject, cls));
////            }
////            T data = new Gson().fromJson(jsonObjects.get("Data").getAsJsonObject(), cls);
////            String aes=jsonObjects.get("Data").getAsString();
////            JsonPrimitive ap=jsonObjects.get("Data").getAsJsonPrimitive();
//
////            ArrayList<JsonObject> dataas = new Gson().fromJson(jsonObjects.get("Data").getAsJsonObject(), type);
//
////            ArrayList<T> arrayList = new ArrayList<>();
////            for (JsonObject jsonObject : data)
////            {
////                arrayList.add(new Gson().fromJson(jsonObject, cls));
////            }
//////
////            serviceentity.setStatus(status);
////            serviceentity.setMsg(msg);
////            serviceentity.setData((T) stock_all);
//        } catch (Exception e) {
//            Log.e("json_error:",e.toString());
//        }
//
//        return serviceentity;
//    }

        public static <T> ArrayList<T> getEntityArrayList(String jsonString, Class<T> cls){

        Type type = new TypeToken<ArrayList<JsonObject>>() {}.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(jsonString, type);

        ArrayList<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects)
        {
            arrayList.add(new Gson().fromJson(jsonObject, cls));
        }
        return arrayList;
    }



    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringNullAdapter();
        }
    }
    public static class StringNullAdapter extends TypeAdapter<String> {
        @Override
        public String read(JsonReader reader) throws IOException {
            // TODO Auto-generated method stub
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }
        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            // TODO Auto-generated method stub
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
}
