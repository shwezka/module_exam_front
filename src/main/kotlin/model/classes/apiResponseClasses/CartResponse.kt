package model.classes.apiResponseClasses

import kotlinx.serialization.Serializable
import model.classes.ProductClass

@Serializable
data class CartItemResponse(
    val count: Int,
    val product: ProductsResponse
)

fun CartItemResponse.toProduct(): ProductClass{
    return ProductClass(
        productuid = product.productuid,
        name = product.name,
        price = product.price,
        volume = product.volume,
        detail = product.detail,
        image = "images/prods/${product.image}.png",
        nutritions = product.nutritions,
        amount = count
    )
}