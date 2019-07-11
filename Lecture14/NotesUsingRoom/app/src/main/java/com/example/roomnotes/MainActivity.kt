package com.example.roomnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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
    val fillform: MutableLiveData<Boolean> = MutableLiveData()

    val mediatorLiveData: MediatorLiveData<Boolean> = MediatorLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = TaskAdapter(list)


        db.todoDao().getAllTodo().observe(this, Observer {
            list = it.filter { todo -> todo.task.contains("Pu", true) } as ArrayList<Todo>
            adapter.updateTasks(list)
        })

        fillform.value = true

        fillform.observe(this, Observer {

        })

        mediatorLiveData.addSource(fillform, {

        })


        mediatorLiveData.removeSource(fillform)


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
        }


    }
}
