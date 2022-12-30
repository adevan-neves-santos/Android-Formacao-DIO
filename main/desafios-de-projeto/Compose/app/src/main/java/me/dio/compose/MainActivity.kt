package me.dio.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.dio.compose.ui.theme.ComposeTheme
import me.dio.compose.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier.background(Color.Red)) {
        //Tipografia do android
        Text(text = "Meu primero Texto com Compose",
            maxLines = 3,
            style = Typography.h5,
            modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
        )
        //Tipografia do Material
        Text(text = "Meu primero Texto com Compose",
            maxLines = 2,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.background(Color.Gray))
        //Default
        Text(text = "Outro texto qualquer")

        Row() {
            Text(text = "Text 3", modifier = Modifier.padding(end = 30.dp))
            Text(text = "Text 4")
        }

    }



    /*
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)) {
        Icon(painter = painterResource(id = R.drawable.ic_star) ,
            contentDescription = null
            , tint = Color.White)
        Text(text = "Confirmar", color = Color.White)
    }*/
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

