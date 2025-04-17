package view.categoryScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import model.api.ApiConnector
import model.classes.CategoryClass
import model.classes.ProductClass
import theme.background
import view.NavigationManager
import view.mainScren.CategoryCard
import view.mainScren.SearchBar

val category = CategoryClass(
    catId = 3,
    name = "Тест",
    backColor = background,
    borderColor = background,
    image = ""
)

@Composable
fun CategoryScreen(
    api: ApiConnector,
    category: CategoryClass,
) {
    var products by remember { mutableStateOf<List<ProductClass>>(emptyList()) }

    LaunchedEffect(Unit) {
        products = api.fetchProducts(category.catId)
    }

    var searchValue by remember { mutableStateOf("") }
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
    ){
        CategoryControls(
            category = category
        )
        Spacer(modifier = Modifier.height(30.dp))
        SearchBar(
            value = searchValue,
            onValueChange = { searchValue = it },
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            contentPadding = PaddingValues(
                horizontal = 20.dp,
                vertical = 16.dp
            ),
        ) {
            items(products.size) { index ->
                val prod = products[index]
                ProductCard(
                    product = prod,
                    onClick = {
                        NavigationManager.navigateToProduct(prod)
                        println(prod)
                    },
                )
            }
        }
    }
}