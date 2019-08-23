package com.oganbelema.listmaker.taskListDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oganbelema.listmaker.databinding.TaskViewHolderBinding

/**
 * Created by Belema Ogan on 2019-08-23.
 */
class ListItemViewHolder(private val taskViewHolderBinding: TaskViewHolderBinding):
    RecyclerView.ViewHolder(taskViewHolderBinding.root)  {

    companion object {
        fun from(parent: ViewGroup): ListItemViewHolder{
            return ListItemViewHolder(TaskViewHolderBinding
                .inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    fun bind(task: String){
        taskViewHolderBinding.taskTextView.text = task
    }
}