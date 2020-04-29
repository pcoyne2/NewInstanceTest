package com.pcoyne.testapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    val testObjectMutable = MutableLiveData<TestObject>()

    init {
//        testObjectMutable.value = "main"
    }
}
