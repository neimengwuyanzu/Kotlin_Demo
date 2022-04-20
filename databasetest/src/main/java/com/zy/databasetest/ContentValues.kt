import android.content.ContentValues

/**
 * Pair参数，也就是使用A to B语法结构创建出来的参数类型
 * vararg对应的就是Java中的可变参数列表，
 *      我们允许向这个方法传入0个、1个、2个甚至任意多个Pair类型的参数，
 *      这些参数都会被赋值到使用vararg声明的这一个变量上面，
 *      然后使用for-in循环可以将传入的所有参数遍历出来
 * Any 相当于object 带问号表示可以传null
 */
fun cvOf(vararg pairs:Pair<String,Any?>) = ContentValues().apply{
//    val cv = ContentValues()
    for (pair in pairs){
        val key = pair.first
        val value = pair.second
        when(value){
            is Int -> put(key,value)
            is Long -> put(key,value)
            is Short -> put(key,value)
            is Float -> put(key,value)
            is Double -> put(key,value)
            is Boolean -> put(key,value)
            is String -> put(key,value)
            is Byte -> put(key,value)
            is ByteArray -> put(key,value)
            null -> putNull(key)
        }
    }
}