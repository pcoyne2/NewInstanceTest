package com.pcoyne.testapplication.ui.main

import android.os.Parcel
import android.os.Parcelable

class TestObject() : Parcelable {
    var id = "Main"

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestObject> {
        override fun createFromParcel(parcel: Parcel): TestObject {
            return TestObject(parcel)
        }

        override fun newArray(size: Int): Array<TestObject?> {
            return arrayOfNulls(size)
        }
    }
}