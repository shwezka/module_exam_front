package model.classes

data class ProductClass(
    val productuid: Int = 1,
    val name: String,
    val price: Float,
    val volume : String,
    val detail:String,
    val image:String,
    val nutritions:String,
    val amount: Int,
)