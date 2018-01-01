package com.weather.project.weather;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetData  {
    public String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?";
    public String LATITUDE = "lat=";
    public String LONGITUDE = "&lon=";
    public String APP_ID = "&appid=";
    public String API_KEY = "cf761f0ca67ee1e7305f44199a1a9128";
    public String CurrentWeatherURL = BASE_URL + LATITUDE + "24.946218" + LONGITUDE + "67.005615" + APP_ID + API_KEY;
    public static String data;

}

    class sCapture extends AsyncTask<String,Void,String> {
        String main,desc;
        Constants cons;
        AsyncResult as = null;
        @Override
        protected void onPostExecute(String s) {
            cons= processResult(s);
            as.result(cons);
            Log.e("result",""+s);

        }
        Constants processResult(String x) {

            final String WEATHER="weather";
            final String MAIN = "main";
            final String TEMP = "temp";
            final String NAME = "name";
            final String DESC = "description";
            final String HUMIDITY = "humidity";


            try {

                JSONObject jsonObject = new JSONObject(x);

                JSONArray jsonArray =  jsonObject.getJSONArray(WEATHER);
                for (int i = 0;i<jsonArray.length();i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    main = jsonObject1.getString(MAIN);
                    desc = jsonObject1.getString(DESC);
                }
                JSONObject jsonObject2 = jsonObject.getJSONObject(MAIN);
                Double temp = jsonObject2.getDouble(TEMP);
                String city = jsonObject.getString(NAME);
                Double humid = jsonObject2.getDouble(HUMIDITY);

                Constants con = new Constants(temp,main,desc,humid,city);
                cons =con;

                Log.e("result",""+cons.getDesc()+cons.getCity()+cons.getMain());
                return cons;
            } catch (JSONException e) {
                Log.e("errors",""+e);
            }

            return null;
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader bufferedReader = null;
            try {
                URL url = new URL(params[0]);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                if(inputStream == null) {
                    return null;
                }

                StringBuffer buffer = new StringBuffer();

                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while((line = bufferedReader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                return buffer.toString();

            } catch(IOException e) {
                Log.e("a", "Error", e);
                return null;
            } finally {
                if(urlConnection != null) {
                    urlConnection.disconnect();
                }
                if(bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch(final IOException e) {
                        Log.e("a","Error closing stream", e);
                    }
                }
            }
        }



        }




