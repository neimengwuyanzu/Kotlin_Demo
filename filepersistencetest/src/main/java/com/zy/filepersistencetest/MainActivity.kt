package com.zy.filepersistencetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val inputText = load()
//        if (inputText.isNotEmpty()){
//            edittext.setText(inputText)
//            edittext.setSelection(inputText.length)
//            Toast.makeText(this,"读取成功",Toast.LENGTH_SHORT).show()
//        }
        save_btn.setOnClickListener{
//            val editor = getSharedPreferences("data",0).edit()
//            editor.putString("name","nmsl")
//            editor.putInt("age",11)
//            editor.putBoolean("married",false)
//            editor.apply()
            getSharedPreferences("data",Context.MODE_PRIVATE).edit {
                putString("name","nmsl")
                putInt("age",11)
                putBoolean("married",false)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
//        val inputText = edittext.text.toString()
//        save(inputText)
    }

    private fun save(inputText: String) {
        val output = openFileOutput("data", Context.MODE_PRIVATE)
        val writer = BufferedWriter(OutputStreamWriter(output))
        writer.use {
            it.write(inputText)
        }
    }

    private fun load(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }
}