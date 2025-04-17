package view.fullProdPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.classes.ProductClass
import theme.gray
import theme.green
import theme.textFieldBackground
import theme.white
import view.NavigationManager
import view.cartScreen.products

@Composable
fun ImageDisplay(
    image: String,
){
    Row(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .background(
                color = textFieldBackground,
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                    )
            ),

    ){
        Box(){
            Controls()
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(400.dp)
            )
        }
    }
}

@Composable
fun Controls(){
    Row(
        modifier = Modifier
            .padding(10.dp)
    ){
        IconButton(
            onClick = {NavigationManager.goBack()},
            modifier = Modifier,
        ) {
            Icon(
                painter = painterResource("images/controls/goback.svg"),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {},
            modifier = Modifier,
        ) {
            Icon(
                painter = painterResource("images/controls/share.svg"),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
            )
        }
    }
}

@Composable
fun AmountControls(
    onMinusButtonClick: () -> Unit,
    onPlusButtonClick: () -> Unit,
    isMinusActive: Boolean,
    prodAmount: Int,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = onMinusButtonClick,
            enabled = isMinusActive,
        ) {
            Icon(
                painter = painterResource("images/controls/minus.svg"),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = prodAmount.toString(),
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
            onClick = onPlusButtonClick,
        ) {
            Icon(
                painter = painterResource("images/controls/plus.svg"),
                contentDescription = null,
                tint = green
            )
        }
    }
}

@Composable
fun InfoComponent(
    product: ProductClass
){
    var amount by remember { mutableStateOf(product.amount) }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.width(300.dp)
            ) {
                Text(
                    text = product.name,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp
                )
                Text(
                    text = product.volume,
                    textAlign = TextAlign.Start,
                    color = gray,
                    fontSize = 10.sp
                )
                AmountControls(
                    onPlusButtonClick = {
                        amount++
                    },
                    isMinusActive = amount < 1,
                    onMinusButtonClick = {
                        amount--
                    },
                    prodAmount = amount,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        painter = painterResource("images/controls/fav.svg"),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "$${product.price}",
                )
            }
        }
        Divider()
        Row(){
            Column{
                Text(
                    text = "Product detail",
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = product.detail,
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Divider()
        Row {
            Column{
                Text(
                    text = "Nutrients",
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = product.nutritions,
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = green,
            )
        ){
            Text(
                text = "Добавить в корзину",
                color = white,
            )
        }
    }
}