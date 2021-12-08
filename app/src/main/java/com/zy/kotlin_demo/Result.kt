package com.zy.kotlin_demo

import java.lang.Exception

//interface Result
sealed class Result//密封消息
class Sucess(val msg:String):Result()
class Failure(val error:Exception):Result()