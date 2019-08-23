package com.oganbelema.listmaker.taskList

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.oganbelema.listmaker.*
import com.oganbelema.listmaker.databinding.ActivityMainBinding
import com.oganbelema.listmaker.taskListDetail.ListDetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var listSelectionRecyclerViewAdapter: ListSelectionRecyclerViewAdapter

    private val listDataManager = ListDataManager(this)

    private val showListDetail: (list: TaskList) -> Unit = {
        val listDetailIntent = Intent(this, ListDetailActivity::class.java)
        listDetailIntent.putExtra(LIST_KEY, it)
        startActivityForResult(listDetailIntent, LIST_DETAIL_REQUEST_CODE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        setSupportActionBar(activityMainBinding.toolbar)

        val taskLists = listDataManager.readList()

        listSelectionRecyclerViewAdapter =
            ListSelectionRecyclerViewAdapter(
                taskLists,
                showListDetail
            )

        activityMainBinding.secondaryLayout
            .listRecyclerView.adapter = listSelectionRecyclerViewAdapter

        activityMainBinding.fab.setOnClickListener {
            showCreateListDialog()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showCreateListDialog(){
        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)

        val builder = AlertDialog.Builder(this)
        val listTitleEditText = EditText(this)
        listTitleEditText.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditText)
        builder.setPositiveButton(positiveButtonTitle){ dialogInterface, _ ->
            val taskList = TaskList(listTitleEditText.text.toString())
            listDataManager.saveList(taskList)
            listSelectionRecyclerViewAdapter.addList(taskList)
            dialogInterface.dismiss()
            showListDetail(taskList)
        }

        builder.create().show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == LIST_DETAIL_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            data?.let {
                listDataManager.saveList(data.getParcelableExtra(LIST_KEY))
                updateList()
            }
        }
    }

    private fun updateList() {
        val taskList = listDataManager.readList()
        listSelectionRecyclerViewAdapter.replaceList(taskList)
    }

}
