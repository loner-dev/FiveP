package ru.five_p.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FivePAdapter(list_project:ArrayList<String>) : RecyclerView.Adapter<FivePAdapter.FivePHolder>() {

    private var arrayProject = list_project

    class FivePHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewTitle: TextView = itemView.findViewById<TextView>(R.id.textView)
        fun setData(title:String){
            textViewTitle.text = title
        }
    }

    // Шаблон
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FivePHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FivePHolder(inflater.inflate(R.layout.list_custom, parent, false))
    }

    // Подключение данных из массива к шаблону
    override fun onBindViewHolder(holder: FivePHolder, position: Int) {
        holder.setData(arrayProject[position])
    }

    // Кол-во элементов
    override fun getItemCount(): Int {
        return arrayProject.size
    }

    fun updateAdapter(listItems:List<String>) {

        arrayProject.clear()
        arrayProject.addAll(listItems)

        notifyDataSetChanged()
    }
}
