package com.app.todolist.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.todolist.R
import com.app.todolist.ui.add.AddItemFragment
import com.app.todolist.ui.list.adapter.ListAdapter
import com.app.todolist.utils.extensions.addFragment
import com.app.todolist.utils.extensions.attachFab
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.add_item_button)
        fab.setOnClickListener {
            addFragment(R.id.fragment_container, AddItemFragment.newInstance())
        }

        val toDoRV = view.findViewById<RecyclerView>(R.id.to_do_rv)
        val toDoAdapter = ListAdapter(
            { toDoItem, _ -> viewModel.update(toDoItem) },
            { toDoItem, position ->
                fab.show()
                viewModel.remove(toDoItem, position)
            }
        )
        toDoRV.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = toDoAdapter

            val dividerItemDecoration = DividerItemDecoration(context, RecyclerView.VERTICAL)
            ContextCompat.getDrawable(context, R.drawable.divider_rv)?.let { dividerItemDecoration.setDrawable(it) }
            addItemDecoration(dividerItemDecoration)

            attachFab(fab)

        }

        viewModel.getToDoLiveData().observe(this, Observer { list ->
            toDoAdapter.items = list
        })

        return view
    }
}