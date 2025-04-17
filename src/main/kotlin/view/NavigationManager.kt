package view

import Screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import model.classes.ProductClass
import theme.white
import view.NavigationManager.selectedCategoryId

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

@Composable
fun BottomBar() {
    BottomAppBar(
        backgroundColor = white
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = {
                NavigationManager.navigateToMain()
            }) {
                Icon(
                    painterResource("images/bottomBar/shop.svg"),
                    contentDescription = null,
                )
            }
            IconButton(onClick = {
                NavigationManager.navigateToCart()
            }) {
                Icon(
                    painterResource("images/bottomBar/cart.svg"),
                    contentDescription = null,
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painterResource("images/bottomBar/bookmark.svg"),
                    contentDescription = null,
                )
            }
        }
    }
}