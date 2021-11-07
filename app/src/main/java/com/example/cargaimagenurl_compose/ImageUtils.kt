package com.example.cargaimagenurl_compose

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition


const val DEFAULT_RECIPE_IMAGE = R.drawable.ic_launcher_background


@Composable
fun LoadPicture(
    url:String,
    @DrawableRes defaultImage: Int):
        MutableState<Bitmap?> {
    val bitmapState:MutableState<Bitmap?> = mutableStateOf(null)
    val context = LocalContext.current
    Glide.with(context)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value=resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }

        })
    return bitmapState
}


