package ru.five_p.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_project.*

class ProjectActivity : AppCompatActivity(), FivePAdapter.OnItemClickListener {

    private val adapterPA = ProjectAdapter(ArrayList(), ArrayList(), ArrayList())
    private var nameListPA = arrayListOf<String>()
    private var numberListPA = arrayListOf<Int>()
    private var completeListPA = arrayListOf<Boolean>()
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        val positionOfProjectActivity = intent.getIntExtra(
            "positionOfProject", -1)

        supportActionBar!!.title = "123"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        rcViewPA.layoutManager = LinearLayoutManager(this)
        rcViewPA.adapter = adapterPA

        Toast.makeText(this,
            "Второе активити: $positionOfProjectActivity", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.project_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.save -> {
            Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
            true
        } R.id.plus_task -> {
            createTask()
            Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
            true
        } R.id.save_name -> {
            Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
            true
        } R.id.save_purpose -> {
            Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
            true
        } R.id.delete_project -> {
            Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
            true
        } else -> super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun createTask() {
        // Имя задания
        nameListPA.add("Task $count")

        // Порядковый номер задания
        numberListPA.add(count)
        count++

        // Статус задания
        completeListPA.add(true)

        fillAdapter()
    }

    private fun fillAdapter() {
        adapterPA.updateAdapter(nameListPA, numberListPA, completeListPA)
        Log.d("PPPPP", "Update Adapter")
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Клик по позиции $position", Toast.LENGTH_SHORT).show()
    }
}
