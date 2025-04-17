package model.classes.apiResponseClasses

import kotlinx.serialization.Serializable

@Serializable
data class CartItemResponse(
    val count: Int,
    val product: ProductsResponse
)