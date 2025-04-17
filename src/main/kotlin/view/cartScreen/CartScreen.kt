package view.cartScreen

import LoadingScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.api.ApiConnector
import model.classes.ProductClass
import model.classes.apiResponseClasses.CartItemResponse
import model.classes.apiResponseClasses.toProductClass
import theme.background
import theme.green

@Composable
fun CartScreen(api: ApiConnector) {

    var cart by remember { mutableStateOf<List<CartItemResponse>?>(null) }

    // Загружаем cart каждый раз при заходе на экран
    LaunchedEffect(Unit) {
        cart = api.fetchCartItems()
    }

    if (cart == null) {
        LoadingScreen()
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = background)
            .padding(
                start = 30.dp,
                end = 30.dp,
                top = 10.dp,
                bottom = 10.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ControlsRow()
        LazyColumn {
            itemsIndexed(cart!!) { _, cart ->
                Divider(color = Color.Gray)
                CartElement(cart.product.toProductClass().copy(amount = cart.count))
            }
        }
        Divider(color = Color.Gray)
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = green,
            )
        ){
            Text(
                text = "Оплатить"
            )
        }
    }
}