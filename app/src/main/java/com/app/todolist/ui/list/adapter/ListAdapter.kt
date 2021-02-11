package com.app.todolist.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.todolist.R
import com.app.todolist.data.model.ToDoItem

class ListAdapter(
    private val onUpdate: (toDoItem: ToDoItem, position: Int) -> Unit,
    private val onRemove: (toDoItem: ToDoItem, position: Int) -> Unit
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var items: List<ToDoItem>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)
        val vh = ViewHolder(view)
        view.setOnClickListener { }
        vh.removeButton.setOnClickListener {
            items?.get(vh.adapterPosition)?.let {
                onRemove(it, vh.adapterPosition)
            }
        }
        vh.doneCB.setOnClickListener {
            items?.get(vh.adapterPosition)?.let {
                it.done = !it.done
                onUpdate(it, vh.adapterPosition)
            }
        }
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.get(position)?.let { item ->
            holder.doneCB.isChecked = item.done
            holder.contentTV.text = item.text
        }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val removeButton: View = view.findViewById(R.id.item_remove)
        val doneCB: CheckBox = view.findViewById(R.id.item_checkbox)
        val contentTV: TextView = view.findViewById(R.id.item_text)
    }
}