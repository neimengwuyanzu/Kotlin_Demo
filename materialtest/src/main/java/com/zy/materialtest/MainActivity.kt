package com.zy.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val fruits = mutableListOf(
        Fruit("苹果", R.mipmap.setting),
        Fruit("橘子", R.mipmap.setting),
        Fruit("梨", R.mipmap.setting),
        Fruit("他妈的不认识", R.mipmap.setting),
        Fruit("樱桃", R.mipmap.setting),
        Fruit("芒果", R.mipmap.setting)
    )

    val fruitList = ArrayList<Fruit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.mipmap.delete)
        }
        navView.setCheckedItem(R.id.navcall)
        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            when (it.itemId) {
                R.id.navcall -> Toast.makeText(this, "电话", Toast.LENGTH_SHORT).show()
                R.id.navFriends -> Toast.makeText(this, "联系人", Toast.LENGTH_SHORT).show()
                R.id.navLocation -> Toast.makeText(this, "位置", Toast.LENGTH_SHORT).show()
                R.id.navMail -> Toast.makeText(this, "邮件", Toast.LENGTH_SHORT).show()
                R.id.navTask -> Toast.makeText(this, "任务", Toast.LENGTH_SHORT).show()
            }
            true
        }
        fab.setOnClickListener { view ->
//            Toast.makeText(this, "一个悬浮按钮", Toast.LENGTH_SHORT).show()
            Snackbar.make(view, "数据删除", Snackbar.LENGTH_SHORT)
                .setAction("撤回") {
                    Toast.makeText(this, "操作未执行", Toast.LENGTH_SHORT).show()
                }.show()
        }

        initFruits()
        val layoutManager = GridLayoutManager(this,2)
        recyclerview.layoutManager = layoutManager
        val adapter = FruitAdapter(this,fruitList)
        recyclerview.adapter = adapter
    }

    private fun initFruits() {
        fruitList.clear()
        repeat(50){
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
            R.id.backup -> Toast.makeText(this, "返回", Toast.LENGTH_SHORT).show()
            R.id.delete -> Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show()
            R.id.setting -> Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}