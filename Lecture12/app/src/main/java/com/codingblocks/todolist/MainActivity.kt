package com.codingblocks.todolist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tasks = arrayListOf<TasksTable.Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = MyDbHelper(this)
        val tasksDb = dbHelper.writableDatabase

        tasks = TasksTable.getAllTasks(tasksDb)

        val taskAdapter = TaskAdapter(tasks)
        lvTodolist.adapter = taskAdapter

        btnAdd.setOnClickListener {

            TasksTable.insertTask(
                tasksDb,
                TasksTable.Task(
                    null,
                    etNewItem.text.toString(),
                    false
                )
            )
            tasks = TasksTable.getAllTasks(tasksDb)
            taskAdapter.updateTasks(tasks)
        }

//        lvTodolist.onItemClickListener = object : AdapterView.OnItemClickListener {
//            override fun onItemClick(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//
//                tasks.removeAt(position)
//                taskAdapter.notifyDataSetChanged()
//            }
//
//        }
    }

    class TaskAdapter(var tasks: ArrayList<TasksTable.Task>): BaseAdapter() {

        fun updateTasks(newTasks: ArrayList<TasksTable.Task>) {
            tasks.clear()
            tasks.addAll(newTasks)
            notifyDataSetChanged()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val li = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = li.inflate(android.R.layout.simple_list_item_1, parent, false)
            view.findViewById<TextView>(android.R.id.text1).text = getItem(position).task

            return view
        }

        override fun getItem(position: Int): TasksTable.Task = tasks[position]

        override fun getItemId(position: Int): Long  = 0

        override fun getCount(): Int = tasks.size

    }
}