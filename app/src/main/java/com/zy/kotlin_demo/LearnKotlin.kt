package com.zy.kotlin_demo

import kotlin.math.max
import kotlin.text.StringBuilder

/**
 * 第二章 一些基础语法 变量创建 if when for
 */

var content: String = "hello"
val brand = "三星"
val price = 9999
fun main() {


    /**
     * 5.6.2 运算符重载
     */
    val money1 = Money(5)
    val money2 = Money(10)
    val money3 = money1+money2
    val money4 = money3 + 20
    println(money4.value)


    /**
     * 5.6.1扩展函数

    val count = "ABC123xzy!@#!".lettersCount()
    println(count)
     */


    /**
     * 3.7.2 定义静态方法

    val u = Util()
    u.doAction()

    Util.doAction2()
     */


    /**
     * 调用顶层方法

    doSomething()
    nmsl()
     */

    /**
     * 3.7.1
     * 标准函数with

    useWithFUN()
     */




    /**
     * 2.8.1
     * 字符串内嵌表达式
     *

    println("Cellphone(brand = $brand, price=$price )")
     */

    /**
     * 2.8.2
     * 函数默认参数

    //    printParams(100)
    printParams(num = 100, str = "nmsl")
     */

    /**
     *
    //    if (content != null){
    //        printUpperCase()
    //    }
    //    if (content != null){
    //        printUpperCase()
    //    }
     */

    /**
     *
    //    getTextLength("NMSL")
     */


    /**
     *

    //    useJavaAPI()
     */

    /**
     *

    //    LambdaDemo()
     */

    /**
     *

    //    ListDemo()
     */


    /**
     * 创建数据类

    //    val c1 = Cellphone("nmsl",99.1)
    //    val c2 = Cellphone("nmsl",99.1)

    //    println(c1)
    //    println(c2)

    //    println("是否相等： " + (c1 == c2))//这个地方书上打印出来时true  我这边是false 原因是数据给的不一样 如果一样就是true
     */

    /**
     * 单例的使用

    //    Singleton.singletonTest()
     */


    /**
     * 创建对象少了一个 new关键字

    //    val p = Person("NMSL",18)
    //    p.name = "nmsl"
    //    p.age = 20
    //    p.eat()
     */

    /**
     * 创建student 主构造函数得用法

    //    val s = Student("a123",5,"???",19)
     */

    /**
     * 实现了次构造函数时候的创建方式
     * 可以有三种创建方式

    //    val s1 = Student()
    //    val s2 = Student("NMSL",19)
    //    val s3 = Student("??",5,"nmsl",19)
     */
    /**
     * 只有次构造函数的时候 且没有主构造函数

    //    val s = Student("NMSL",19)
     */
    /**
     * 实现接口

    //    val student = Student("NMSL", 18)
     */


    /**
     *
//    doStudy(student)

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
     */

    /**
     * downto 就是降序 也是闭合区间 展现出来就是10-1
     * 但是我把downto 改成了 until 没有报错 也没有打印出来10-1

    //    for (i in 10 downTo 1){
    //        println(i)
    //    }
     */


    /**
     * step 这个关键词就相当于java循环里的i++ 变成了i+2 每次增加2

//    for (i in 0 until 10 step 2){
//        println(i)
//    }
     */


    /**
     * 加了until 就是单端闭合区间 这种写法展示的就是0-9

//    for (i in 0 until 10){
//        println(i)
//    }
     */

    /**
     * 这里有个区间的概念 0..10  包含的就是1-10 书里说这就是两端闭合区间

//    for (i in 0..10){
//        println(i)
//    }
     */
}

/**
 * 3.7.1
 * 标准函数with的使用
 */
fun useWithFUN() {
    val list = listOf("苹果", "香蕉", "橘子", "梨", "不认识")
    //挨个吃水果的常规写法
//    val builder = StringBuilder()
//    builder.append("开始吃水果  \n")
//    for (fruit in list){
//        builder.append(fruit).append(" 被吃掉了 \n")
//    }
//    builder.append("吃光了")
//    val result = builder.toString()


    //使用with来写
    /**
     * 写完发现用这个函数就是传入一个StringBuilder对象
     * 然后在方法内可以直接调用对象方法
     * 然后lambda最后一行作为返回值直接调用tostring方法

    val result = with(StringBuilder()){
    append("开始吃水果了")
    for (fruit in list){
    append(fruit).append("  被吃了 \n")
    }
    append("真尼玛能吃")
    toString()
    }
     */

    //使用run来写
    /**
     * run 和with的区别就是 run是直接调用的对象的run方法  而with是把对象传进去 调用对象的方法

    val result = StringBuilder().run {
    append("开吃开吃 \n")
    for (fruit in list){
    append(fruit).append("被吃了 \n")
    }
    append("真尼玛能吃")
    toString()
    }
     */

    //使用apply 来写
    /**
     * apply区别于run 没有返回值
     */
    val result = StringBuilder().apply {
        append("开吃开吃 \n")
        for (fruit in list) {
            append(fruit).append("被吃了 \n")
        }
        append("真尼玛能吃")
    }

    println(result.toString())
}

fun printParams(num: Int, str: String = "hello") {
    println("num = $num , str = $str")
}

/**
 * 2.7.2
 * 照书上说 这样是无法运行得 但是现在可以..
 * 书上会提示 这样无法运行 但是加上“！！”就可以
 */
fun printUpperCase() {
    val upperCase = content!!.toUpperCase()
//    val upperCase = content.toUpperCase()
    println(upperCase)
}

/**
 * 2.7.2 判空辅助工具使用
 * 使用？：操作符 左右各有表达式 如果左边表达式结果不为空就返回左边表达式  否则返回右边表达式结果
 */
fun getTextLength(text: String?) = text?.length ?: 0

/**
 * 2.6.3 java函数式API的使用
 */
private fun useJavaAPI() {
    Thread(object : Runnable {
        override fun run() {
            println("线程启动")
        }
    }).start()

    /**
     * 简化1.0 runnable如果只有一个待实现的方法 就可以省略run方法
     */
    Thread(Runnable {
        println("简化1.0线程启动")
    }).start()

    /**
     * 简化2.0 只有一个方法接口参数 省略接口名
     */
    Thread({
        println("简化2.0线程启动")
    }).start()

    /**
     * 简化3.0 跟lambda表达式一样 如果是方法唯一参数 可以省略括号
     */
    Thread {
        println("简化3.0线程启动")
    }.start()
}

private fun ListDemo() {
    /**
     * 创建一个list
     */
    /**
     * listof创建的是一个不可变的集合  只有读取 无法添加修改删除
     */
//    val list = listOf<String>("苹果","香蕉","橘子","梨","grape？妈的我不认识")

    /**
     * mutableListOf创建的list是动态可操作的
     */
//    val list = mutableListOf<String>("苹果","香蕉","橘子","梨","grape？妈的我不认识")
//    list.add("西瓜")

    /**
     * 遍历一个list
     */
//    for (fruit in list){
//        println(fruit)
//    }

    /**
     * 创建一个set
     */
//    val set = setOf("苹果","香蕉","橘子","梨","grape？妈的我不认识")
//    val set = mutableSetOf("苹果","香蕉","橘子","梨","grape？妈的我不认识")
//    set.add("西瓜")
//    for (fruit in set){
//        println(fruit)
//    }

    /**
     * map
     */
//    val map = HashMap<String,Int>()
    /**
     * kotlin也可以put get的方式获取
     * 但是更推荐用下标赋值
     */
//    map["苹果"] = 1
//    map["香蕉"] = 2
//    map["橘子"] = 3
//    map["梨"] = 4
//    map["grape？妈的我不认识"] = 5
//    val num = map["苹果"]
    /**
     * 也可以跟上面一样用mapof   mutableMapOf来创建
     * to 不是一个关键字 是一个infix函数 这个后面会讲
     */
//    val map = mutableMapOf<String,Int>("苹果" to 1,"香蕉" to 2,"橘子" to 3,"梨" to 4,"grape？妈的我不认识" to 5)
    /**
     * 遍历就是跟前面list set一样 把单个要遍历的对象换成了两个 用括号括起来
     */
//    for ((fruit,num) in map){
//        println(fruit + "====" + num)
//    }
}

private fun LambdaDemo() {
    /**
     * 2.6.2 lambda表达式
     *
     * lambda 就是一小段可以作为参数传递的代码
     * 语法结构就是{参数名1：参数类型，参数名2：参数类型 -> 函数体}
     * 这个地方用书上原来的方法maxBy会报错  换maxByOrNull可以
     */
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")

    /**
     * 这是比较全的写法
     */
//    val lambda = {fruit:String -> fruit.length}
//    val maxLengthFruit = list.maxByOrNull(lambda)

    /**
     * 简化1.0
     * 省略掉lambda的对象
     */
//    val maxLengthFruit = list.maxByOrNull({fruit:String -> fruit.length})
    /**
     * 简化2.0
     * 如果lambda参数是最后一个参数 可以放到括号外面
     * 我理解就是定义的fruit是一个参数  也是最后一个参数 所以可以放外面
     */
//    val maxLengthFruit = list.maxByOrNull(){fruit:String -> fruit.length}
    /**
     * 简化3.0
     * 如果lambda参数是函数唯一一个参数 还可以省略掉（）
     * 这个我猜是不是说里面只有一段lambda代码 如果有两段就不能这么写？
     */
//    val maxLengthFruit = list.maxByOrNull { fruit:String -> fruit.length }
    /**
     * 简化4.0
     * kotlin有类型推导机制 lambda里参数大多情况不必声明参数类型
     */
//    val maxLengthFruit = list.maxByOrNull { fruit -> fruit.length }
    /**
     * 简化5.0
     * 如果只有一个参数 也不用参数名 直接使用it关键字代替
     */
//    val maxLengthFruit = list.maxByOrNull { it.length }
//    println(maxLengthFruit)

    /**
     * map函数是把每个元素都映射成另外一个值，映射的规则在lambda表达式中指定 最后生成一个新的集合
     */
//    val newList = list.map { it.toUpperCase() }
//    for (fruit in newList) {
//        println(fruit)
//    }

    /**
     * filter过滤
     *
     * 结合map函数  过滤小于五个字母内的并且转换大写
     */
    val newList = list.filter { it.length <= 5 }
        .map { it.toUpperCase() }

    for (fruit in newList) {
        println(fruit)
    }

    /**
     * any函数 判断集合中是否至少存在一个元素满足指定条件
     */
    val anyResult = list.any { it.length <= 5 }

    /**
     * all函数 判断集合中是否所有元素都满足指定条件
     */
    val allResult = list.all { it.length <= 5 }
    println("any? = " + anyResult)
    println("all? = " + allResult)

}

/**
 * kotlin自带判空处理
 * 如果参数类型后面加一个“？”  就表示这个参数可以为空
 */
//fun doStudy(student: Student) {
/**
 * 2.7.1 传入参数判空处理
 */
fun doStudy(student: Student?) {
    /**
     * 常规判空处理
     */
//    if (student != null) {
//        student.readBooks()
//        student.doHomeWork()
//    }

    /**
     * kotlin 判空辅助工具 2.7.2
     */
//    student?.readBooks()
//    student?.doHomeWork()
    /**
     * 2.7.2 用let函数
     * ?操作表示student为空时候什么都不做 不会空时候调用let函数
     * 并且根据lambda表达式优化 可以省略 stu
     */
    student?.let {
//            stu ->
//        stu.readBooks()
//        stu.doHomeWork()
        it.readBooks()
        it.doHomeWork()
    }

}


fun getScore(name: String) = when {
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
fun checkNumber(num: Number) {
    when (num) {
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
fun largerNumber(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

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
