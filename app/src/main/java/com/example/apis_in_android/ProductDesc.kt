package com.example.apis_in_android

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi

class ProductDesc : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_desc)

        val productData = intent.getParcelableExtra<Product>("data")
        val title = findViewById<TextView>(R.id.productTitle)
        if (productData != null) {
            title.text = productData.title
        }

    }
}