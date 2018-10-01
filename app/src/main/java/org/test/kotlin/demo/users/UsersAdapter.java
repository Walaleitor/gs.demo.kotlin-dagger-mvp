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
    private final List<UserDTO> users;
    private final Consumer<UserDTO> selectionListener;

    {
        setHasStableIds(true);
    }

    public UsersAdapter(List<UserDTO> users, Consumer<UserDTO> selectionListener) {
        this.users = users;
        this.selectionListener = selectionListener;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public long getItemId(int position) {
        return users.get(position).getId();
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_users_item, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        UserDTO user = users.get(position);

        holder.bindUser(user);
        holder.itemView.setOnClickListener($ -> selectionListener.accept(user));
    }

    @Override
    public void onViewRecycled(@NonNull UsersViewHolder holder) {
        super.onViewRecycled(holder);

        holder.itemView.setOnClickListener(null);
    }

}
