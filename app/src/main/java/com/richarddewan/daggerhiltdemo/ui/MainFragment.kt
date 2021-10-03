package com.richarddewan.daggerhiltdemo.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.richarddewan.daggerhiltdemo.R
import com.richarddewan.daggerhiltdemo.databinding.MainFragmentBinding
import com.richarddewan.daggerhiltdemo.qualifier.DatabaseName
import com.richarddewan.daggerhiltdemo.worker.DemoWorker
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class MainFragment(
    @DatabaseName private val databaseName: String
) : Fragment(R.layout.main_fragment) {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    //private val viewModel: MainViewModel by viewModels()
    private val viewModel: MainViewModel by activityViewModels()

    private val stringBuilder: StringBuilder by lazy {
        StringBuilder()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return  _binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnHomeFragment.setOnClickListener {
           /* activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_fragment_container, HomeFragment::class.java, null)
                ?.addToBackStack(TAG)
                ?.commit()*/
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToHomeFragment())
        }

        //get the database name
        getDatabaseName()

        //get user list
        getUsers()

        //work
        demoWork()
    }

    private fun getDatabaseName() {
        viewModel.databaseName.observe(viewLifecycleOwner, {
            Log.d(TAG,viewModel.toString())
            binding.daName.text = it
        })
    }

    private fun getUsers(){
        viewModel.userList.observe(viewLifecycleOwner, {userList->
            userList.forEach {
                stringBuilder.append(it)
                stringBuilder.append(" ")
            }
            binding.txtUserList.text = stringBuilder

        })
    }

    private fun demoWork(){
        val request = OneTimeWorkRequestBuilder<DemoWorker>().build()
        WorkManager.getInstance(requireContext().applicationContext)
            .enqueue(request)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "Fragment"
    }

}