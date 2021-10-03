package com.richarddewan.daggerhiltdemo.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.richarddewan.daggerhiltdemo.HomeViewModel
import com.richarddewan.daggerhiltdemo.MainActivity
import com.richarddewan.daggerhiltdemo.R
import com.richarddewan.daggerhiltdemo.databinding.HomeFragmentBinding
import com.richarddewan.daggerhiltdemo.qualifier.ApiKey
import com.richarddewan.daggerhiltdemo.util.Car
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment(
    @ApiKey private val apiKey: String
) : Fragment(R.layout.home_fragment) {

    @Inject
    lateinit var car: Car

    //private val viewModel: MainViewModel by viewModels()
    private val viewModel: MainViewModel by activityViewModels()

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = car.getCarName()
        val batterySize = car.getBatterySize()
        Log.d(MainActivity.TAG, name)
        Log.d(MainActivity.TAG, batterySize)

        binding.txtApiKey.text = apiKey
        //get the database name
        getDatabaseName()
    }

    private fun getDatabaseName() {
        viewModel.databaseName.observe(viewLifecycleOwner, {
            Log.d(TAG,it)
            Log.d(TAG,viewModel.toString())
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "Fragment"
    }


}