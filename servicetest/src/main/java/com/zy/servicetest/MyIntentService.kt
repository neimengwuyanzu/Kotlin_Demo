package com.zy.servicetest

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService:IntentService("MyIntentService") {
    override fun onHandleIntent(p0: Intent?) {
        //打印当前线程ID
        Log.d("zyzyzy", "线程名：${Thread.currentThread().name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("zyzyzy", "onDestroy: ")
    }
}