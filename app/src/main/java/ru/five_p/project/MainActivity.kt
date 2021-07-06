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

    private val myAdapter = FivePAdapter(this)
    private var dataProject = arrayListOf<ProjectStructure>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        Log.d("PPPPP", "setMainAct")
    }

    private fun fillAdapter() {
        myAdapter.update(dataProject)
    }

    override fun onResume() {
        super.onResume()
        Log.d("PPPPP","onResume")
    }

    private fun setAdapter() {
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = myAdapter

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

            val count = dataProject.size

            val s = count % 2 == 0
            val data = ProjectStructure(text, count, s)

            dataProject.add(data)

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putParcelableArrayList("key", dataProject)
        }
        Log.d("PPPPP", "Data is: $dataProject")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        dataProject = savedInstanceState.getParcelableArrayList("key")!!
        fillAdapter()
        Log.d("PPPPP", "Restored is: $dataProject")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("PPPPP", "onDestroy")

        if (isFinishing) {
            Log.d("PPPPP", "isFinishing")
        }
    }
}
