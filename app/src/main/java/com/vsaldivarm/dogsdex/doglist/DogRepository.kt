package com.vsaldivarm.dogsdex.doglist

import android.util.Log
import com.vsaldivarm.dogsdex.Dog
import com.vsaldivarm.dogsdex.api.DogsApi
import com.vsaldivarm.dogsdex.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    private var TAG =   this::class.java.simpleName

    //el metodo es de tipo suspend por que esta dentro de una corutine
    suspend fun downloadDogs(): List<Dog> {
        //IO descargar cosas de internet o acceder a DB (hilo secundario)
        return withContext(Dispatchers.IO) {
            //DogsApi.retrofitService.getAllDogs()
            val dogListApiResponse = DogsApi.retrofitService.getAllDogs()
            Log.i(TAG,"My Response: $dogListApiResponse")
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDTOListToDogDomainList(dogListApiResponse.data.dogs)
        }
    }

/*    private fun getFakeDogs(): MutableList<Dog> {
        val dogList = mutableListOf<Dog>()
        dogList.add(
            Dog(
                1, 1, "Chihuahua", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dog(
                2, 1, "Labrador", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dog(
                3, 1, "Retriever", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dog(
                4, 1, "San Bernardo", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dog(
                5, 1, "Husky", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dog(
                6, 1, "Xoloscuincle", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        return dogList
    }*/
}