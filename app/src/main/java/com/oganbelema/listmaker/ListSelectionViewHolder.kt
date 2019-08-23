package com.oganbelema.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oganbelema.listmaker.databinding.ListItemBinding

/**
 * Created by Belema Ogan on 2019-08-22.
 */
class ListSelectionViewHolder(private val listItemBinding: ListItemBinding) :
    RecyclerView.ViewHolder(listItemBinding.root) {

    fun bindItems(position: Int, taskList: TaskList) {
        listItemBinding.itemNumber.text = position.toString()
        listItemBinding.itemString.text = taskList.name
    }

    companion object {
        fun from(parent: ViewGroup): ListSelectionViewHolder{
            return ListSelectionViewHolder(ListItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

}