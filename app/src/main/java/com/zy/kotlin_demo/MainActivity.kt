package com.zy.kotlin_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 参照第一行代码（3版）
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //隐藏自带标题栏
        supportActionBar?.hide()
        //3.2.4  在APP/build.gridle里添加kotlin-android-extensions插件 可以避免使用findviewByID
        //这个是根据之前语法简化后的写法
//        btn.setOnClickListener {
//            Toast.makeText(this, "??", Toast.LENGTH_SHORT).show()
//        }
        btn.setOnClickListener(this)
        //直接调用java实体中的参数并赋值kotlin会自动调用get set方法
        val book = Book()
        book.page = 500
        val bookPages = book.page

    }

    //添加菜单资源以及指定加入哪个对象
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "加", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "减", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn -> {
                /**
                 * 加了插件可以直接调用xml里定义好的控件
                proressbar.progress = proressbar.progress+10
                 */
                AlertDialog.Builder(this).apply {
                    setTitle("标题")
                    setMessage("内容")
                    setCancelable(false)
                    setPositiveButton("好") {
                            dialog, whick ->
                    }
                    setNegativeButton("取消"){
                        //这是什么我其实不太懂
                        dialog,which->
                    }
                    show()
                }
            }
        }
    }


}