package ru.five_p.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProjectAdapter(private var namePA:ArrayList<String>,
                     private var numberPA:ArrayList<Int>,
                     private var checkPA:ArrayList<Boolean>
) : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    inner class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewNamePA = itemView.findViewById<TextView>(R.id.textViewPA)
        private val textViewNumberPA = itemView.findViewById<TextView>(R.id.textViewNumberPA)
        private val checkBoxPA = itemView.findViewById<CheckBox>(R.id.checkBox)

        fun setData(name:String, number:Int, status:Boolean){
            textViewNamePA.text = name

            // Номер со знаком "#", иначе не красиво
            val numberText = "#$number"
            textViewNumberPA.text = numberText

            checkBoxPA.isChecked = number % 2 != 0

//            Toast.makeText(this, "Статус: $status", Toast.LENGTH_SHORT).show()
        }

//        var checkBox = itemView.checkBox

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProjectViewHolder(inflater.inflate(R.layout.list_custom_activity_project,
            parent, false))

    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
//        holder.checkBox.isChecked
        holder.setData(
            namePA[position],
            numberPA[position],
            checkPA[position])
    }

    override fun getItemCount(): Int = namePA.size

    fun updateAdapter(
        data1: ArrayList<String>,
        data2: ArrayList<Int>,
        data3: ArrayList<Boolean>) {

        namePA.clear()
        numberPA.clear()
        checkPA.clear()

        namePA.addAll(data1)
        numberPA.addAll(data2)
        checkPA.addAll(data3)

        notifyDataSetChanged()

    }

}