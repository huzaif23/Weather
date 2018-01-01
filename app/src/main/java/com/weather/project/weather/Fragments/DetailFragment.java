package com.weather.project.weather.Fragments;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.weather.project.weather.Adapters.list_adapter;
import com.weather.project.weather.R;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class DetailFragment extends Fragment {


    list_adapter adapter;

String[] data;
    @SuppressLint("ValidFragment")
    public DetailFragment(String [] a) {
        data=a;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        ListView list = (ListView) v.findViewById(R.id.list);
        Activity activity = getActivity();
        adapter = new list_adapter(activity,data);
        list.setAdapter(adapter);
        return v;
    }


}
