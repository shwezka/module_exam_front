package view.mainScren

import model.classes.CategoryClass
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.textCardColor
import theme.textFieldBackground

@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = textFieldBackground,
                shape = RoundedCornerShape(20.dp)
            ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                modifier = Modifier,
                contentDescription = null
            )
        },
        placeholder = {
            Text(
                text = "Поиск по магазину...",
                fontSize = 15.sp,
            )
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 10.sp,
        ),
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Cyan,
            unfocusedBorderColor = Color.Gray,

        ),
        singleLine = true,
    )
}

@Composable
fun CategoryCard(
    category: CategoryClass,
    onClick: () -> Unit,
){
    Card(
        modifier = Modifier
            .height(350.dp)
            .width(200.dp)
            .clickable{
                onClick()
            }
            .padding(10.dp),
        backgroundColor = category.backColor,
        border = BorderStroke(
            width = 1.dp,
            color = category.borderColor,
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(category.image),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = category.name,
                modifier = Modifier
                    .width(100.dp),
                color = textCardColor,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                )
        }
    }
}