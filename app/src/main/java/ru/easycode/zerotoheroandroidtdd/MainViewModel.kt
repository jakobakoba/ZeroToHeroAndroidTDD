package ru.easycode.zerotoheroandroidtdd

class MainViewModel(
    private val listLiveDataWrapper: ListLiveDataWrapper
) {

    fun add(text: String){
        listLiveDataWrapper.add(text)
    }

    fun save(bundle: BundleWrapper.Save) {
        listLiveDataWrapper.save(bundle)
    }

    fun restore(bundle: BundleWrapper.Restore) {
        val data = bundle.restore()
        listLiveDataWrapper.update(data)
    }

    fun liveData() = listLiveDataWrapper.liveData()
}