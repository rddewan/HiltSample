package com.richarddewan.daggerhiltdemo.module

import android.content.Context
import com.richarddewan.daggerhiltdemo.CarFunctions
import com.richarddewan.daggerhiltdemo.CarFunctionsImpl
import com.richarddewan.daggerhiltdemo.qualifier.ApiKey
import com.richarddewan.daggerhiltdemo.qualifier.DatabaseName
import com.richarddewan.daggerhiltdemo.repository.CarRepository
import com.richarddewan.daggerhiltdemo.util.DatabaseService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent


/*
created by Richard Dewan 18/09/2021
*/

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @ActivityScoped
    @Provides
    fun provideCarRepository(@DatabaseName databaseName: String, @ApiKey apiKey: String) : CarRepository {
        return CarRepository(databaseName, apiKey)
    }

    @ActivityScoped
    @Provides
    fun provideCarFunctionsImpl(carRepository: CarRepository): CarFunctions {
        return  CarFunctionsImpl(carRepository)
    }

    /*@ActivityScoped
    @Provides
    fun provideDatabaseService(@ActivityContext context: Context): DatabaseService {
        return  DatabaseService(context)
    }*/



    /**
     * The @Binds annotation tells Hilt which implementation to use when it needs to provide an instance of an interface.
     * The annotated function provides the following information to Hilt:

    The function return type tells Hilt what interface the function provides instances of.
    The function parameter tells Hilt which implementation to provide.
     */
    /*@Binds
    abstract fun bindCarFunction(carFunctionsImpl: CarFunctionsImpl): CarFunctions*/
}