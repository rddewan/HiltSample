package com.richarddewan.daggerhiltdemo.repository


/*
created by Richard Dewan 26/09/2021
*/

interface UserRepository {

    fun getDatabaseName(): String

    fun getUserList(): List<String>
}