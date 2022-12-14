package com.vsaldivarm.dogsdex.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsaldivarm.dogsdex.Dog
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel(){

    private  val dogRepository = DogRepository()
    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList : LiveData<List<Dog>>
        get() = _dogList

    init{
        downloadDogs()
    }

    private fun downloadDogs() {
        viewModelScope.launch {
            _dogList.value = dogRepository.downloadDogs()
        }
    }


}