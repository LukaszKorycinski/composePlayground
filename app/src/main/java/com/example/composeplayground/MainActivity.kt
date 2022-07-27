package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeplayground.details.Item

import com.example.composeplayground.constraint.ConstraintScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme

                val navController = rememberNavController()

                NavHost(navController, startDestination = "list") {
                    composable("list") {
                        ShowListBebe(navController)
                    }
                    composable("pager") {
                        ConstraintScreen(navController)
                    }
                    composable("details/{itemId}", arguments = listOf( navArgument("itemId")
                    {type = NavType.IntType} )) { backStackEntry ->
                        DetailScreen(backStackEntry.arguments?.getInt("itemId"), navController = navController)
                    }
                }
            }
        }
    }
}


@Composable
fun ShowListBebe(navController: NavHostController? = null) {
    Surface(color = MaterialTheme.colors.background) {
        val list: ArrayList<Item> = ArrayList<Item>()

        for (i in 0..20) {
            list.add(
                Item(
                    id = i,
                    imageRes = R.drawable.ic_launcher_background,
                    name = "numer " + i
                )
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(items = list) { item ->
                ItemCard(
                    item = item,
                    onClick = {navController?.navigate("details/"+item.id)}
                )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        ShowListBebe()
    }
}

