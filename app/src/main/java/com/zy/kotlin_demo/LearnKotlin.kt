package com.zy.kotlin_demo

import kotlin.math.max

/**
 * 第二章
 */
fun main() {
//    val a = 10//val 为不可变变量
//    println("a = " + a)

//    var a: Int = 10//var 为可变变量
//    a = a * 10
//    println("a = " + a)

    val a = 37
    val b = 40
    val value = largerNumber(a,b)
    println("larger number is " + value)


}


/**
 * 简略2.0 可以把返回类型省略 会自动判断
 */
fun largerNumber(num1:Int,num2:Int) = max(num1,num2)
/**
 * 简略写法
 * 一个函数如果只有一行代码  可以直接把结果写在尾部
 */
//fun largerNumber(num1:Int,num2:Int):Int = max(num1,num2)
/**
 * 基础写法
 * 组成 方法名(参数名:参数类型):返回类型
*/
//fun largerNumber(num1: Int, num2: Int): Int {
//    //kotlin自带方法max
//    return max(num1,num2);
//}
