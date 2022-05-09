package com.zy.notificationtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("normal","Normal",NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        sendNotice.setOnClickListener {
            val intent = Intent(this,NotificationActivity::class.java)
            val pi = PendingIntent.getActivity(this,0,intent,0)
            val notification = NotificationCompat.Builder(this,"normal")
                .setContentTitle("弱智标题")
//                .setContentText("弱智内容")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.ic_launcher_foreground))
                .setContentIntent(pi)
                .setStyle(NotificationCompat.BigTextStyle().bigText("测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字测试大段文字"))
                .build()
            manager.notify(1,notification)
        }
    }
}