package org.test.kotlin.demo.repos

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_repository.view.*
import org.test.kotlin.demo.R
import org.test.kotlin.demo.api.dto.RepositoryDTO
import org.test.utils.inflate
import org.test.utils.textOrHide

class ReposViewHolder(parent: ViewGroup)
    : RecyclerView.ViewHolder(parent.inflate(R.layout.item_repository)) {

    fun bindItem(item: RepositoryDTO) {
        with(itemView) {
            name.textOrHide = item.name
            description.textOrHide = item.description
        }
    }

}
