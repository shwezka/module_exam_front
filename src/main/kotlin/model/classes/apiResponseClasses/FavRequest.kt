package model.classes.apiResponseClasses

import kotlinx.serialization.Serializable

@Serializable
data class FavRequest(
    val useruid: Int,
    val productuid: Int
)