package com.weather.project.weather.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.weather.project.weather.R;

/**
 * Created by Muhammad Huzaifa on 12/29/2017.
 */

public class list_adapter extends ArrayAdapter<String> {

    Activity context;
    String[] data ;
    Double[] ar = new Double[5];
    public list_adapter(Activity context,String [] data) {
        super(context, R.layout.list_item,data);
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.list_item,null,true);
        TextView temp = (TextView) v.findViewById(R.id.t1);
        TextView date = (TextView) v.findViewById(R.id.t2);
        ImageView img = (ImageView) v.findViewById(R.id.img);
        for (int i = 0 ; i < 5;i++){
            ar[i] = Double.parseDouble(data[i]);
        }
        temp.setText(""+ar[position].shortValue()+" C");
        return v;
    }

}
