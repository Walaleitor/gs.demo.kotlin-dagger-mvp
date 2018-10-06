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
    private final TextView url;
    private final TextView user;
    private final TextView info;

    public UsersViewHolder(@NonNull View view) {
        super(view);

        this.name = itemView.findViewById(R.id.name);
        this.url = itemView.findViewById(R.id.url);
        this.user = itemView.findViewById(R.id.user);
        this.info = itemView.findViewById(R.id.info);
    }

    void bindItem(UserDTO item) {
        String infoValue = itemView.getResources().getQuantityString(
                R.plurals.value_info,
                item.getRepositories(),
                item.getRepositories());

        setText(user, item.getUser());
        setText(url, item.getProfileURL());
        setText(name, item.getName());
        setText(info, infoValue);
    }

    private void setText(@NonNull TextView value, @Nullable CharSequence text) {
        value.setText(text);
        value.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE); // TODO this could be generic?
    }

}
