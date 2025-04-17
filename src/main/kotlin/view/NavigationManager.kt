package view

import Screens
import androidx.compose.runtime.mutableStateOf
import model.classes.ProductClass

object NavigationManager {
    var currentScreen = mutableStateOf(Screens.MAIN)
    var selectedCategoryId = mutableStateOf(0)
    var selectedProductId = mutableStateOf(0)

    private fun navigateTo(screen: Screens) {
        currentScreen.value = screen
    }

    fun navigateToCategory(categoryId: Int) {
        selectedCategoryId.value = categoryId
        currentScreen.value = Screens.CATEGORY
    }

    val selectedProduct = mutableStateOf<ProductClass?>(null)

    fun navigateToProduct(product: ProductClass) {
        selectedProduct.value = product
        currentScreen.value = Screens.PRODUCT
    }

    fun navigateToCart() {
        navigateTo(Screens.CART)
    }

    fun navigateToMain() {
        navigateTo(Screens.MAIN)
    }


    fun goBack() {
        navigateTo(Screens.MAIN)
    }
}