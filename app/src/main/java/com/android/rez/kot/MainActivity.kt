package com.android.rez.kot
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity():AppCompatActivity(){


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
 //region Values
        val btnToast: Button = findViewById(R.id.btnToast)
        val message = "این یک پیام تست است!"
        val btnSnack: Button = findViewById(R.id.btnSnack)
        val btnAlert: Button = findViewById(R.id.btnAlert)
        val btnBack: Button = findViewById(R.id.btnBack)
        val btnNotif: Button = findViewById(R.id.btnNotif)
        val btnCustom: Button = findViewById(R.id.btnCustom)
        var fredMsg= FredMsg()



//endregion
//region listeners
            btnToast.setOnClickListener {
               fredMsg.toast(this, message)
            }
            btnSnack.setOnClickListener{
                val builder = AlertDialog.Builder(this)
                    .setTitle("عنوان")
                    .setMessage(message)
                    .setPositiveButton("باشه") { _, _ ->

                            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("انصراف") { _, _ ->

                            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                    }
                builder.create().show()
            }
            btnNotif.setOnClickListener {
               fredMsg.notif(this, message)
            }
            btnBack.setOnClickListener {


                val intent = Intent(applicationContext, MainMenu::class.java)
                startActivity(intent)
                finish()
            }
            btnAlert.setOnClickListener {
            fredMsg.alert(this, message)
                /*    val builder = AlertDialog.Builder(this)
                    .setTitle("عنوان")
                    .setMessage(message)
                builder.create().show()
            */
            }


       /*     btnCustom.setOnClickListener {

                fredMsg.toast2(this, message)
             }
*/
    //endregion


    }


    }









