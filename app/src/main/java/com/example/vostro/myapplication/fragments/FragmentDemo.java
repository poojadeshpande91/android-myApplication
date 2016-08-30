package com.example.vostro.myapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.vostro.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vostro on 30/8/16.
 */
public class FragmentDemo extends Fragment {

    GridView gridView;
    EditText editText;
    Button button;
    //    LazyAdapter lazyAdapter;
    List<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_demo, null);

        gridView = (GridView) rootView.findViewById(R.id.grid_view);
        editText = (EditText) rootView.findViewById(R.id.demo_text);
        button = (Button) rootView.findViewById(R.id.button);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 0; i < 20; i++) {
            list.add("Grid Item " + i);
        }
        /*lazyAdapter = new LazyAdapter(getActivity(), list);
        gridView.setAdapter(lazyAdapter);*/


    }

    /*public class LazyAdapter extends BaseAdapter {
        private Context ctx;
        private List<String> items;
        BooksViewHolder booksViewHolder = null;

        public LazyAdapter(Context context, List<String> arrayList) {
            super();
            ctx = context;
            this.items = arrayList;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return items.indexOf(getItem(position));
        }

        class BooksViewHolder {
            TextView text;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                booksViewHolder = new BooksViewHolder();
                convertView = inflater.inflate(R.layout.layout_item, null);
                booksViewHolder.text = (TextView) convertView.findViewById(R.id.text_view);
                booksViewHolder.text.setText(items.get(position));
                convertView.setTag(booksViewHolder);
            } else {
                booksViewHolder = (BooksViewHolder) convertView.getTag();
            }
            return convertView;
        }
    }*/


}
