package view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.api.ApiConnector
import model.classes.ProductClass
import view.categoryScreen.ProductCard

@Composable
fun FavList(
    api: ApiConnector
) {
    var favs by remember { mutableStateOf<List<ProductClass>>(listOf()) }
    LaunchedEffect(Unit) {
        favs = api.getFavs()
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(
            horizontal = 20.dp,
            vertical = 16.dp
        ),
    ) {
        itemsIndexed(favs) { _, item ->
            ProductCard(
                item,
                onClick = {
                    NavigationManager.navigateToProduct(item)
                },
                api = api
            )
        }
    }
}