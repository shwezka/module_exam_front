package view.cartScreen

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.classes.ProductClass
import theme.background
import theme.green

val products = listOf(
    ProductClass(
        name = "Болгарский перец",
        price = 4.99F,
        volume = "1kg",
        detail = "",
        image = "images/cart/pepper.png",
        nutritions = "100gr",
        amount = 2,
    ),
    ProductClass(
        name = "Куриные яйца",
        price = 1.99F,
        volume = "4pcs",
        detail = "",
        image = "images/cart/eggs.png",
        nutritions = "100gr",
        amount = 2,
    ),
    ProductClass(
        name = "Бананы",
        price = 2.99F,
        volume = "12kg",
        detail = "",
        image = "images/cart/banana.png",
        nutritions = "100gr",
        amount = 2,

    ),
    ProductClass(
        name = "Хрен",
        price = 2.99F,
        volume = "250gm",
        detail = "",
        image = "images/cart/her.png",
        nutritions = "100gr",
        amount = 2,
    )
)

@Composable
fun CartScreen(){
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
            itemsIndexed(products) { _, product ->
                Divider(color = Color.Gray)
                CartElement(product)
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