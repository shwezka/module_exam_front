package model.classes.apiResponseClasses
import kotlinx.serialization.Serializable
import model.classes.CategoryClass
import theme.getRandomCategoryBorderColor
import theme.getRandomCategoryColor

@Serializable
data class CategoryResponse(
    val categoryuid: Int,
    val name: String,
    val image: String
)

fun CategoryResponse.toCategory(): CategoryClass {
    return CategoryClass(
        catId = categoryuid,
        name = name,
        backColor = getRandomCategoryColor(), // или что-то динамическое
        borderColor = getRandomCategoryBorderColor(),
        image = "images/catImages/$image.png"
    )
}