package com.example.vostro.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vostro on 27/8/16.
 */
public class RecyclerViewFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<String> arrayList = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, null);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 1; i < 31; i++) {
            arrayList.add("RecyclerView Item " + i);
        }

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), arrayList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder> {

        private ArrayList<String> items;
        private LayoutInflater layoutInflater;

        public RecyclerViewAdapter(Context context, ArrayList<String> items) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.items = items;
        }

        @Override
        public RecyclerViewAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = layoutInflater.inflate(R.layout.layout_item, parent, false);
            return new ItemHolder(itemView, this);
        }

        @Override
        public void onBindViewHolder(RecyclerViewAdapter.ItemHolder holder, int position) {
            holder.textView.setText(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        class ItemHolder extends RecyclerView.ViewHolder {

            TextView textView;

            public ItemHolder(View itemView, RecyclerViewAdapter parent) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.text_view);
            }
        }
    }
}
