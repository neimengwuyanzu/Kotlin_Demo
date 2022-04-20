package com.zy.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.contentValuesOf
import cvOf
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = MyDatabaseHelper(this,"BookStore.db",2)
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase//如果有这个数据库 就打开  没有就创建
        }
        //增
        addData.setOnClickListener {
            val db = dbHelper.writableDatabase
//            val valuse1 = ContentValues().apply {
//                //组装第一条数据
//                put("name","书本11111")
//                put("author","作者111")
//                put("pages","123")
//                put("price",16.99)
//            }
//            db.insert("Book",null,valuse1)
//            val valuse2 = ContentValues().apply {
//                //组装第一条数据
//                put("name","书本22222")
//                put("author","作者222")
//                put("pages","456")
//                put("price",18.99)
//            }
//            db.insert("Book",null,valuse2)

//            val values = cvOf("name" to "大唐兴亡三百年","author" to "不清楚" , "pages" to 999 , "price" to 39.9)
            val values = contentValuesOf("name" to "大唐兴亡三百年","author" to "不清楚" , "pages" to 999 , "price" to 39.9)
            db.insert("Book",null,values)
        }
        //改
        updateData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price",9.9)
            db.update("Book",values,"name = ?", arrayOf("书本22222"))
        }
        //删
        deleteData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Book","pages > ?", arrayOf("200"))
        }
        //查
        queryData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val cursor = db.query("Book",null,null,null,null,null,null)
            if (cursor.moveToFirst()){
                do {
                    //遍历Cursor对象，取出数据打印
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getString(cursor.getColumnIndex("pages"))
                    val price = cursor.getString(cursor.getColumnIndex("price"))
                    Toast.makeText(this,"书名： $name" + "\n" + "作者： $author" + "\n" + "页数： $pages" + "\n" + "价格： $price",Toast.LENGTH_SHORT).show()
                }while (cursor.moveToNext())
            }
            cursor.close()
        }

        //事物操作
        replaceData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.beginTransaction()//开启事务
            try {
                db.delete("Book",null,null)
                if (true){
                    //手动抛出一个异常
                    throw NullPointerException()
                }
                val values = ContentValues().apply {
                    put("name","大唐兴亡三百年")
                    put("作者","忘求了")
                    put("pages",999)
                    put("price",30)
                }
                db.insert("Book",null,values)
                db.setTransactionSuccessful()//事务执行成功
            }catch (e:Exception){
                e.printStackTrace()
            }finally {
                db.endTransaction() //结束事务
            }
        }
    }
}