package org.test.kotlin.demo.repos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.RepositoryDTO;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReposAdapter extends RecyclerView.Adapter<ReposViewHolder> {
    private final List<RepositoryDTO> items;

    {
        setHasStableIds(true);
    }

    public ReposAdapter(List<RepositoryDTO> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repository, parent, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder holder, int position) {
        RepositoryDTO item = items.get(position);

        holder.bindItem(item);
    }

}
