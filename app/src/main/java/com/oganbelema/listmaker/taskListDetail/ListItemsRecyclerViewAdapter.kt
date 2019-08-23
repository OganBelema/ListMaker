package com.oganbelema.listmaker.taskListDetail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oganbelema.listmaker.TaskList

/**
 * Created by Belema Ogan on 2019-08-23.
 */
class ListItemsRecyclerViewAdapter(private val taskList: TaskList): RecyclerView.Adapter<ListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder.from(parent)
    }

    override fun getItemCount(): Int = taskList.tasks.size

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(taskList.tasks[position])
    }

    fun addTask(task: String) {
        taskList.tasks.add(task)
        notifyItemInserted(taskList.tasks.size)
    }
}