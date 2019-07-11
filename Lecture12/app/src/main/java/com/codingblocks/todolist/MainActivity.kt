package com.codingblocks.todolist

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tasks = arrayListOf<TasksTable.Task>()

    val listView: ListView by lazy {
        findViewById<ListView>(R.id.lvTodolist)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = MyDbHelper(this)
        val tasksDb = dbHelper.writableDatabase

        tasks = TasksTable.getAllTasks(tasksDb)

        val taskAdapter = TaskAdapter(tasks)
        taskAdapter.listItemClickListener = object : ListItemClickListener {
            override fun textviewClick(text: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun lisitemClick(task: TasksTable.Task, position: Int) {
                val thisTask = task
                thisTask.done = !thisTask.done
                TasksTable.updateTask(tasksDb, thisTask)
                tasks = TasksTable.getAllTasks(tasksDb)
                taskAdapter.updateTasks(tasks)
            }

        }
        listView.adapter = taskAdapter

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
//                val thisTask = taskAdapter.getItem(position)
//                thisTask.done = !thisTask.done
//                TasksTable.updateTask(tasksDb, thisTask)
//                tasks = TasksTable.getAllTasks(tasksDb)
//                taskAdapter.updateTasks(tasks)
//            }
//
//        }
    }

}