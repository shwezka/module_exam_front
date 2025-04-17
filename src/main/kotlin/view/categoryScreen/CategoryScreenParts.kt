package view.categoryScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.classes.CategoryClass
import model.classes.ProductClass
import theme.*
import view.NavigationManager

@Composable
fun CategoryControls(
    category: CategoryClass
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
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
        Text(
            text = category.name,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {},
            modifier = Modifier,
        ) {
            Icon(
                painter = painterResource("images/controls/setts.svg"),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
            )
        }
    }
}

@Composable
fun ProductCard(
    product: ProductClass,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .height(400.dp)
            .width(150.dp)
//            .fillMaxHeight()
            .clickable {
                onClick()
            }
            .padding(20.dp),
        backgroundColor = background,
        border = BorderStroke(
            width = 1.dp,
            color = gray,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(product.image),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(
                text = product.name,
                modifier = Modifier,
                color = textCardColor,
                fontSize = 20.sp,
            )
            Text(
                text = product.volume,
                modifier = Modifier
                    .width(100.dp),
                color = gray,
                fontSize = 10.sp,
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "$${product.price}",
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(100.dp)
                        .width(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = green,
                    )
                ){
                    Icon(
                        painter = painterResource("images/controls/plus.svg"),
                        contentDescription = null,
                        tint = white,
                    )
                }
            }
        }
    }
}