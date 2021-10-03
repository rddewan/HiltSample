package com.richarddewan.daggerhiltdemo.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.richarddewan.daggerhiltdemo.repository.UserRepositoryImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


/*
created by Richard Dewan 03/10/2021
*/
@HiltWorker
class DemoWorker @AssistedInject constructor(
    @Assisted context:Context,
    @Assisted workerParameters: WorkerParameters,
    private val demoWorkerDependencies: DemoWorkerDependencies,
    private val userRepositoryImpl: UserRepositoryImpl
) : Worker(context, workerParameters){

    override fun doWork(): Result {
        Log.d(TAG, "Worker started")
        val users = userRepositoryImpl.getUserList()
        users.forEach {
            Log.d(TAG, it)
        }
        for (i in 0..demoWorkerDependencies.counter) {
            Log.d(TAG, "$i")
        }

        return Result.success()
    }

    companion object {
        const val TAG = "DemoWorker"
    }
}