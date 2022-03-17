package com.zy.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.zy.broadcasttest.ui.login.LoginActivity

open class BaseActivity:AppCompatActivity() {

    lateinit var receiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.broadcasttext.FORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver,intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class ForceOfflineReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            AlertDialog.Builder(context).apply {
                setTitle("警告")
                setMessage("你被强制下线了")
                setCancelable(false)
                setPositiveButton("明白"){ _,_ ->
                    ActivityCollector.finishAll()//销毁所有activity
                    val i = Intent(context,LoginActivity::class.java)
                    context.startActivity(i)
                }
                show()
            }
        }
    }
}