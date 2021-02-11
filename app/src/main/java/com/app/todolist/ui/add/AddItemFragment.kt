package com.app.todolist.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.todolist.R
import com.app.todolist.utils.extensions.dismiss
import com.app.todolist.utils.extensions.hideKB
import com.app.todolist.utils.extensions.toast

class AddItemFragment : Fragment() {

    companion object {
        fun newInstance() = AddItemFragment()
    }

    private lateinit var viewModel: AddItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AddItemViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_add_item, container, false)
        val toDoET = view.findViewById<EditText>(R.id.to_do_et)
        view.findViewById<View>(R.id.save_button)?.apply {
            setOnClickListener {
                val text = toDoET.text.toString()
                if (text.isBlank()) {
                    context?.toast(R.string.add_item_error_empty_text)
                } else {
                    viewModel.save(text)
                    context?.hideKB(toDoET)
                    dismiss()
                }
            }
        }
        return view
    }
}