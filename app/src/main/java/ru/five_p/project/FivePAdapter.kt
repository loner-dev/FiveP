package ru.five_p.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FivePAdapter(list_project:ArrayList<String>) : RecyclerView.Adapter<FivePAdapter.FivePHolder>() {

    var array_project = list_project


    class FivePHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text_view_title = itemView.findViewById<TextView>(R.id.textView)
        fun setData(title:String){
            text_view_title.text = title
        }
    }

    // Шаблон
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FivePHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FivePHolder(inflater.inflate(R.layout.list_custom, parent, false))
    }

    // Подключение данных из массива к шаблону
    override fun onBindViewHolder(holder: FivePHolder, position: Int) {
        holder.setData(array_project.get(position))
    }

    // Кол-во элементов
    override fun getItemCount(): Int {
        return array_project.size
    }

    fun updateAdapter(listItems:List<String>) {

        array_project.clear()
        array_project.addAll(listItems)

        notifyDataSetChanged()
    }
}
