package com.pmacademy.razvii_pt16

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pmacademy.razvii_pt16.databinding.ActivityGlideBinding

class GlideActivity : AppCompatActivity() {

    private lateinit var bindings: ActivityGlideBinding

    private val imageUrl1 = "https://i.gifer.com/origin/ef/ef4ef240ddaec1deded5063387a24ccb.gif"
    private val imageUrl2 = "https://media.giphy.com/media/2rACpk998nuSygEU52/giphy.gif"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityGlideBinding.inflate(layoutInflater)
        setContentView(bindings.root)
        setupListeners()
    }

    private fun setupListeners() {
        bindings.btnDownloadGlide.setOnClickListener {
            downloadImage()
        }
        bindings.btnDownloadGlideCrop.setOnClickListener {
            downloadCropImage()
        }
    }

    private fun downloadCropImage() {
        Glide.with(this)
            .load(imageUrl2)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.broke_img)
            )
            .circleCrop()
            .into(bindings.ivImage)
    }

    private fun downloadImage() {
        Glide.with(this)
            .load(imageUrl1)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.broke_img)
            )
            //.transition(DrawableTransitionOptions.withCrossFade(1000))
            .into(bindings.ivImage)
    }


    companion object {
        fun start(context: Context) {
            val intent = Intent(context, GlideActivity::class.java)
            context.startActivity(intent)
        }
    }
}