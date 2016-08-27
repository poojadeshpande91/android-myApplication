package com.example.vostro.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vostro on 25/8/16.
 */
public class FragmentA extends Fragment //implements MainActivity.DataFromActivityToFragment
{

    TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, null);
        text = (TextView) rootView.findViewById(R.id.fragment_text);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

   /* @Override
    public void sendData(String data) {
        if(data != null)
        text.setText(data);
    }*/
}
