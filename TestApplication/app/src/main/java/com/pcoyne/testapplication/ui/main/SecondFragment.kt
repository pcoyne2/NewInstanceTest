package com.pcoyne.testapplication.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pcoyne.testapplication.R

class SecondFragment : Fragment() {

    private lateinit var viewModel: SecondViewModel
//    private lateinit var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)


        arguments?.get(OBJECT)?.let {
            Log.d("Argument", (it as TestObject).toString())
            viewModel.testObjectMutable.value = it as TestObject
            Log.d("ViewModel", viewModel.testObjectMutable.value.toString())
            viewModel.testObjectMutable.value?.id = "second"
            Log.d("UpdateSecViewModel", viewModel.testObjectMutable.value.toString())
        }

        view.findViewById<TextView>(R.id.message).setText(viewModel.testObjectMutable.value!!.id)


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {

        private const val OBJECT = "OBJECT"


        fun newInstance(testObject: TestObject) = SecondFragment().apply {
            arguments = Bundle().apply {
                putParcelable(OBJECT, testObject)
            }
        }
    }

}
