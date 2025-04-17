package view.mainScren

import model.classes.CategoryClass
import androidx.compose.desktop.ui.tooling.preview.Preview
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.api.ApiConnector
import theme.*
import view.NavigationManager


@Composable
fun MainScreen() {
    val api = ApiConnector()
    var categories by remember { mutableStateOf<List<CategoryClass>>(emptyList()) }

    LaunchedEffect(Unit) {
        categories = api.fetchCategories()
    }

    var searchBarValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = background)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource("images/Carrot.svg"),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    start = 40.dp,
                )
        )
        Text(
            text = "Копеечка",
            style = TextStyle(
                color = textColor,
                fontSize = 18.sp,
            )
        )
        SearchBar(
            value = searchBarValue,
            onValueChange = {
                searchBarValue = it
            }
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 16.dp
            ),
        ) {
            items(categories.size) { index ->
                val category = categories[index]
                CategoryCard(
                    category = category,
                    onClick = {NavigationManager.navigateToCategory(index)}
                )
            }
        }


    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}