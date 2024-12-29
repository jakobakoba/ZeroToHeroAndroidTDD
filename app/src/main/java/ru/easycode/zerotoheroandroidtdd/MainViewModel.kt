package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.data.Repository

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val repository: Repository
): LiveDataWrapper.Observe {

    val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun load(){
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch{
            val result = repository.load()
            result.show(liveDataWrapper)
        }
    }

    fun save(bundleWrapper : BundleWrapper.Save){
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore){
        liveDataWrapper.update(bundleWrapper.restore())
    }

    override fun liveData(): LiveData<UiState> = liveDataWrapper.liveData()

}