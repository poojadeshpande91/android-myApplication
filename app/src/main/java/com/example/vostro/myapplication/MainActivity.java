package com.example.vostro.myapplication;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    LinearLayout linearLayout;
    /*TextView textView;
    DataFromActivityToFragment dataFromActivityToFragment;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);

        List<String> arrayStringList = new ArrayList<>();
        for(int i=1; i<21; i++) {
            arrayStringList.add("List Item " + i);
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                arrayStringList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(linearLayout, (CharSequence) listView.getItemAtPosition(position),
                        Snackbar.LENGTH_SHORT).show();
            }
        });
       /* FragmentA fr = new FragmentA();
        FragmentManager fm = getFragmentManager();
        dataFromActivityToFragment = (DataFromActivityToFragment) fr;
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();


        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                dataFromActivityToFragment.sendData("Hi");
            }
        };

        handler.postDelayed(r, 5000);*/


    }

    /*public interface DataFromActivityToFragment {
        void sendData(String data);
    }*/

}
