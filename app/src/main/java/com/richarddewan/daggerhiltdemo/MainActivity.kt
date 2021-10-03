package com.richarddewan.daggerhiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.richarddewan.daggerhiltdemo.ui.MainFragment
import com.richarddewan.daggerhiltdemo.util.AppFragmentFactory
import com.richarddewan.daggerhiltdemo.util.DatabaseService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        const val  TAG = "MainActivity"
    }

    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var carFunctions: CarFunctionsImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carFun = carFunctions.doDrive()
        val addResult = carFunctions.insert()
        Log.d(TAG, carFun)
        Log.d(TAG, addResult.toString())

        /*supportFragmentManager.fragmentFactory = appFragmentFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container,MainFragment::class.java,null)
            .commit()
*/

    }
}