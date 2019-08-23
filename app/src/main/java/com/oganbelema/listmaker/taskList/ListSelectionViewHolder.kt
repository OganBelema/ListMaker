package com.oganbelema.listmaker.taskList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oganbelema.listmaker.TaskList
import com.oganbelema.listmaker.databinding.ListItemBinding

/**
 * Created by Belema Ogan on 2019-08-22.
 */
class ListSelectionViewHolder(private val listItemBinding: ListItemBinding) :
    RecyclerView.ViewHolder(listItemBinding.root) {

    fun bindItems(
        position: Int,
        taskList: TaskList,
        clickLister: (taskList: TaskList) -> Unit
    ) {
        listItemBinding.itemNumber.text = position.toString()
        listItemBinding.itemString.text = taskList.name
        listItemBinding.root.setOnClickListener {
            clickLister(taskList)
        }
    }

    companion object {
        fun from(parent: ViewGroup): ListSelectionViewHolder {
            return ListSelectionViewHolder(
                ListItemBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

}