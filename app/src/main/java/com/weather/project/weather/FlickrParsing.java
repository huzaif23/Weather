package com.weather.project.weather;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MultipleData extends sCapture {

AsyncResult as=null;
    String[] processResultMulti(String x) {
        final String WEATHER="weather";
        final String MAIN = "main";
        final String TEMP = "temp";

        try {
            JSONObject jsonObject = new JSONObject(x);
            JSONArray items = jsonObject.getJSONArray("list");

            JSONObject[] jsonObjects = new JSONObject[5];
            JSONObject[] main = new JSONObject[5];
            String[] temp = new String[5];
            for (int i =0 ; i<5;i++) {
                jsonObjects[i] = items.getJSONObject(i);

                 main[i] = jsonObjects[i].getJSONObject("main");

                temp[i]= main[i].getString("temp");
                Log.e("multi",""+temp[i]);
            }
            return temp;
        } catch (JSONException e) {
            e.printStackTrace();
        }
            return null;

    }


//    Constants processResult() {
//        final String WEATHER="weather";
//        final String MAIN = "main";
//        final String TEMP = "temp";
//        final String NAME = "name";
//        final String DESC = "description";
//        final String HUMIDITY = "humidity";
//
//
//        try {
//
//            JSONObject jsonObject = new JSONObject(data);
//
//            JSONArray jsonArray =  jsonObject.getJSONArray(WEATHER);
//            for (int i = 0;i<jsonArray.length();i++) {
//                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                main = jsonObject1.getString(MAIN);
//                 desc = jsonObject1.getString(DESC);
//            }
//            JSONObject jsonObject2 = jsonObject.getJSONObject(MAIN);
//            Double temp = jsonObject2.getDouble(TEMP);
//           String city = jsonObject.getString(NAME);
//            Double humid = jsonObject2.getDouble(HUMIDITY);
//
//            Constants con = new Constants(temp,main,desc,humid,city);
//            cons =con;
//
//            Log.e("result",""+cons.getDesc()+cons.getCity()+cons.getMain());
//            return cons;
//        } catch (JSONException e) {
//            Log.e("errors",""+e);
//        }
//
//        return null;
//    }


    @Override
    protected void onPostExecute(String s) {
        String[] res;
        res = processResultMulti(s);
        as.test(res);
    }

    @Override
    protected String doInBackground(String... param) {
        String[] params = {"https://api.openweathermap.org/data/2.5/forecast?lat=35&lon=167&appid=cf761f0ca67ee1e7305f44199a1a9128"};
          return super.doInBackground(params);

    }


    }
