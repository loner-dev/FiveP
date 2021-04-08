package ru.five_p.project

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class NewProjectDialog : DialogFragment() {

    lateinit var editText: EditText
    var onOk: (() -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
//        val parent: ViewGroup = fin
        val view = activity!!.layoutInflater.inflate(R.layout.dialog_with_edittext, null)
        editText = view.findViewById(R.id.edit_text_dialog)

        val builder = AlertDialog.Builder(context!!)
            .setTitle("Новый проект")
            .setView(view)
            .setPositiveButton("Создать") {
                _, _ -> onOk?.invoke()
            }
            .setNegativeButton("Отмена", null)

        return builder.create()
    }
}