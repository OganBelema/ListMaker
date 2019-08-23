package com.oganbelema.listmaker.taskList

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oganbelema.listmaker.TaskList

/**
 * Created by Belema Ogan on 2019-08-22.
 */
class ListSelectionRecyclerViewAdapter(private var taskLists: ArrayList<TaskList>,
                                       private val clickLister : (taskList: TaskList) -> Unit)
    : RecyclerView.Adapter<ListSelectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        return ListSelectionViewHolder.from(parent)
    }

    override fun getItemCount(): Int = taskLists.size

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        holder.bindItems(position + 1, taskLists[position], clickLister)
    }

    fun addList(taskList: TaskList) {
        taskLists.add(taskList)
        notifyDataSetChanged()
    }

    fun replaceList(taskLists: ArrayList<TaskList>) {
        this.taskLists = taskLists
        notifyDataSetChanged()
    }

}