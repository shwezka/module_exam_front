package model.classes.apiResponseClasses

import kotlinx.serialization.Serializable

@Serializable
data class CartRequest(
    val useruid: Int,
    val productuid: Int,
    val count: Int
)