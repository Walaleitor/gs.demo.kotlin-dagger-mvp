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
    private final TextView nameLabel;
    private final TextView url;
    private final TextView description;
    private final TextView descriptionLabel;

    public ReposViewHolder(@NonNull View view) {
        super(view);

        this.name = itemView.findViewById(R.id.name);
        this.nameLabel = itemView.findViewById(R.id.nameLabel);
        this.url = itemView.findViewById(R.id.url);
        this.description = itemView.findViewById(R.id.description);
        this.descriptionLabel = itemView.findViewById(R.id.descriptionLabel);
    }

    void bindItem(RepositoryDTO item) {
        setText(name, nameLabel, item.getName());
        setText(url, null, item.getRepoURL());
        setText(description, descriptionLabel, item.getDescription());
    }

    // TODO duplicated with UsersViewHolder#setText
    private void setText(@NonNull TextView value, @Nullable TextView label, @Nullable CharSequence text) {
        value.setText(text);
        value.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE); // TODO this could be generic?
        if (label != null) {
            label.setVisibility(value.getVisibility());
        }
    }

}
