package com.codingblocks.todolist

interface ListItemClickListener{
    fun lisitemClick(task:TasksTable.Task,position:Int)
    fun textviewClick(text:String)
}