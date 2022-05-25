package com.example.averquesale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagen1 = findViewById<ImageView>(R.id.imageView)
        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Manchot_01.jpg/640px-Manchot_01.jpg").into(imagen1)
        val imagen2 = findViewById<ImageView>(R.id.imageView2)
        Glide.with(this).load(R.drawable.pingu).into(imagen2)
 var button1 = findViewById<Button>(R.id.button)

        button1.setOnClickListener{

            startActivity(Intent(this,MainActivity2::class.java))


        }





    }
}