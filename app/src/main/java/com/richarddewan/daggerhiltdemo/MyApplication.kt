package com.richarddewan.daggerhiltdemo

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


/*
created by Richard Dewan 18/09/2021
*/
@HiltAndroidApp
class MyApplication: Application(), Configuration.Provider {

    @Inject lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration {
        return  Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}