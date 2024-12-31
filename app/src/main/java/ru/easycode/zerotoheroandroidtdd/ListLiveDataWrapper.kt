package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.lifecycle.LiveData

interface ListLiveDataWrapper {

    fun liveData(): LiveData<List<CharSequence>>

    fun add(new: CharSequence)

    fun save(bundle: BundleWrapper.Save)

    fun update(list: List<CharSequence>)


}