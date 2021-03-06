package com.zy.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val data = intent.getStringExtra("nmsl")
        Toast.makeText(context,"MyBroadcastReceiver" +data ,Toast.LENGTH_SHORT).show()
        //拦截广播
        abortBroadcast()
    }
}