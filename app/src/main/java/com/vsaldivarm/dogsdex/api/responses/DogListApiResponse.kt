package com.vsaldivarm.dogsdex.api.responses

import com.squareup.moshi.Json

data class DogListApiResponse(
    @field:Json(name = "message")
    val messsage: String,
    @field:Json(name = "is_success")
    val is_success: Boolean,
    @field:Json(name = "data")
    val data: Data
) {
}