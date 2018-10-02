package org.test.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.test.kotlin.demo.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LoadingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public int getItemCount() {
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_loading, parent, false);

        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

}
