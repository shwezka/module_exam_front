package view.cartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import model.classes.ProductClass
import theme.gray
import theme.green

@Composable
fun CartElement(
    product: ProductClass,
) {
    var amount by remember { mutableStateOf(product.amount) }
    val isMinusActive = amount > 1
    println(amount)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), // чуть-чуть воздуха
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(product.image),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )

        Spacer(modifier = Modifier.width(50.dp)) // фиксированный отступ между картинкой и текстом

        Column(
            modifier = Modifier
                .weight(1f) // текст займет всё доступное пространство между картинкой и контролами
        ) {
            Text(
                product.name,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = product.volume,
                style = MaterialTheme.typography.subtitle1
            )
        }
        AmountControls(
            onMinusButtonClick = {
                amount--
            },
            onPlusButtonClick = {
                amount++
            },
            isMinusActive = isMinusActive
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = amount.toString(),
        )
        Spacer(modifier = Modifier.weight(1f))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = { },
            ) {
                Icon(
                    painter = painterResource("images/controls/delete.svg"),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp),
                    tint = gray,
                )
            }
            Text(
                text = "$${product.price}",
            )
        }
    }
}

@Composable
fun ControlsRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {},
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
        Text(
            text = "Корзина",
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(1f))

    }
}

@Composable
fun AmountControls(
    onMinusButtonClick: () -> Unit,
    onPlusButtonClick: () -> Unit,
    isMinusActive: Boolean,
) {
    Row() {
        OutlinedButton(
            onClick = onMinusButtonClick,
            enabled = isMinusActive,
        ) {
            Icon(
                painter = painterResource("images/controls/minus.svg"),
                contentDescription = null,
            )
        }

    }
    Spacer(modifier = Modifier.width(20.dp))
    OutlinedButton(
        onClick = onPlusButtonClick,
    ) {
        Icon(
            painter = painterResource("images/controls/plus.svg"),
            contentDescription = null,
            tint = green
        )
    }
}