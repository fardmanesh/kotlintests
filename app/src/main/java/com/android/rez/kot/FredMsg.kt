package com.android.rez.kot

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat


class FredMsg(): AppCompatActivity() {


   public fun toast (context: Context,msg: String) {
        Toast.makeText(context, msg ,Toast.LENGTH_SHORT).show()
    }
   public fun alert (context: Context,msg: String) {
       val builder: AlertDialog.Builder = AlertDialog.Builder(context)
       builder.setTitle("Alert")
        builder.setMessage(msg)
        builder.setIcon(R.drawable.colorowl)
        builder.show()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun notif (context: Context, msg: String) {
        val channelId = "my_channel_id"
        val channelName = "My Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, channelName, importance)
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
        val notificationId = 1
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("سربرگ نوتیفیکیشن")
            .setContentText("توضیحات نوتیفیکیشن  \n توضیحات بیشتر")
            .setSmallIcon(R.drawable.logo_msg)
            .setColor(getColor(R.color.purple))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
        notificationManager.notify(notificationId, notification)

    }
}



