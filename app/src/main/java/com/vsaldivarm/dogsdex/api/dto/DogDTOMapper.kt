package com.vsaldivarm.dogsdex.api.dto

import com.vsaldivarm.dogsdex.Dog

class DogDTOMapper {
    private fun fromDogDTOToDogDomain(dogDTO: DogDTO): Dog {
        return Dog(
            dogDTO.id,
            dogDTO.dog_type,
            dogDTO.height_female,
            dogDTO.height_male,
            dogDTO.image_url,
            dogDTO.index,
            dogDTO.life_expectancy,
            dogDTO.name_en,
            dogDTO.name_es,
            dogDTO.temperament,
            dogDTO.temperament_en,
            dogDTO.weight_female,
            dogDTO.weight_male,
            dogDTO.created_at,
            dogDTO.updated_at,
            dogDTO.ml_id
        )
    }

    fun fromDTOListToDogDomainList(dogDTOList: List<DogDTO>): List<Dog> {
        return dogDTOList.map { fromDogDTOToDogDomain(it) }
    }
}