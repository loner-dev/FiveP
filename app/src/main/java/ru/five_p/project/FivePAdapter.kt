package ru.five_p.project

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class FivePAdapter(private val listener: OnItemClickListener)
    : RecyclerView.Adapter<FivePAdapter.FivePHolder>() {

    private val dataList = ArrayList<ProjectStructure>()

    inner class FivePHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val textViewTitle: TextView = itemView.findViewById(R.id.textView)
        private val textViewNumber: TextView = itemView.findViewById(R.id.textViewNumber)
        private val imageViewCompat: ImageView = itemView.findViewById(R.id.imageViewStatus)

        // Заполнение по шаблону
        fun bind(structure: ProjectStructure) {
            textViewTitle.text = structure.name

            val numberText = "#${structure.number}"
            textViewNumber.text = numberText

            if (structure.status) {imageViewCompat.setImageResource(R.drawable.vector_ok)}
            else {imageViewCompat.setImageResource(R.drawable.vector_not_ok)}
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    // Шаблон
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FivePHolder {
        val inflater = LayoutInflater.from(parent.context)
        Log.d("PPPPP", "onCreateViewHolder")
        return FivePHolder(inflater.inflate(R.layout.list_custom, parent, false))
    }

    // Подключение данных из массива к шаблону
    override fun onBindViewHolder(holder: FivePHolder, position: Int) {
        holder.bind(dataList[position])
    }

    // Кол-во элементов
    override fun getItemCount(): Int = dataList.size

    // Обновление ("пересоздание") массива данных
    fun update(data: ArrayList<ProjectStructure>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }
}
