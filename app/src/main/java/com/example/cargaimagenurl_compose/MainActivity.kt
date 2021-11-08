package com.example.cargaimagenurl_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.cargaimagenurl_compose.ui.theme.CargaImagenURL_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CargaImagenURL_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Red) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    LazyColumn(
        modifier = Modifier.background(Color.Blue)
    ) {
        items(listaUrl()) { url ->
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                CargarImagen(url = url)
            }
        }
    }

}

fun listaUrl(): Array<String> {
    var lista = arrayOf<String>(
        "https://www.google.es/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png",
        "https://csharpcorner-mindcrackerinc.netdna-ssl.com/article/kotlin-array-and-string2/Images/array.jpeg",
        "https://ep00.epimg.net/elpais/imagenes/2019/10/30/album/1572424649_614672_1572451730_album_normal.jpg",
        "https://ep00.epimg.net/elpais/imagenes/2019/10/30/album/1572424649_614672_1572451731_album_normal.jpg",
        "https://tpc.googlesyndication.com/simgad/16668890106592808305",
        "https://ep00.epimg.net/elpais/imagenes/2019/10/30/album/1572424649_614672_1572451728_album_normal.jpg",
        "https://ep00.epimg.net/elpais/imagenes/2019/10/30/album/1572424649_614672_1572452578_album_normal.jpg",
        "https://ep00.epimg.net/elpais/imagenes/2019/10/30/album/1572424649_614672_1572452580_album_normal.jpg",
        "https://ep00.epimg.net/elpais/imagenes/2019/10/30/album/1572424649_614672_1572451729_album_normal.jpg",
        "https://ep00.epimg.net/elpais/imagenes/2019/10/30/album/1572424649_614672_1572451736_album_normal.jpg"


    )
    return lista
}


@Composable
fun CargarImagen(url: String) {
    Image(
        painter = rememberImagePainter(url),
        contentDescription = "Imagen",
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(100.dp)),
        contentScale = ContentScale.FillWidth


    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CargaImagenURL_ComposeTheme {
        Greeting()
    }
}
