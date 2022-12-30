package me.dio.compose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.dio.compose2.ui.theme.Compose2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    MainScreenPreview()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    /*Column {
        DogCard(dog = Dog(name = "Luna","Chow Chow"), modifier = Modifier.background(Color.Green))
        DogCard(dog = Dog(name = "Zoey","Pit Bull"), modifier = Modifier.background(Color.Blue))
    }*/
    var clicks by remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize()) {
        ClickCounter(clicks = clicks) {
            clicks++
        }
        HelloContent()
    }
}

@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("I've been clicked $clicks times")
    }
}

data class Dog(
    val name: String, val breed: String
)

@Composable
fun DogCard(dog: Dog, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = modifier
                .size(72.dp)
                .clip(CircleShape)
        )
        Column {
            Text(text = dog.name)
            Text(text = dog.breed)
        }
    }
}
@Composable
fun HelloContent(){
    Column (modifier = Modifier.padding(16.dp)) {
        var name by remember { mutableStateOf("")}
        if(name.isNotEmpty()){
            Text(text = "Hello, $name!",
                modifier = Modifier,
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text("Name")}
        )
    }
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

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose2Theme {
        Greeting("Android")
    }
}