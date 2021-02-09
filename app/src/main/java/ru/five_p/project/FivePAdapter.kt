package ru.five_p.project

import android.content.Context
import android.widget.BaseAdapter

abstract class FivePAdapter(items: ArrayList<ProjectData>, context: Context): BaseAdapter() {
    val hello: String = "lol"
}

class ProjectData {
    var name: String? = null
    var number: Int = 1
}