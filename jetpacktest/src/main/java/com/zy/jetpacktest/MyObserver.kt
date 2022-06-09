package com.zy.jetpacktest

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver(val lifecycle: Lifecycle) : LifecycleObserver {


    //Lifecycle.Event.ON_START对应activity生命周期
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart(){
        Log.d("zyzyzy", "activityStart: ")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop(){
        Log.d("zyzyzy", "activityStop: ")
    }

    fun getActivityLifecycle(): Lifecycle.State {
        return lifecycle.currentState
    }
}