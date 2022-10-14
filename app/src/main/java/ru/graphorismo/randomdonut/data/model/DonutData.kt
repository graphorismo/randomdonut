package ru.graphorismo.randomdonut.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DonutData(
    val name: String,
    val description: String,
    val imageUrl: String
)
