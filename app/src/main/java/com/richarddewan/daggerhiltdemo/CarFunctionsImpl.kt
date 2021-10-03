package com.richarddewan.daggerhiltdemo

import com.richarddewan.daggerhiltdemo.repository.CarRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


/*
created by Richard Dewan 18/09/2021
*/

@ActivityScoped
class CarFunctionsImpl @Inject constructor(private val carRepository: CarRepository): CarFunctions {

    override fun doDrive(): String {
        return "Car can drive"
    }

    fun insert(): Int{
        return carRepository.addRow()
    }
}