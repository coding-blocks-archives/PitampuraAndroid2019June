package com.example.roomnotes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Insert
    fun insertRow(todo: Todo)

    @Insert
    fun inserAll(todoList: ArrayList<Todo>)


    @Query("Select * FROM Todo")
    fun getAllTodo(): List<Todo>

    @Query("Select * FROM Todo WHERE task = :task")
    fun getAllTodoWithDone(task:String):List<Todo>

    @Delete
    fun delete(todo: Todo)

}