package com.oganbelema.listmaker

import android.content.Context
import androidx.preference.PreferenceManager

/**
 * Created by Belema Ogan on 2019-08-23.
 */
class ListDataManager(private val context: Context) {

    fun saveList(taskList: TaskList){
        //get the default sharedPreferences for app
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()
        //add list to shared preference as hashSet
        sharedPreferences.putStringSet(taskList.name, taskList.tasks.toHashSet())
        //apply the edit
        sharedPreferences.apply()
    }

    fun readList(): ArrayList<TaskList> {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val sharedPreferenceContents = sharedPreferences.all
        val taskLists = ArrayList<TaskList>()

        for(preferenceItem in sharedPreferenceContents){
            val itemHashSet = preferenceItem.value as HashSet<String>
            val list = TaskList(preferenceItem.key, ArrayList(itemHashSet))
            taskLists.add(list)
        }
        return taskLists
    }
}