package com.example.vostro.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by vostro on 27/8/16.
 */
public class ListViewFragment extends Fragment {

    ListView listView;
    LinearLayout linearLayout;
    ArrayList<String> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_view, null);
        listView = (ListView) rootView.findViewById(R.id.list_view);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.linear_layout_list_view);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 1; i < 21; i++) {
            arrayList.add("Listview Item " + i);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(linearLayout, (CharSequence) listView.getItemAtPosition(position),
                        Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
