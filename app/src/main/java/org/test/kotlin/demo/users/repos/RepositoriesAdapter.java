package org.test.kotlin.demo.users.repos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.RepositoryDTO;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesViewHolder> {
    private final List<RepositoryDTO> items;

    {
        setHasStableIds(true);
    }

    public RepositoriesAdapter(List<RepositoryDTO> items) {
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
    public RepositoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repository, parent, false);
        return new RepositoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoriesViewHolder holder, int position) {
        RepositoryDTO item = items.get(position);

        holder.bindItem(item);
    }

}
