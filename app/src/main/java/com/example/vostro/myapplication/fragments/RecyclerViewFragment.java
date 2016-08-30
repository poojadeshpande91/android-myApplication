package com.example.vostro.myapplication.fragments;

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

import com.example.vostro.myapplication.R;
import com.example.vostro.myapplication.helper.ItemDecoration;

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
        ItemDecoration itemDecoration = new ItemDecoration(100);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<ItemHolder> {

        private ArrayList<String> items;

        public RecyclerViewAdapter(Context context, ArrayList<String> items) {
            this.items = items;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_item, parent, false);
            return new ItemHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.textView.setText(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ItemHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
