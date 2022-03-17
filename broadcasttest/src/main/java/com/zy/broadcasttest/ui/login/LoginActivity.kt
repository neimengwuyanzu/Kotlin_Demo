package com.zy.broadcasttest.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import com.zy.broadcasttest.BaseActivity
import com.zy.broadcasttest.MainActivity
import com.zy.broadcasttest.databinding.ActivityLoginBinding

import com.zy.broadcasttest.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener{
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            //如果账号是admin且密码是123456 就认为登陆成功
            if (account == "admin" && password == "123456"){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"账号或密码错误",Toast.LENGTH_SHORT).show()
            }

        }
    }

}