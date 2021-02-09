package ru.five_p.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PPPPP", "setMainAct")
    }

    override fun onResume() {
        super.onResume()

        // Контент в ListView
        val arrayAdapter: ArrayAdapter<*>
        val namesProject = arrayOf(
            "1 проект", "2 проект", "3 проект", "4 проект", "5 проект")
        val mainListView = findViewById<ListView>(R.id.mainLV)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesProject)
        mainListView.adapter = arrayAdapter


        Log.d("PPPPP","2 Test")
    }
}
// Фрагмент ListView
/*class MainListFragment : ListFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Добавление массива
        // val names = arrayOf("first", "second", "third")
        val names = arrayOf("123123")
        val adapter : ArrayAdapter<String> = ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1, names)
        listAdapter = adapter


        return super.onCreateView(inflater, container, savedInstanceState)
    }*/
