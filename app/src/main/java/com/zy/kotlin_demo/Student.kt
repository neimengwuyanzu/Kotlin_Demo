package com.zy.kotlin_demo

/**
 * kotlin 的继承并不需要加extends 直接 class 类名：继承的类
 */
/**
 * 继承这块需要给继承的类加一个括号 原因参照2.5.2部分
 */
/**
 * 添加得name和age不能声明为val
 */
class Student(val sno: String, val grade: Int, name: String, age: Int) :
    Person(name, age) {//这种是显示的主构造参数写法 但是这种写法会报错 回家看看----注释了下面得部分代码就不报错了

    init {//艹加了这个函数就可以了
        println("sno : " + sno)
        println("grade : " + grade)
        /**
         * 这段是测试代码
         */
//        val p = Person(name,age)
//        p.eat()
//    var sno = ""
//    var grade = 0
    }

}