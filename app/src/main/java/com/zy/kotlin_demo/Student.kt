package com.zy.kotlin_demo

/**
 * kotlin 的继承并不需要加extends 直接 class 类名：继承的类
 */
/**
 * 继承这块需要给继承的类加一个括号 原因参照2.5.2部分
 */
//class Student():Person(){
/**
 * 添加次构造方法 添加得name和age不能声明为val
 */
//class Student(val sno: String, val grade: Int, name: String, age: Int) :
//    Person(name, age) {//这种是显示的主构造参数写法 但是这种写法会报错 回家看看----注释了下面创建参数部分的部分代码就不报错了
    /**
     * 次构造函数通过下面这个方法来定义
     */
//    constructor(name: String, age: Int) : this("", 0, name, age) {

//    }

//    constructor() : this("", 0) {

//    }
/**
 * 这种是没有主构造函数 只有次构造函数的实现方法  很少会见到
 */
//class Student:Person{
//
//    constructor(name:String,age:Int):super(name,age)


/**
 * 2.5.3接口 继承和集成接口都是在类名后面冒号部分  不管是继承还是实现接口 都是用逗号分隔
 */
class Student(name:String,age:Int):Person(name,age),Study{

    init {//艹加了这个函数就可以了
//        println("sno : " + sno)
//        println("grade : " + grade)
//        /**
//         * 这段是测试代码
//         */
////        val p = Person(name,age)
////        p.eat()
////    var sno = ""
////    var grade = 0
    }

    /**
     * override关键字是用来重写父类方法或者实现接口方法
     */
    override fun readBooks() {
        println(name+"看他妈的书")
    }

//    override fun doHomeWork() {
//        println(name+"正在做他妈的作业")
//    }

}