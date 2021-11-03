package com.zy.kotlin_demo

/**
 * kotlin 的继承并不需要加extends 直接 class 类名：继承的类
 */
/**
 * 继承这块需要给继承的类加一个括号 原因参照2.5.2部分
 */
class Student(val sno:String,val grade:Int) : Person(){//这种是显示的主构造参数写法 但是这种写法会报错 回家看看
    init {

    }

    var sno = ""
    var grade = 0
}