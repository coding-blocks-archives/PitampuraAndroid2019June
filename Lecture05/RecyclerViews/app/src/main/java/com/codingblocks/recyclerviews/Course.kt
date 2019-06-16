package com.codingblocks.recyclerviews

import kotlin.random.Random

data class Course(
    val name: String,
    val teacher: String,
    val center: String,
    val lectures: Int
)

val courseNames = arrayOf(
    "Launchpad", "Crux", "Android", "NodeJS", "Django",
    "Data Science", "Machine Learning", "Competitive Programming"
)

val teacherNames = arrayOf(
    "Prateek", "Rishab", "Garima", "Anuj", "Kartik", "Arnav",
    "Dhruv", "Sanjeet", "Pulkit", "Rohan"
)

val centerNames = arrayOf(
    "Pitampura", "Dwarka", "Noida", "Dehradun"
)

fun genNRandomCourses(n: Int): ArrayList<Course> {
    val courses = ArrayList<Course>()

    for (i in 1..n) {
        courses.add(Course(
            courseNames[Random.nextInt(8)],
            teacherNames[Random.nextInt(10)],
            centerNames[Random.nextInt(4)],
            Random.nextInt(10, 20)
        ))
    }

    return courses
}