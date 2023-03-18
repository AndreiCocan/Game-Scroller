package com.insa.gamelist.extentions

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.insa.gamelist.R

fun ImageView.load(url : String){

    val uri = url.toUri().buildUpon().scheme("https").build()
    Glide.with(context).load(uri).into(this)
}

// TODO : here implement the loadConsoleLogo function