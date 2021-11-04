package com.zy.kotlin_demo

import kotlin.math.max

/**
 * 第二章 一些基础语法 变量创建 if when for
 */
fun main() {
    /**
     * 创建对象少了一个 new关键字
     */
//    val p = Person("NMSL",18)
//    p.name = "nmsl"
//    p.age = 20
//    p.eat()

    /**
     * 创建student 主构造函数得用法
     */
    val s = Student("a123",5,"???",19)



//    val a = 10//val 为不可变变量
//    println("a = " + a)

//    var a: Int = 10//var 为可变变量
//    a = a * 10
//    println("a = " + a)

//    val a = 37
//    val b = 40
//    val value = largerNumber(a,b)
//    println("larger number is " + value)

//    val score = getScore("nmsl")
//    println("score == " + score)
//
//    checkNumber(10L)

    /**
     * downto 就是降序 也是闭合区间 展现出来就是10-1
     * 但是我把downto 改成了 until 没有报错 也没有打印出来10-1
     */
//    for (i in 10 downTo 1){
//        println(i)
//    }


    /**
     * step 这个关键词就相当于java循环里的i++ 变成了i+2 每次增加2
     */
//    for (i in 0 until 10 step 2){
//        println(i)
//    }


    /**
     * 加了until 就是单端闭合区间 这种写法展示的就是0-9
     */
//    for (i in 0 until 10){
//        println(i)
//    }

    /**
     * 这里有个区间的概念 0..10  包含的就是1-10 书里说这就是两端闭合区间
     */
//    for (i in 0..10){
//        println(i)
//    }
}


fun getScore(name:String) = when{
    name.startsWith("nm") -> 60
    name == "cnm" -> 30
    else -> 0
}

/**
 * when使用的一种常规类型  kotlin 判断字符串或者对象是否相等 可以使用== 不必使用equals
 */
//fun getScore(name:String) = when{
//    name == "nmsl" -> 60
//    name == "cnm" -> 30
//    else -> 0
//}


/**
 * 判断数据类型  Number是kotlin自带的 源码挺简单的
 */
fun checkNumber(num:Number){
    when(num){
        is Int -> println("是他妈的整数")
        is Double -> println("是他妈的小数")
        else -> println("能不能传点阳间的数据")
    }
}


/**
 * kotlin 里的when语句
 *
 * when(参数){
 *     匹配值 -> {执行代码}
 * }
 */
//fun getScore(name:String) = when (name){
//    "nmsl" -> 80
//    "cnm" -> 60
//    else -> 0
//}

/**
 * 精简2.0
 */
fun largerNumber(num1:Int,num2:Int) = if (num1>num2) num1 else num2

/**
 * 精简1.0
 */
//fun largerNumber(num:Int,num2:Int) = if (num>num2){
//    num
//}else{
//    num2
//}

/**
 * kotlin 里的if是可以有返回值的 返回值就是每个语句里的最后一句  、
 *
 * 类似if（条件）{
 *     code1
 *     code2
 *     code3
 *     code4 这个就是返回值
 * }
 */
//fun largerNumber(num1:Int,num2:Int):Int{
//    val value = if (num1>num2){
//        num1
//    }else{
//        num2
//    }
//    return value
//}

/**
 * if 判断条件
 */
//fun largerNumber(num1:Int,num2:Int):Int{
//    var value = 0
//    if (num1>num2){
//        value = num1
//    }else{
//        value = num2
//    }
//    return value;
//}

/**
 * 简略2.0 可以把返回类型省略 会自动判断
 */
//fun largerNumber(num1:Int,num2:Int) = max(num1,num2)
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
