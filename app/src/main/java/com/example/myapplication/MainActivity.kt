package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}

@Preview
@Composable
fun App() {
    var counter by rememberSaveable { mutableIntStateOf (value = 0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = colorResource(id = R.color.mi_color_de_fondo),
            )
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 28.dp, bottom = 28.dp)
                    .heightIn(max = 800.dp),

                painter = painterResource
                    (id = R.drawable.img),
                contentScale = ContentScale.Fit,
                contentDescription = "background de plantas"
            )
            Text(
                text = "Welcome to Plants", fontSize = 32.sp,
                color = colorResource
                    (id = R.color.color_destacado),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Row (modifier = Modifier.padding(start = 12.dp)) {
                Image(
                    painter = painterResource(id = android.R.drawable.btn_star_big_on),
                    contentDescription = "nature Icon",
                    modifier = Modifier.clickable {counter++}
                )
                Text (
                    text = counter.toString() ,
                     color = colorResource
                        (id = R.color.color_destacado)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "The plants", fontSize = 18.sp)
                Text(text = "ARE AMAZING", fontSize = 18.sp)
            }

        }
    }
}