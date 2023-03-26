package com.vsaldivarm.dogsdex.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsaldivarm.dogsdex.Dog
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel(){

    private  val dogRepository = DogRepository()
    //privado ( no puede sre editado desde la vista)
    private val _dogList = MutableLiveData<List<Dog>>()
    //publico
    val dogList : LiveData<List<Dog>>
        get() = _dogList

    init{
        //descarge los perros en cuanto inicie la app
        downloadDogs()
    }

    private fun downloadDogs() {
        //coroutines para descargar datos
        viewModelScope.launch {
            _dogList.value = dogRepository.downloadDogs()
        }
    }


}