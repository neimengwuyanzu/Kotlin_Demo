package com.zy.kotlin_demo

/**
 * 2.5.4 数据类/实体类
 * class 前加data 就声明了这是一个数据类 会默认写了equals hashcode tostring等方法 如果没有别的处理 可以不写大括号
 */
data class Cellphone(val brand: String, val price: Double)