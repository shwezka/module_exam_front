import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import model.api.ApiConnector
import model.classes.CategoryClass
import model.classes.ProductClass
import model.classes.apiResponseClasses.CartItemResponse
import view.BottomBar
import view.FavList
import view.NavigationManager
import view.cartScreen.CartScreen
import view.categoryScreen.CategoryScreen
import view.fullProdPage.FullProdPage
import view.mainScren.MainScreen

enum class Screens {
    MAIN,
    CATEGORY,
    PRODUCT,
    CART,
    FAVORITE
}



@Composable
@Preview
fun App() {
    val api = remember { ApiConnector() }

    var categories by remember { mutableStateOf<List<CategoryClass>?>(null) }
    var prods by remember { mutableStateOf<List<ProductClass>?>(null) }
    var cart by remember { mutableStateOf<List<ProductClass>?>(null) }

    // Загружаем категории при старте
    LaunchedEffect(Unit) {
        categories = api.fetchCategories()
        cart = api.fetchCartItems()
    }

    // Загружаем продукты при изменении selectedCategoryId
    LaunchedEffect(NavigationManager.selectedCategoryId.value) {
        prods = api.fetchProducts(NavigationManager.selectedCategoryId.value)
    }

    MaterialTheme {
        Scaffold(bottomBar = {
            BottomBar()
        }) {
            when (NavigationManager.currentScreen.value) {
                Screens.MAIN -> {
                    if (categories == null) {
                        LoadingScreen("Загрузка категорий...")
                    } else if (categories!!.isNotEmpty()) {
                        MainScreen()
                    } else {
                        ErrorScreen("Категории не найдены")
                    }
                }

                Screens.CATEGORY -> {
                    if (categories == null) {
                        LoadingScreen("Загрузка категорий...")
                    } else {
                        CategoryScreen(
                            api = api,
                            category = categories!![NavigationManager.selectedCategoryId.value]
                        )
                    }
                }

                Screens.PRODUCT -> {
                    if (prods == null) {
                        LoadingScreen("Загрузка продуктов...")
                    } else if (prods!!.isNotEmpty() &&
                        NavigationManager.selectedProductId.value in prods!!.indices
                    ) {
                        println("Selected product ID: ${NavigationManager.selectedProductId.value}")
                        println("Loaded products: ${prods!!.map { it.productuid }}")
                        val selectedProduct = prods!!.find {
                            it.productuid == NavigationManager.selectedProductId.value
                        }

                        val product = NavigationManager.selectedProduct.value
                        if (product != null) {
                            FullProdPage(
                                product = product,
                                api = api,
                            )
                        } else {
                            ErrorScreen("Продукт не найден")
                        }
                    } else {
                        ErrorScreen("Продукт не найден")
                    }
                }

                Screens.CART -> CartScreen(api)
                Screens.FAVORITE -> FavList(api)
            }
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Копеечка",
        state = WindowState(
            size = DpSize(1000.dp, 800.dp),
        )
    ) {
        App()
    }
}

@Composable
fun LoadingScreen(text: String = "Загрузка...") {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(text: String = "Что-то пошло не так") {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text)
        Button(
            onClick = {NavigationManager.goBack()}
        ){

        }
    }
}
