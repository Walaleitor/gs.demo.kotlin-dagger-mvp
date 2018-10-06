package org.test.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.test.kotlin.demo.R

class LoadingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_loading, parent, false)
            .let(::LoadingHolder)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}

    class LoadingHolder(view: View) : RecyclerView.ViewHolder(view)

}
