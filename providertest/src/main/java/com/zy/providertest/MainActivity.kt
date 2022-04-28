package com.zy.providertest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    var bookId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addData.setOnClickListener {
            //添加数据
            val uri = Uri.parse("content://com.zy.databasetest.provider/book")
            val values = contentValuesOf(
                "name" to "搞事书一",
                "author" to "热心市民小张",
                "pages" to 1024,
                "price" to 39.99
            )
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
        }
        queryData.setOnClickListener {
            //查询数据
            val uri = Uri.parse("content://com.zy.databasetest.provider/book")
            contentResolver.query(uri, null, null, null, null)?.apply {
                while (moveToNext()) {
                    val name = getString(getColumnIndex("name"))
                    val author = getString(getColumnIndex("author"))
                    val pages = getString(getColumnIndex("pages"))
                    val price = getString(getColumnIndex("price"))
                    Log.d("zyzyzy", "书名：$name\n作者：$author\n页数：$pages\n价格：$price")
                }
                close()
            }
        }
        updateData.setOnClickListener {
            //更新数据
            bookId?.let {
                val uri = Uri.parse("content://com.zy.databasetest.provider/book/$it")
                val values = contentValuesOf(
                    "name" to "更新书名2222",
                    "pages" to 999,
                    "price" to 9.9
                )
                contentResolver.update(uri,values,null,null)
            }
        }
        deleteData.setOnClickListener {
            //删除数据
            bookId?.let {
                val uri = Uri.parse("content://com.zy.databasetest.provider/book/$it")
                contentResolver.delete(uri,null,null)
            }
        }

    }
}