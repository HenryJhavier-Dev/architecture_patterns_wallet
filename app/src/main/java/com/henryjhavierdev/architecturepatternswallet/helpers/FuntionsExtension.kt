package com.henryjhavierdev.architecturepatternswallet.helpers

import android.widget.ImageView
import com.squareup.picasso.Picasso

class FuntionsExtension {
}

fun ImageView.loadImageViewFromUrl(url: String) = Picasso.get()
    .load(url).into(this)
