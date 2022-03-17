package com.zy.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forceOffline.setOnClickListener{
            val intent = Intent("com.example.broadcasttext.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
        button.setOnClickListener{
            val intent = Intent("com.example.broadcasttext.MY_BROADCAST")
            intent.setPackage(packageName)
            intent.putExtra("nmsl","?????")
//            sendBroadcast(intent)
            //发送有序广播
            sendOrderedBroadcast(intent,null)
        }
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver,intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context,"时间走动了",Toast.LENGTH_SHORT).show()
        }
    }
}