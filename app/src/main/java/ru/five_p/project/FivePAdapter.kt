package ru.five_p.project

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class FivePAdapter(list_project:ArrayList<String>,
                   list_number:ArrayList<Int>,
                   list_status:ArrayList<Boolean>,
                   private val listener: OnItemClickListener)
    : RecyclerView.Adapter<FivePAdapter.FivePHolder>() {

    private var arrayProject = list_project
    private var arrayNumber = list_number
    private var arrayStatus = list_status

    inner class FivePHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val textViewTitle: TextView = itemView.findViewById(R.id.textView)
        private val textViewNumber: TextView = itemView.findViewById(R.id.textViewNumber)
        private val imageViewCompat: ImageView = itemView.findViewById(R.id.imageViewStatus)

        fun setData(title:String, number:Int, status:Boolean){
            textViewTitle.text = title

            // Номер со знаком "#", иначе не красиво
            val numberText = "#$number"
            textViewNumber.text = numberText

            // Изменение картинки, в зависимости от статуса
            // 185, 167, 126, 120, 82, 61, 54, 42, 24 - номера изображений
            if (status) {imageViewCompat.setImageResource(R.drawable.vector_ok)}
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
        holder.setData(
            arrayProject[position],
            arrayNumber[position],
            arrayStatus[position])
    }

    // Кол-во элементов
    override fun getItemCount(): Int = arrayProject.size

    fun updateAdapter(arrayProjectAdd: ArrayList<String>,
                      arrayNumberAdd:  ArrayList<Int>,
                      arrayStatusAdd:  ArrayList<Boolean>) {

        arrayProject.clear()
        arrayNumber.clear()
        arrayStatus.clear()

        arrayProject.addAll(arrayProjectAdd)
        arrayNumber.addAll(arrayNumberAdd)
        arrayStatus.addAll(arrayStatusAdd)

        notifyDataSetChanged()
    }
}
