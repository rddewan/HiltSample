package com.richarddewan.daggerhiltdemo.util


import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton


/*
created by Richard Dewan 18/09/2021
*/

@ActivityScoped
class Car @Inject constructor(val battery: Battery,){

    fun getCarName(): String {
        return "This is a Toyota"
    }

    fun getBatterySize() : String{
       return "The battery size is ${ battery.getBattterySize()}"
    }

}