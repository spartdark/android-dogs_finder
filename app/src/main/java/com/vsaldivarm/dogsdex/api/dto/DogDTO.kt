package com.vsaldivarm.dogsdex.api.dto

import com.squareup.moshi.Json

data class DogDTO (
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "dog_type")
    val dog_type:String,
    @field:Json(name = "height_female")
    val height_female:String,
    @field:Json(name = "height_male")
    val height_male:String,
    @field:Json(name = "image_url")
    val image_url: String,
    @field:Json(name = "index")
    val index: Int,
    @field:Json(name = "life_expectancy")
    val life_expectancy:String,
    @field:Json(name = "name_en")
    val name_en: String,
    @field:Json(name = "name_es")
    val name_es: String,
    @field:Json(name = "temperament")
    val temperament: String,
    @field:Json(name = "temperament_en")
    val temperament_en: String,
    @field:Json(name = "weight_female")
    val weight_female: String,
    @field:Json(name = "weight_male")
    val weight_male: String,
    @field:Json(name = "created_at")
    val created_at: String,
    @field:Json(name = "updated_at")
    val updated_at: String,
    @field:Json(name = "ml_id")
    val ml_id: String){

}