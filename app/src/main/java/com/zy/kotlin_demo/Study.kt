package com.zy.kotlin_demo

/**
 * 2.5.3 接口
 */
interface Study {
    fun readBooks()

    /**
     * 如果添加了默认的实现方法  实现接口的类是不用实现这个方法的
     */
    fun doHomeWork(){
        println("你做你妈的作业呢？")
    }
}