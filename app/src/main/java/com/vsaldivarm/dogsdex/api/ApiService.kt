package com.vsaldivarm.dogsdex.api

import com.vsaldivarm.dogsdex.BASE_URL
import com.vsaldivarm.dogsdex.Dog
import com.vsaldivarm.dogsdex.URL_DOGS
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiService{
    @GET(URL_DOGS)
    suspend fun getAllDogs(): List<Dog>
}

object DogsApi{
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}