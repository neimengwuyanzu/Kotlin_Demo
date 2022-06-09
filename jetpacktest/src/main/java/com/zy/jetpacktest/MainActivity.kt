package com.zy.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:MainViewModel
    lateinit var sp:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved",0)
        viewModel = ViewModelProvider(this,MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
        plusOneBtn.setOnClickListener {
//            viewModel.counter++
//            refreshCounter()
            viewModel.plusOne()
        }
        clearBtn.setOnClickListener {
//            viewModel.counter = 0
//            refreshCounter()
            viewModel.clear()
        }
//        refreshCounter()
//        lifecycle.addObserver(MyObserver())
//        viewModel.counter.observe(this, Observer { count ->
//            infoText.text = count.toString()
//        })
        viewModel.counter.observe(this){count ->
            infoText.text = count.toString()
        }
//        viewModel.userName.observe(this){ user ->
//            Log.d("zyzyzy", "获取到的用户 $user")
//        }

        getUserBtn.setOnClickListener {
            val userId = (0..10000).random().toString()
            viewModel.getUser(userId)
        }
        viewModel.user.observe(this, Observer { user ->
            infoText.text = user.firstName
        })

    }

    private fun refreshCounter() {
        infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved",viewModel.counter.value ?:0)
        }
    }

}