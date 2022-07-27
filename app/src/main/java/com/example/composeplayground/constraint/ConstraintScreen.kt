package com.example.composeplayground.constraint

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

import androidx.navigation.NavHostController
import com.example.composeplayground.R
import com.example.composeplayground.ShowListBebe
import com.example.composeplayground.details.Item
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme


@Composable
fun ConstraintScreen(navController: NavHostController? = null) {

        ConstraintLayout(modifier = Modifier.fillMaxSize().background(color = Color.Black)){

            val (button, text) = createRefs()

            val context = LocalContext.current

            Button(
                modifier = Modifier.constrainAs(button){
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
                onClick = { Toast.makeText(context, "tost111", Toast.LENGTH_SHORT).show() }
            ){
                Text("Button")
            }

            Text(
                modifier = Modifier.constrainAs(text){
                    bottom.linkTo(parent.bottom)
                    top.linkTo(button.bottom)
                },
                text = "text 2",
                color = Color.White
            )

        }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        ConstraintScreen()
    }
}