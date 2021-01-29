package com.example.poke_desc.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.poke_desc.R

@BindingAdapter("imageUrl")
fun setImageUrl(imgView: ImageView, imgUrl: String?){

    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .placeholder(R.drawable.ic_baseline_insert_photo_24)
            .into(imgView)
    }
}