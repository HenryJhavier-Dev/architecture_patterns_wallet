package com.henryjhavierdev.architecturepatternswallet.helpers

import android.widget.ImageView
import com.squareup.picasso.Picasso


fun ImageView.loadImageViewFromUrl(url: String?) = Picasso.get()
    .load(url).into(this)
