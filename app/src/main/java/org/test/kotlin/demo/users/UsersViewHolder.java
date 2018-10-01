package org.test.kotlin.demo.users;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.UserDTO;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

class UsersViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    private final TextView nameLabel;
    private final TextView url;
    private final TextView user;
    private final TextView userLabel;
    private final TextView info;
    private final TextView infoLabel;

    public UsersViewHolder(@NonNull View view) {
        super(view);

        this.name = itemView.findViewById(R.id.name);
        this.nameLabel = itemView.findViewById(R.id.nameLabel);
        this.url = itemView.findViewById(R.id.url);
        this.user = itemView.findViewById(R.id.user);
        this.userLabel = itemView.findViewById(R.id.userLabel);
        this.info = itemView.findViewById(R.id.info);
        this.infoLabel = itemView.findViewById(R.id.infoLabel);
    }

    void bindItem(UserDTO item) {
        String infoValue = itemView.getResources().getQuantityString(
                R.plurals.value_info,
                item.getRepositories(),
                item.getRepositories());

        setText(user, userLabel, item.getUser());
        setText(url, null, item.getProfileURL());
        setText(name, nameLabel, item.getName());
        setText(info, infoLabel, infoValue);
    }

    private void setText(@NonNull TextView value, @Nullable TextView label, @Nullable CharSequence text) {
        value.setText(text);
        value.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE); // TODO this could be generic?
        if (label != null) {
            label.setVisibility(value.getVisibility());
        }
    }

}
