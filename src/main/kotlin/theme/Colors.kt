package theme

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

private val categoryColor1 = Color(0x3353B175)
private val categoryBorderColor1 = Color(0xB353B175)
private val categoryColor2 = Color(0x33F8A44C)
private val categoryBorderColor2 = Color(0xB3F8A44C)
private val categoryColor3 = Color(0x33F7A593)
private val categoryBorderColor3 = Color(0xB3F7A593)
private val categoryColor4 = Color(0x33FDE598)
private val categoryBorderColor4 = Color(0xB3FDE598)
private val categoryColor5 = Color(0x33B7DFF5)
private val categoryBorderColor5 = Color(0xB3B7DFF5)
private val categoryColor6 = Color(0x33D3B0E0)
private val categoryBorderColor6 = Color(0xB3D3B0E0)

val listOfCategoryColors = listOf(
    categoryColor1,
    categoryColor2,
    categoryColor3,
    categoryColor4,
    categoryColor5,
    categoryColor6
    )

val listofCategoryBorderColors = listOf(
    categoryBorderColor1,
    categoryBorderColor2,
    categoryBorderColor3,
    categoryBorderColor4,
    categoryBorderColor5,
    categoryBorderColor6
)

fun getRandomCategoryColor(): Color {
    return listOfCategoryColors[listOfCategoryColors.indices.random()]
}

fun getRandomCategoryBorderColor(): Color {
    return listofCategoryBorderColors[listofCategoryBorderColors.indices.random()]
}

val background = Color(0xFFFFFFFF)
val textFieldBackground = Color(0xFFF2F3F2)
val textColor = Color(0xFF4C4F4D)
val green = Color(0xFF53B175)
val textCardColor = Color(0xFF181725)

val gray = Color(0xFFB3B3B3)