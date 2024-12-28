package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.data.Repository

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) {

    val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun load(){
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch{
            val result = repository.load()
            liveDataWrapper.update(UiState.ShowData(result.text))
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save){
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore){
        liveDataWrapper.update(bundleWrapper.restore())
    }

    fun liveData(): LiveData<UiState> = liveDataWrapper.liveData()
}