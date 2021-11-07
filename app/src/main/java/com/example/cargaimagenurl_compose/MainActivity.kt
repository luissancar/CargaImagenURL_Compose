package com.example.cargaimagenurl_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cargaimagenurl_compose.ui.theme.CargaImagenURL_ComposeTheme
import com.google.android.material.shape.Shapeable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CargaImagenURL_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Red) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    LazyColumn (modifier = Modifier.background(Color.Blue)
        ) {
        items(20) {
            Box  {
                CargarImagen(url = "https://www.google.es/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png")
            }
    }
  }

}

@Composable
fun CargarImagen(url: String){
    val image = LoadPicture(
        url = url,
        defaultImage = DEFAULT_RECIPE_IMAGE
    ).value
    image?.let { img ->
        Image(
            bitmap = img.asImageBitmap(),
            contentDescription = "Localized description",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.Cyan)



        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CargaImagenURL_ComposeTheme {
        Greeting("Android")
    }
}