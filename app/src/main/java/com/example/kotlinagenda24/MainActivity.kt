package com.example.kotlinagenda24
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var redirectRegistrar: Button
    var txtCorreoLG: EditText?= null
    var txtPassLG:EditText?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redirectRegistrar=findViewById(R.id.btnRedirectRegistrar)

        redirectRegistrar.setOnClickListener {
            val intent = Intent(this, Registrar::class.java)
            startActivity(intent)
        }

    }
}