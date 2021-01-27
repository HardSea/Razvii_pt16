package com.pmacademy.razvii_pt16

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pmacademy.razvii_pt16.databinding.ActivityBitmapBinding
import java.io.ByteArrayOutputStream


class BitmapActivity : AppCompatActivity() {


    private lateinit var bindings: ActivityBitmapBinding
    private lateinit var bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap)

        bindings = ActivityBitmapBinding.inflate(layoutInflater)
        setContentView(bindings.root)
        //disableEditText()

        createBitmap()
        setupListeners()

    }

    private fun createBitmap() {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.attention)
            .copy(Bitmap.Config.ARGB_8888, true)


    }

    private fun setupListeners() {
        bindings.btnDrawOnBitmap.setOnClickListener {
            drawOnBitmap()
        }
        bindings.btnGetByteArray.setOnClickListener {
            createByteArray()
        }
    }

    private fun createByteArray() {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val byteArray = stream.toByteArray()

        bindings.etByteArray.setText(getString(R.string.string_from_byte_array, byteArray))

    }

    private fun drawOnBitmap() {
        val canvas = Canvas(bitmap)

        val paint = Paint().apply {
            isAntiAlias = true
            strokeWidth = 100f
            color = Color.BLACK
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
        }

        canvas.drawLine(
            0f,
            0f,
            canvas.width.toFloat(),
            canvas.height.toFloat(),
            paint
        )

        canvas.drawLine(
            canvas.width.toFloat(),
            0f,
            0f,
            canvas.height.toFloat(),
            paint
        )

        bindings.ivAttention.setImageBitmap(bitmap)


    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, BitmapActivity::class.java)
            context.startActivity(intent)

        }
    }
}