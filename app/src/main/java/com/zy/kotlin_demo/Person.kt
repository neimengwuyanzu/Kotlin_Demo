package com.zy.kotlin_demo

/**
 * 默认的类是无法继承的 前面加了open就可以
 */
open class Person(val name:String,val age:Int) {//跟着书上写不知求导为什么报错了
    /**
     * 他妈得注释了这部分就可以了
     */
//    var name = name
//    var age = age

    fun eat(){
        println(name + "在吃东西 他今年" + age+"岁了")
    }

}