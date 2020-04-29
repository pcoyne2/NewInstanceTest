package com.pcoyne.testapplication.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pcoyne.testapplication.MainActivity
import com.pcoyne.testapplication.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        view.findViewById<TextView>(R.id.message).setOnClickListener {
            Log.d("ViewModel", viewModel.testObject.value!!.toString())
            val objectToPass = viewModel.testObject.value!!
            Log.d("Argument", objectToPass.toString())
            val frag = SecondFragment.newInstance(objectToPass)
            (activity as MainActivity).addFragmentToBackStack(frag)
        }

        view.findViewById<TextView>(R.id.message).setText(viewModel.testObject.value!!.id)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
