package com.zy.kotlin_demo

/**
 * 默认的类是无法继承的 前面加了open就可以
 */
open class Person {

    var name = ""
    var age = 0

    fun eat(){
        println(name + "在吃东西 他今年" + age+"岁了")
    }

}