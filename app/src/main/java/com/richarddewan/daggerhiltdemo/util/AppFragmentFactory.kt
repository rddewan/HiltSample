package com.richarddewan.daggerhiltdemo.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.richarddewan.daggerhiltdemo.ui.HomeFragment
import com.richarddewan.daggerhiltdemo.qualifier.ApiKey
import com.richarddewan.daggerhiltdemo.qualifier.DatabaseName
import com.richarddewan.daggerhiltdemo.ui.MainFragment
import javax.inject.Inject


/*
created by Richard Dewan 25/09/2021
*/

class AppFragmentFactory @Inject constructor(
    @DatabaseName private val databaseName: String,
    @ApiKey private val apiKey: String
) : FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            MainFragment::class.java.name -> {
                MainFragment(databaseName)
            }
            HomeFragment::class.java.name -> {
                HomeFragment(apiKey)
            }
            else ->super.instantiate(classLoader, className)
        }

    }
}