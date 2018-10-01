package org.test.kotlin.demo.users;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.UserDTO;

import java.util.List;
import java.util.function.Consumer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {
    private final List<UserDTO> items;
    private final Consumer<UserDTO> selectionListener;

    {
        setHasStableIds(true);
    }

    public UsersAdapter(List<UserDTO> items, Consumer<UserDTO> selectionListener) {
        this.items = items;
        this.selectionListener = selectionListener;
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
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_users, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        UserDTO user = items.get(position);

        holder.bindItem(user);
        holder.itemView.setOnClickListener($ -> selectionListener.accept(user));
    }

    @Override
    public void onViewRecycled(@NonNull UsersViewHolder holder) {
        super.onViewRecycled(holder);

        holder.itemView.setOnClickListener(null);
    }

}
