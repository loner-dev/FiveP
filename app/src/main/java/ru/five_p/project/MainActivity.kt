package ru.five_p.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val myAdapter = FivePAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        Log.d("PPPPP", "setMainAct")
    }

    override fun onResume() {
        super.onResume()

        fillAdapter()
        Log.d("PPPPP","2 Test")
    }

    private fun init() {
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = myAdapter
    }

    private fun fillAdapter() {
        myAdapter.updateAdapter(listOf("0 проект", "1 проект", "2 проект", "3 проект", "4 проект", "5 проект", "6 проект", "7 проект", "8 проект", "9 проект", "10 проект"))
    }
}
