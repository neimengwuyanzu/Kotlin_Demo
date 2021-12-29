package com.zy.kotlin_demo

/**
 * 增加string扩展函数  可以直接作用在指定的数据格式后面
 */
fun String.lettersCount():Int{
    var count = 0
    for(char in this){
        if (char.isLetter()){
            count++
        }
    }
    return count
}