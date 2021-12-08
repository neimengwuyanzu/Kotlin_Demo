package com.zy.kotlin_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 参照第一行代码（3版）
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    val fruitList = ArrayList<String>();
//    private  var adapter : FruitAdapter? = null
    private lateinit var adapter : FruitAdapter//延迟初始化 否则需要先给一个null
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

        initFruitData()

        val layoutManager = LinearLayoutManager(this)
        rv.layoutManager = layoutManager
        //保险的写法 判断是否已经完成初始化 避免重复初始化操作
        if (!::adapter.isInitialized){
            adapter = FruitAdapter(fruitList)
        }
        rv.adapter = adapter
    }

    /**
     * 在when语句中传入一个密封类 kotlin会检查该类有哪些自雷并强制要求将每一个自雷处理
     * 即使没写else也不会出现漏写情况
     */
    fun getResultMsg(result: Result) = when(result) {
        is Sucess -> result.msg
        is Failure -> result.error.message
//        else -> throw IllegalArgumentException()//密封过后就不需要else了
    }

    private fun initFruitData() {
        fruitList.add("苹果")
        fruitList.add("香蕉")
        fruitList.add("橘子")
        fruitList.add("车厘子")
        fruitList.add("西瓜")
        fruitList.add("梨")
        fruitList.add("还尼玛得写多少能写满一页")
        fruitList.add("苹果")
        fruitList.add("香蕉")
        fruitList.add("橘子")
        fruitList.add("车厘子")
        fruitList.add("西瓜")
        fruitList.add("梨")
        fruitList.add("还尼玛得写多少能写满一页")
        fruitList.add("苹果")
        fruitList.add("香蕉")
        fruitList.add("橘子")
        fruitList.add("车厘子")
        fruitList.add("西瓜")
        fruitList.add("梨")
        fruitList.add("还尼玛得写多少能写满一页")
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