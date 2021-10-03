package com.richarddewan.daggerhiltdemo.module

import android.content.Context
import com.richarddewan.daggerhiltdemo.qualifier.ApiKey
import com.richarddewan.daggerhiltdemo.qualifier.DatabaseName
import com.richarddewan.daggerhiltdemo.repository.UserRepositoryImpl
import com.richarddewan.daggerhiltdemo.util.DatabaseService
import com.richarddewan.daggerhiltdemo.worker.DemoWorkerDependencies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @DatabaseName
    @Provides
    fun provideDatabaseName(): String {
        return "local.db"
    }

    @Singleton
    @ApiKey
    @Provides
    fun provideApiKey(): String {
        return "as343da345sd123123"
    }

    @Singleton
    @Provides
    fun provideDatabaseService(@ApplicationContext context: Context): DatabaseService {
        return  DatabaseService(context)
    }

    @Singleton
    @Provides
    fun provideUserRepository(@DatabaseName databaseName: String) : UserRepositoryImpl {
        return  UserRepositoryImpl(databaseName)
    }

    @Singleton
    @Provides
    fun provideDemoWork(): DemoWorkerDependencies {
        return DemoWorkerDependencies()
    }


}