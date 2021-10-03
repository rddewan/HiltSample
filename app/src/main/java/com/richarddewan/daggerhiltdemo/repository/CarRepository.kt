package com.richarddewan.daggerhiltdemo.repository

import com.richarddewan.daggerhiltdemo.qualifier.ApiKey
import com.richarddewan.daggerhiltdemo.qualifier.DatabaseName
import javax.inject.Inject
import javax.inject.Singleton


/*
created by Richard Dewan 18/09/2021
*/

@Singleton
class CarRepository @Inject constructor(
    @DatabaseName private val databaseName: String,
    @ApiKey private val apiKey: String
){

    fun addRow(): Int{
        return 101
    }

    fun getDatabaseName(): String {
        return databaseName
    }

    fun getApiKey(): String {
        return  apiKey
    }


}