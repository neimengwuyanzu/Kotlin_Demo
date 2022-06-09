package com.zy.jetpacktest

import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved:Int):ViewModel() {
//    var counter = MutableLiveData<Int>()

    private val userLiveData = MutableLiveData<User>()

    private val userIdLiveData = MutableLiveData<String>()

    val userName:LiveData<String> = Transformations.map(userLiveData){user ->
        "${user.firstName} ${user.lastName}"
    }

    val user:LiveData<User> = Transformations.switchMap(userIdLiveData){userid ->
        Repository.getUser(userid)
    }

    val counter:LiveData<Int>
        get() = _counter

    private val _counter = MutableLiveData<Int>()
    init {
//        counter.value = countReserved
        _counter.value = countReserved
    }

    fun plusOne(){
//        val count = counter.value ?:0//如果为null 就设置为0
//        counter.value = count+1
        val count = _counter.value ?:0//如果为null 就设置为0
        _counter.value = count+1
    }

    fun clear(){
//        counter.value = 0
        _counter.value = 0
    }

    fun getUser(userid:String){
//        return Repository.getUser(userid)
        userIdLiveData.value = userid
    }
}