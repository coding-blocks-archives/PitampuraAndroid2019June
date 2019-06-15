package com.codingblocks.calculator

class Person(
    private var firstName: String,
    private var lastName: String,
    private var job: String,
    private var city: String,
    private var state:String
    ) {

    fun getFirstName() = firstName

    fun getLastName(): String {
        return lastName
    }

    fun getJob() = job

    fun getcity() = city

    fun getState() = state
}


data class SmartPerson(
    val firstName:String,
    val lastName:String,
    val job:String,
    val city:String,
    val state:String
){
    private val fullName :String

    init {
        fullName = "$firstName $lastName"

    }

    fun getFullName() = fullName

}

