package ru.easycode.zerotoheroandroidtdd

import ru.easycode.zerotoheroandroidtdd.data.SimpleResponse

interface LoadResult {
    fun show (updateLiveData: LiveDataWrapper.Update)

    data class Success(private val data: SimpleResponse) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(data.text))
        }
    }

    data class Error(private val noConnection: Boolean) : LoadResult {
        val result = if (noConnection) "No internet connection" else "Something went wrong"

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(result))
        }
    }
}