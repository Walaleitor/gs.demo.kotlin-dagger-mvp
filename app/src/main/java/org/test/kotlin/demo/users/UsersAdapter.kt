package org.test.kotlin.demo.users

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.test.kotlin.demo.api.dto.UserDTO

class UsersAdapter(
        private val items: List<UserDTO>,
        private val selectionListener: (UserDTO) -> Unit) : RecyclerView.Adapter<UsersViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int) = items[position].id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UsersViewHolder(parent)

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = items[position]

        holder.bindItem(user)
        holder.itemView.setOnClickListener { selectionListener.invoke(user) }
    }

    override fun onViewRecycled(holder: UsersViewHolder) {
        super.onViewRecycled(holder)

        holder.itemView.setOnClickListener(null)
    }

}
