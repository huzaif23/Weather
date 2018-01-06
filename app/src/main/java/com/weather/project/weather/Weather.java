package com.weather.project.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.weather.project.weather.Adapters.ViewPagerAdapter;
import com.weather.project.weather.Fragments.DetailFragment;
import com.weather.project.weather.Fragments.FragmentTwo;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Weather extends AppCompatActivity implements AsyncResult {

    TextView textView ;
    TextView textView1,temp;
    GetData getData;
    ImageView img;
    ViewPager pager;
    TabLayout tabLayout;

    ArrayList<android.support.v4.app.Fragment> list;
    String url = "https://api.openweathermap.org/data/2.5/forecast?lat=25&lon=167";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.date);
        textView1 = (TextView) findViewById(R.id.city);
        img = (ImageView) findViewById(R.id.imageView);
        temp = (TextView) findViewById(R.id.temp);
        list = new ArrayList<>();
        getData = new GetData();
        sCapture capture = new sCapture();
        capture.as = this;
        capture.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,getData.CurrentWeatherURL);
        String dates = DateFormat.getDateInstance().format(new Date());
        textView.setText(dates);
        MultipleData m  = new MultipleData();
        m.as=this;
        m.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,url);
        pager = (ViewPager) findViewById(R.id.pager);
//        tabLayout = (TabLayout) findViewById(R.id.tab);




    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void result(Constants c) {

        textView1.setText(c.getCity());
        String y = c.getMain().toLowerCase().trim();

        temp.setText(""+c.getTemperature().shortValue()+" C");
        Toast.makeText(this,""+y,Toast.LENGTH_LONG).show();
       int resource = getApplicationContext().getResources().getIdentifier(y,"drawable",getApplicationContext().getPackageName());
        Picasso.with(getApplicationContext()).load(R.drawable.clear).into(img);

    }

    @Override
    public void test(Constants x) {
        String[] t ={"5","4","234","234","234"};
         list.add(new DetailFragment(t));
        list.add(new FragmentTwo());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(viewPagerAdapter);

    }



//        public void retroFire() {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//            RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);
//
//            Call<Constants> call = service.getStudentDetails();
//
//            call.enqueue(new Callback<Constants>() {
//                @Override
//                public void onResponse(Response<Constants> response, Retrofit retrofit) {
//
//                    try {
//
//                        Toast.makeText(getApplicationContext(),""+response.message()
//                                ,Toast.LENGTH_LONG).show();
//
//                    } catch (Exception e) {
//                        Log.d("onResponse", "There is an error");
//                        e.printStackTrace();
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Throwable t) {
//                    Log.d("onFailure", t.toString());
//                }
//            });
//        }
//
//        void getRetrofitArray() {
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(CurrentWeatherURL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);
//
//        Call<List<Constants>> call = service.getStudentDetails();
//
//        call.enqueue(new Callback<List<Constants>>() {
//            @Override
//            public void onResponse(Response<List<Constants>> response, Retrofit retrofit) {
//
//                try {
//
//                    List<Constants> StudentData = response.body();
//
//                    for (int i = 0; i < StudentData.size(); i++) {
//
//                        if (i == 0) {
//                            constants.setMain("StudentId  :  " + StudentData.get(i).getMain());
//                            constants.setTemperature(StudentData.get(i).getTemperature());
//                            constants.setDesc("StudentMarks  : " + StudentData.get(i).getDesc());
//                        }
//                    }
//
//
//                } catch (Exception e) {
//                    Log.d("onResponse", "There is an error");
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Log.d("onFailure", t.toString());
//            }
//        });
//    }
    }


