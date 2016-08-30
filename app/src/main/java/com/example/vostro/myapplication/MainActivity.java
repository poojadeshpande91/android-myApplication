package com.example.vostro.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.vostro.myapplication.fragments.FragmentDemo;
import com.example.vostro.myapplication.fragments.LeftDrawerFragment;
import com.example.vostro.myapplication.fragments.ListViewFragment;
import com.example.vostro.myapplication.fragments.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity implements LeftDrawerFragment.NavigationItemCLicked{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView = (TextView) findViewById(R.id.tv);

        setSupportActionBar(toolbar);

        LeftDrawerFragment fr = new LeftDrawerFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.navigation_container, fr);
        fragmentTransaction.commit();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this
                , drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void itemClicked(String item) {
        textView.setVisibility(View.GONE);
        drawerLayout.closeDrawer(Gravity.LEFT);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        ListViewFragment listViewFragment = new ListViewFragment();
        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        FragmentDemo fragmentDemo = new FragmentDemo();
        switch (item) {
            case "Home":
                if(listViewFragment != null) {
                    fragmentTransaction.remove(listViewFragment);
                    fragmentTransaction.commit();
                } else {
                    fragmentTransaction.remove(recyclerViewFragment);
                    fragmentTransaction.commit();
                }
                break;
            case "ListViewFragment":
                fragmentTransaction.replace(R.id.fragment_container, listViewFragment);
                fragmentTransaction.commit();
                break;
            case "RecyclerViewFragment":
                fragmentTransaction.replace(R.id.fragment_container, recyclerViewFragment);
                fragmentTransaction.commit();
                break;
            case "Demo":
                fragmentTransaction.replace(R.id.fragment_container, fragmentDemo);
                fragmentTransaction.commit();
                break;
        }
    }
}
