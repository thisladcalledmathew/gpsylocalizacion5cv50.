package com.example.gpsylocalizacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gpsylocalizacion.ui.theme.GpsylocalizacionTheme
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GpsylocalizacionTheme {
                // A surface container using the 'background' color from the theme
                setContentView(R.layout.activity_main)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",

        modifier = modifier



    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GpsylocalizacionTheme {
        Greeting("Android")
    }
}