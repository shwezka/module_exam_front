import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import view.cartScreen.CartScreen
import view.categoryScreen.CategoryScreen
import view.fullProdPage.FullProdPage
import view.mainScren.MainScreen

@Composable
@Preview
fun App() {
    val api = remember { ApiConnector() }
    var categories by remember { mutableStateOf<List<CategoryClass>?>(null) }
    var prods by remember{mutableStateOf<List<ProductClass>?>(null) }

    LaunchedEffect(Unit) {
        categories = api.fetchCategories()
        prods = api.fetchProducts(1)
    }

    MaterialTheme {
        Scaffold(bottomBar = {}) {
            when {
                categories == null -> {
                    // Показываем загрузку
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }

                categories!!.isNotEmpty() -> {
                    // Когда данные загружены
//                    CategoryScreen(
//                        api = api,
//                        category = categories!![5]
//                    )
                    FullProdPage(
                        product = prods?.get(1) ?: ProductClass(
                            productuid = 0,
                            name = "TODO()",
                            price = 1.0F,
                            volume = "",
                            detail = "",
                            image = "images/prods/ph.png",
                            nutritions = "",
                            amount = 1
                        )
                    )
                }

                else -> {
                    // В случае пустого списка
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Категории не найдены")
                    }
                }
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
