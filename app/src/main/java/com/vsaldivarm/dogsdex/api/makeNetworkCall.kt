package com.vsaldivarm.dogsdex.api

import android.util.Log
import com.vsaldivarm.dogsdex.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException


suspend fun <T> makeNetworkCall(
    call: suspend () -> T
): ApiResponseStatus<T>

    = withContext (Dispatchers.IO) {
        //IO descargar cosas de internet o acceder a DB (hilo secundario)
        try {
            ApiResponseStatus.Success(call())

        } catch (e: UnknownHostException) {
            ApiResponseStatus.Error("Error de red")
        } catch (e: Exception) {
            ApiResponseStatus.Error(e.message.toString())
        }
    }

