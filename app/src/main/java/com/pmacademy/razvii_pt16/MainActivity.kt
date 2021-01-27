package com.pmacademy.razvii_pt16

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.pmacademy.razvii_pt16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindings: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setupListeners()
    }

    private fun setupListeners() {
        bindings.btnStartDrawableActivity.setOnClickListener {
            DrawableActivity.start(this)
        }

        bindings.btnStartBitmapActivity.setOnClickListener {
            BitmapActivity.start(this)
        }

        bindings.btnStartGlideActivity.setOnClickListener {
            GlideActivity.start(this)
        }
    }
}