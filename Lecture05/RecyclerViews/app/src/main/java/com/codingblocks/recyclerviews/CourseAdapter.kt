package com.codingblocks.recyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_course.view.*

class CourseAdapter(
    val courseList: ArrayList<Course>
): RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_item_course, parent, false)
        return CourseViewHolder(itemView)
    }

    override fun getItemCount(): Int  = courseList.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {

        val course = courseList[position]
        holder.itemView.tvCourseName.text = course.name
        holder.itemView.tvTeacher.text = course.teacher
        holder.itemView.tvCenter.text = course.center
        holder.itemView.tvLectures.text = course.lectures.toString()

    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}