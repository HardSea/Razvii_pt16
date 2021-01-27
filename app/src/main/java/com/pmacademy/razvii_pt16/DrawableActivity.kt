package com.pmacademy.razvii_pt16

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DrawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable)

    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, DrawableActivity::class.java)
            context.startActivity(intent)
        }
    }
}