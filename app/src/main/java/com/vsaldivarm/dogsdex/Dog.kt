package com.vsaldivarm.dogsdex

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog (
    val id: Long,
    val dog_type:String,
    val height_female:String,
    val height_male:String,
    val image_url: String,
    val index: Int,
    val life_expectancy:String,
    val name_en: String,
    val name_es: String,
    val temperament: String,
    val temperament_en: String,
    val weight_female: String,
    val weight_male: String,
    val created_at: String,
    val updated_at: String,
    val ml_id: String): Parcelable
