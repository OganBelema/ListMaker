package com.oganbelema.listmaker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Belema Ogan on 2019-08-23.
 */
@Parcelize
class TaskList(val name: String, val tasks: ArrayList<String> = ArrayList()): Parcelable