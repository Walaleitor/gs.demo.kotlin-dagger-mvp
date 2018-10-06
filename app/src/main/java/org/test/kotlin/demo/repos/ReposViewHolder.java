package org.test.kotlin.demo.repos;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.RepositoryDTO;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

class ReposViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    private final TextView description;

    ReposViewHolder(@NonNull View view) {
        super(view);

        this.name = itemView.findViewById(R.id.name);
        this.description = itemView.findViewById(R.id.description);
    }

    void bindItem(RepositoryDTO item) {
        setText(name, item.getName());
        setText(description, item.getDescription());
    }

    // TODO duplicated with UsersViewHolder#setText
    private void setText(@NonNull TextView value, @Nullable CharSequence text) {
        value.setText(text);
        value.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE); // TODO this could be generic?
    }

}
