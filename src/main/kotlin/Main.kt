import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import view.cartScreen.CartScreen
import view.categoryScreen.CategoryScreen
import view.mainScren.MainScreen

@Composable
@Preview
fun App() {
    MaterialTheme{
        MainScreen()
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
