package view.fullProdPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.classes.ProductClass
import theme.background

@Composable
fun FullProdPage(
    product: ProductClass
) {
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
        ImageDisplay(product.image)
        InfoComponent(product)
    }
}