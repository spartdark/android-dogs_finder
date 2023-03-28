package com.vsaldivarm.dogsdex.api

import com.vsaldivarm.dogsdex.Dog

//Va a funcionar para cualquier tipo de dato <T>
sealed class ApiResponseStatus<T> {
    class Success<T>(val data: T): ApiResponseStatus<T>()
    class  Loading<T>:ApiResponseStatus<T>()
    class Error <T>(val message: String):ApiResponseStatus<T>()
}