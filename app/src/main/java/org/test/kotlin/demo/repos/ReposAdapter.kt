package org.test.kotlin.demo.repos

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.test.kotlin.demo.api.dto.RepositoryDTO

class ReposAdapter(
        private val items: List<RepositoryDTO>) : RecyclerView.Adapter<ReposViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int) = items[position].id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ReposViewHolder(parent)

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

}
