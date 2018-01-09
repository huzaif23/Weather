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
        String[] dayTemp = new String[7];
        String[] nightTemp = new String[7];
        String[] eveTemp = new String[7];
        String[] morningTemp = new String[7];
        String[] forecast = new String[7];
        try {
            JSONObject jsonObject = new JSONObject(x);
            JSONArray items = jsonObject.getJSONArray("list");

            JSONObject[] afterList = new JSONObject[items.length()];
           for (int i=0;i<items.length();i++) {
           afterList[i] = items.getJSONObject(i);
           }
            JSONObject[] main=new JSONObject[afterList.length];
            JSONArray[] desc = new JSONArray[afterList.length];


           for (int m=0;m<afterList.length;m++) {
               main[m] = afterList[m].getJSONObject("temp");

              dayTemp[m] = main[m].getString("day");
              nightTemp[m] = main[m].getString("night");
              eveTemp[m] = main[m].getString("eve");
              morningTemp[m] = main[m].getString("morn");

           }

            JSONObject q[] = new JSONObject[afterList.length];
            for (int n=0;n<afterList.length;n++) {
                desc[n] = afterList[n].getJSONArray("weather");
                q[n] = desc[n].getJSONObject(0);
               forecast[n] = q[n].getString("main");

            }
            return new Constants(dayTemp,nightTemp,eveTemp,morningTemp,forecast);
            }


         catch (JSONException e) {

            Log.e("multi","error"+e);
        }
            return null;

    }

    @Override
    protected void onPostExecute(String s) {
        Constants c;
       c = processResultMulti(s);
        as.test(c);
    }

    @Override
    protected String doInBackground(String... param) {
        String[] params = {"https://api.openweathermap.org/data/2.5/forecast/daily?lat=24.946218&lon=67.005615&appid=cf761f0ca67ee1e7305f44199a1a9128&cnt=7&units=metric"};
          return super.doInBackground(params);

    }


    }
