package com.weather.project.weather;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MultipleData extends sCapture {

        AsyncResult as=null;
    Constants processResultMulti(String x) {
        final String WEATHER="weather";
        final String MAIN = "main";
        final String TEMP = "temp";
        String[] temp = new String[5];
        String[] forecast = new String[5];
        try {
            JSONObject jsonObject = new JSONObject(x);
            JSONArray items = jsonObject.getJSONArray("list");

            JSONObject[] afterList = new JSONObject[items.length()];
           for (int i=0;i<items.length();i++) {
           afterList[i] = items.getJSONObject(i);
           }
            JSONObject[] main=new JSONObject[afterList.length];
            JSONArray[] desc = new JSONArray[afterList.length];

           for (int m=0;m<5;m++) {
               main[m] = afterList[m].getJSONObject("main");

               Log.e("multi","g"+main[m]);}

            JSONObject q[] = new JSONObject[afterList.length];
            for (int n=0;n<afterList.length;n++) {
                desc[n] = afterList[n].getJSONArray("weather");
                q[n] = desc[n].getJSONObject(0);
                Log.e("multi",""+q[n].getString("main"));
            }







            return new Constants();
            }


         catch (JSONException e) {

            Log.e("multi","error"+e);
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
        Constants c;
       c = processResultMulti(s);
        as.test(c);
    }

    @Override
    protected String doInBackground(String... param) {
        String[] params = {"https://api.openweathermap.org/data/2.5/forecast?lat=35&lon=167&appid=cf761f0ca67ee1e7305f44199a1a9128&units=metric"};
          return super.doInBackground(params);

    }


    }
