package ru.easycode.zerotoheroandroidtdd

import ru.easycode.zerotoheroandroidtdd.data.SimpleResponse

interface LoadResult {
    fun show (updateLiveData: LiveDataWrapper.Update)

    data class Success(val data: SimpleResponse) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            
        }
    }

    data class Error(val noConnection: Boolean) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {

        }
    }
}