package com.zy.kotlin_demo


class Util {
//object Util {//这样会把所有的方法都变成静态
    fun doAction(){
        println("搞事搞事")
    }

    companion object {//这个关键字实际是在util类里创建一个伴生类 用java去调用是没办法使用的

        @JvmStatic//加了这个注解就是真正静态方法 且这个注解只能加在单利类或者 companion object 关键字中
        fun doAction2(){
            println("搞事2.0")
        }
    }

    //顶层方法需要去Helper.kt查看
}