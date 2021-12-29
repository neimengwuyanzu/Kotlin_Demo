package com.zy.kotlin_demo

/**
 * 5.6.2 运算符重载
 */
class Money (val value: Int) {
    operator fun plus(money: Money) : Money{
        val sum = value+ money.value
        return Money(sum)
    }

    /**
     * 多重重载
     */
    operator fun plus(newValue:Int):Money{
        val sum = value+newValue
        return Money(sum)
    }
}