package com.zy.servicetest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class MyService : Service() {

    private val mBinder = DownloadBinder();

    class DownloadBinder:Binder(){
        fun startDownload(){
            Log.d("zyzyzy","开始下载任务")
        }

        fun getProgress():Int{
            Log.d("zyzyzy","获取下载进度")
            return 0
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    /**
     * 在Service创建的时候调用
     */
    override fun onCreate() {
        super.onCreate()
        Log.d("zyzyzy", "服务创建")
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel = NotificationChannel("my_service","前台service通知",NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val intent = Intent(this,MainActivity::class.java)
        val pi = PendingIntent.getActivity(this,0,intent,0)
        val notification = NotificationCompat.Builder(this,"my_service")
            .setContentTitle("傻吊标题")
            .setContentText("傻吊内容")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.ic_launcher_background))
            .setContentIntent(pi)
            .build()
        startForeground(1,notification)
    }


    /**
     * 在每次Service启动的时候调用
     */
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        thread {
            //搞一些耗时操作在里面
            stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    /**
     * 在Service销毁的时候调用
     */
    override fun onDestroy() {
        super.onDestroy()
    }
}