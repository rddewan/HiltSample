package com.richarddewan.daggerhiltdemo.repository

import com.richarddewan.daggerhiltdemo.qualifier.DatabaseName
import javax.inject.Singleton


/*
created by Richard Dewan 26/09/2021
*/

@Singleton
class UserRepositoryImpl(@DatabaseName private val databaseName: String): UserRepository {

    override fun getDatabaseName(): String {
        return databaseName
    }

    override fun getUserList(): List<String> {
        return listOf("David","Sita","Rita")
    }
}