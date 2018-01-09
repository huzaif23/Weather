package com.weather.project.weather.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weather.project.weather.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Muhammad Huzaifa on 12/29/2017.
 */

public class list_adapter extends ArrayAdapter<String> {

    Activity context;
    String[] data ;
    String[] b ;
    String[] c ;
    String[] d ;
    String[] main;
    Double[] ar = new Double[7];
    int resource[] = new int[7];
    String[] week = new String[7];
    public list_adapter(Activity context,String [] data,String[] b,String[] c,String[] d,String[] main) {
        super(context, R.layout.list_item,data);
        this.context = context;
        this.data = data;
        this.b = b;
        this.c = c;
        this.d = d;
        this.main = main;
        getDate();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.list_item,null,true);
        TextView temp = (TextView) v.findViewById(R.id.t1);
        TextView date = (TextView) v.findViewById(R.id.t2);
        ImageView img = (ImageView) v.findViewById(R.id.img);
        for (int i = 0 ; i < 7;i++){
            ar[i] = Double.parseDouble(data[i]);

        }
        Log.e("multi",""+main[position]);
        main[position] = main[position].toLowerCase();
        resource[position] = parent.getResources().getIdentifier(main[position],"drawable",context.getPackageName());
        Picasso.with(context).load(resource[position]).into(img);
        temp.setText(""+ar[position].shortValue()+" C");
//
//        SimpleDateFormat inFormat = new SimpleDateFormat("dd MMM yyyy");
//        String dates = inFormat.format(new Date());
//
//        String goal=null;
//        try {
//
//            Date datess = inFormat.parse(dates);
//            SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
//            goal= outFormat.format(datess);
//
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        date.setText(goal+", "+dates);

        date.setText(""+week[position]);
        return v;
    }


    public void getDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,calendar.get(Calendar.DAY_OF_MONTH));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd MMM yyyy");
        for (int i=0;i<7;i++) {
            calendar.add(Calendar.DAY_OF_WEEK,1);
            week[i] = simpleDateFormat.format(calendar.getTime());
            Log.e("multi",""+simpleDateFormat.format(calendar.getTime()));
        }

    }

}
