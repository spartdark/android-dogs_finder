package com.vsaldivarm.dogsdex.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsaldivarm.dogsdex.Dog
import com.vsaldivarm.dogsdex.api.ApiResponseStatus
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {

    private val dogRepository = DogRepository()

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    private val _networkStatus = MutableLiveData<ApiResponseStatus>()
    val networkStatus: LiveData<ApiResponseStatus>
        get() = _networkStatus

    init {
        //descarge los perros en cuanto inicie la app
        downloadDogs()
    }

    private fun downloadDogs() {
        //coroutines para descargar datos
        viewModelScope.launch {
            _networkStatus.value = ApiResponseStatus.LOADING
            try {
                _dogList.value = dogRepository.downloadDogs()
                _networkStatus.value = ApiResponseStatus.SUCCESS
            } catch (e: Exception) {
                _networkStatus.value = ApiResponseStatus.ERROR
            }
        }
    }


}