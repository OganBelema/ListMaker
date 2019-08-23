package com.oganbelema.listmaker

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Belema Ogan on 2019-08-22.
 */
class ListSelectionRecyclerViewAdapter: RecyclerView.Adapter<ListSelectionViewHolder>() {

    private val listTitles = arrayOf("Shopping List", "Chores", "Android Tutorials")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        return ListSelectionViewHolder.from(parent)
    }

    override fun getItemCount(): Int = listTitles.size

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        holder.bindItems(position + 1, listTitles[position])
    }

}