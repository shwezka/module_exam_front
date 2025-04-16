package model.classes.apiResponseClasses

import kotlinx.serialization.Serializable
import model.classes.ProductClass


@Serializable
data class ProductsResponse(
    val productuid: Int,
    val name: String,
    val price: Float,
    val volume: String,
    val detail: String,
    val image: String,
    val nutritions: String,
)

fun ProductsResponse.toProductClass(): ProductClass {
    println(ProductsResponse)
    return ProductClass(
        productuid = productuid,
        name = name,
        price = price,
        volume = volume,
        detail = detail,
        image = "images/prods/${image}.png",
        nutritions = nutritions,
        amount = 0
    )
}