package com.oganbelema.listmaker.taskListDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.oganbelema.listmaker.LIST_KEY
import com.oganbelema.listmaker.R
import com.oganbelema.listmaker.TaskList
import com.oganbelema.listmaker.databinding.ActivityListDetailBinding

class ListDetailActivity : AppCompatActivity() {

    private lateinit var taskList: TaskList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityListDetailBinding: ActivityListDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_list_detail)

        taskList = intent.getParcelableExtra(LIST_KEY)
        title = taskList.name

        val listItemsRecyclerViewAdapter = ListItemsRecyclerViewAdapter(taskList)

        activityListDetailBinding.listItemsRecyclerView.adapter = listItemsRecyclerViewAdapter

    }
}
