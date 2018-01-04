package com.sapuglha.espressotips

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val bundle = intent?.extras
        bundle?.let {
            val param = bundle.get("name") as String
            hello_activity_text_name.text = param
        }
    }
}