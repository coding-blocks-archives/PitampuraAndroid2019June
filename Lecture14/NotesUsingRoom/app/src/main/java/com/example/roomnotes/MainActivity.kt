package com.example.roomnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "todo.db"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    var list = arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = db.todoDao().getAllTodo() as ArrayList<Todo>

        val adapter = TaskAdapter(list)

        adapter.listItemClickListener = object : ListItemClickListener {
            override fun lisitemClick(task: Todo, position: Int) {
                db.todoDao().delete(task)
            }

        }

        lvTodolist.adapter = adapter


        btnAdd.setOnClickListener {

            db.todoDao().insertRow(
                Todo(
                    task = etNewItem.text.toString(),
                    status = false
                )
            )
            list = db.todoDao().getAllTodo() as ArrayList<Todo>
            adapter.updateTasks(list)
        }


    }
}
