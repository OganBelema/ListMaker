package com.oganbelema.listmaker

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Belema Ogan on 2019-08-22.
 */
class ListSelectionRecyclerViewAdapter(private val taskLists: ArrayList<TaskList>)
    : RecyclerView.Adapter<ListSelectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        return ListSelectionViewHolder.from(parent)
    }

    override fun getItemCount(): Int = taskLists.size

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        holder.bindItems(position + 1, taskLists[position])
    }

    fun addList(taskList: TaskList) {
        taskLists.add(taskList)
        notifyDataSetChanged()
    }

}