package model.classes

import androidx.compose.ui.graphics.Color

data class CategoryClass(
    val catId: Int = 0,
    val name: String,
    val backColor: Color,
    val borderColor: Color,
    val image: String,
)