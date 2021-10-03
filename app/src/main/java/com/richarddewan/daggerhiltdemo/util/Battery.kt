package com.richarddewan.daggerhiltdemo.util

import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton


/*
created by Richard Dewan 18/09/2021
*/
@ActivityScoped
class Battery @Inject constructor() {

    fun getBattterySize(): Int {
        return 12
    }
}