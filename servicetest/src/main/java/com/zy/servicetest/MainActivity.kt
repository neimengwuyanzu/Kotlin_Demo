package com.zy.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var downloadBinder :MyService.DownloadBinder
    private val connection = object :ServiceConnection{
        /**
         * 方法会在Activity与Service成功绑定的时候调用
         */
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        /**
         * 在Service的创建进程崩溃或者被杀掉的时候才会调用
         */
        override fun onServiceDisconnected(name: ComponentName?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            startService(intent)
        }
        stopServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            stopService(intent)
        }
        bindServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            bindService(intent,connection,Context.BIND_AUTO_CREATE)//BIND_AUTO_CREATE表示在Activity和Service进行绑定后自动创建Service
        }
        unbindServiceBtn.setOnClickListener {
            unbindService(connection)
        }
        startIntentServiceBtn.setOnClickListener {
            Log.d("zyzyzy", "线程名：${Thread.currentThread().name}")
            val intent = Intent(this,MyIntentService::class.java)
            startService(intent)
        }

        val result1 = getGenericType<String>()
        val result2 = getGenericType<Int>()
        Log.d("zyzyzy", "数据1的类型：$result1")
        Log.d("zyzyzy", "数据2的类型：$result2")
    }

    inline fun <reified T> getGenericType() = T::class.java


}