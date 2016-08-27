package com.example.vostro.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by vostro on 25/8/16.
 */
public class LeftDrawerFragment extends Fragment {

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    NavigationItemCLicked navigationItemCLicked;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.left_fragment, null);
        listView = (ListView) rootView.findViewById(R.id.left_list_view);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navigationItemCLicked = (NavigationItemCLicked) getActivity();
        arrayList.add("List View");
        arrayList.add("Recycler View");

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        navigationItemCLicked.itemClicked("ListViewFragment");
                        break;
                    case 1:
                        navigationItemCLicked.itemClicked("RecyclerViewFragment");
                        break;

                }
            }
        });
    }

    public interface NavigationItemCLicked {
        void itemClicked(String item);
    }

}
