package com.android.rez.kot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       val msgExit ="آیااز خروج اطمینان دارید؟"
        val btnMsg: Button = findViewById(R.id.btnMsg)

        btnMsg.setOnClickListener {
           val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
        val  btnClose : Button = findViewById(R.id.btnClose)
        btnClose.setOnClickListener {
            val builder = AlertDialog.Builder(this)
                .setTitle("خروج")
                .setMessage(msgExit)
                .setPositiveButton("بله") { _, _ ->

                  finish()
                }
                .setNegativeButton("انصراف") { _, _ ->

                    Toast.makeText(applicationContext, "خداروشکر", Toast.LENGTH_SHORT).show()
                }
            builder.create().show()
        }
    }
}