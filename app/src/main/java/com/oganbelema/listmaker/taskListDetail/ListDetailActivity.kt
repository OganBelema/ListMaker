package com.oganbelema.listmaker.taskListDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.oganbelema.listmaker.LIST_KEY
import com.oganbelema.listmaker.R
import com.oganbelema.listmaker.TaskList
import com.oganbelema.listmaker.databinding.ActivityListDetailBinding

class ListDetailActivity : AppCompatActivity() {

    private lateinit var taskList: TaskList

    private lateinit var activityListDetailBinding: ActivityListDetailBinding

    private lateinit var listItemsRecyclerViewAdapter: ListItemsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityListDetailBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_list_detail)

        activityListDetailBinding.addTaskFab.setOnClickListener {
            showCreateTaskDialog()
        }

        taskList = intent.getParcelableExtra(LIST_KEY)
        title = taskList.name

        listItemsRecyclerViewAdapter = ListItemsRecyclerViewAdapter(taskList)

        activityListDetailBinding.listItemsRecyclerView.adapter = listItemsRecyclerViewAdapter

    }

    private fun showCreateTaskDialog(){
        val dialogTitle = getString(R.string.task_to_add)
        val positiveButtonTitle = getString(R.string.add_task)

        val builder = AlertDialog.Builder(this)
        val taskEditText = EditText(this)
        taskEditText.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle(dialogTitle)
        builder.setView(taskEditText)
        builder.setPositiveButton(positiveButtonTitle){ dialogInterface, _ ->
            val task = taskEditText.text.toString()
            listItemsRecyclerViewAdapter.addTask(task)
            dialogInterface.dismiss()
        }

        builder.create().show()
    }
}
