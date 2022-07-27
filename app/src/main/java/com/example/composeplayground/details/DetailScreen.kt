package com.example.composeplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.details.DetailsViewModel
import com.example.composeplayground.details.DetailsViewModelFactory
import com.example.composeplayground.details.Item

@Composable
fun DetailScreen(itemId: Int?, model: DetailsViewModel = viewModel(factory = DetailsViewModelFactory(itemId ?: 0)), navController: NavHostController? = null) {
    val item by model.item.collectAsState()

    ItemCard(item = item, modifier = Modifier.fillMaxWidth()
        .fillMaxHeight()
        .wrapContentSize(Alignment.Center),
    onClick = {navController?.navigate("pager")})


}



@Composable
fun ItemCard(item: Item, modifier: Modifier = Modifier, onClick: () -> Unit) {
    val fontFamily = FontFamily(
        Font(
            resId = R.font.flamepl_regular,
            weight = FontWeight.W400,
            style = FontStyle.Normal
        )
    )

    //var wasClicked by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .background(color = Color.LightGray)
            .padding(20.dp)

            .background(color = colorResource(R.color.pojebany))
            .border(4.dp, colorResource(R.color.transparent))
            .clickable {
                //wasClicked = !wasClicked
                onClick()
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item.imageRes?.let {
            Image(painterResource(it), "content description")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = item.name,
            style = TextStyle(fontFamily = fontFamily),
            color = /*if(wasClicked)Color.Red else */Color.Green,
            fontSize = 25.sp
        )
    }
}