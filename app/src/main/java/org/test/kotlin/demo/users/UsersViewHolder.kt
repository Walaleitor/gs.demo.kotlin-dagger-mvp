package org.test.kotlin.demo.users

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_users.view.*
import org.test.kotlin.demo.R
import org.test.kotlin.demo.api.dto.UserDTO
import org.test.utils.inflate
import org.test.utils.textOrHide

class UsersViewHolder(parent: ViewGroup)
    : RecyclerView.ViewHolder(parent.inflate(R.layout.item_users)) {

    fun bindItem(item: UserDTO) {
        with(itemView) {
            user.textOrHide = item.user
            url.textOrHide = item.profileURL
            name.textOrHide = item.name
            info.textOrHide = resources.getQuantityString(R.plurals.value_info,
                    item.repositories, item.repositories)
        }
    }

}
