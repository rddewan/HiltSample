package com.richarddewan.daggerhiltdemo.util

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/*
created by Richard Dewan 02/10/2021
*/

@AndroidEntryPoint
class AppNavHostFragment: NavHostFragment() {

    @Inject
    lateinit var appFragmentFactory: AppFragmentFactory


    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = appFragmentFactory
    }
}