package com.pcoyne.testapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val testObject = MutableLiveData<TestObject>()
    init {
        testObject.value = TestObject()
    }
}
