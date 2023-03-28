package com.vsaldivarm.dogsdex.api

import com.vsaldivarm.dogsdex.Dog

sealed class ApiResponseStatus() {
    class Success(val dogList: List<Dog>):ApiResponseStatus()
    class  Loading():ApiResponseStatus()
    class Error (val message: String):ApiResponseStatus()
}