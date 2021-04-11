package ru.five_p.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FivePAdapter.OnItemClickListener {

    private val myAdapter = FivePAdapter(ArrayList(), ArrayList(), ArrayList(), this)
    private var myProjectList = arrayListOf<String>()
    private var myNumberList = arrayListOf<Int>()
    private var myStatusList = arrayListOf<Boolean>()
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        Log.d("PPPPP", "setMainAct")
    }

    override fun onResume() {
        super.onResume()
        fillAdapter()
        Log.d("PPPPP","onResume")
    }

    private fun setAdapter() {
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = myAdapter

    }

    private fun fillAdapter() {
        myAdapter.updateAdapter(myProjectList, myNumberList, myStatusList)
        Log.d("PPPPP", "Update Adapter")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_bar_plus -> {
            createNewProject()
            true
        } R.id.action_bar_help -> {
            Toast.makeText(this, "Кнопка помощи $item", Toast.LENGTH_SHORT).show()
            true
        } else -> super.onOptionsItemSelected(item)
    }

    private fun createNewProject() {
        val setDialog = NewProjectDialog()
        setDialog.onOk = {
            // Текст проекта
            var text = setDialog.editText.text.toString()
            if (text.isBlank()) text = "Мой новый проект"
            myProjectList.add(text)

            // Порядковый номер проета
            myNumberList.add(count)
            count++

            // Статус проекта
            myStatusList.add(true)

            fillAdapter()
        }
        setDialog.show(supportFragmentManager, "newProject")
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Клик по позиции $position", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ProjectActivity::class.java)
        intent.putExtra("positionOfProject", position)

        startActivity(intent)
    }
}
