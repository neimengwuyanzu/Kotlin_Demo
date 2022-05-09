import kotlinx.coroutines.*

fun main(){
//    GlobalScope.launch {
//        println("协程他妈的跑起来了！")
//        /**
//         * 这个方法和sleep的区别就是
//         * 这个方法是一个非阻塞式的挂起函数 只会挂起当前协程
//         * 并不会影响其他协程的运行
//         * 而Thread.sleep()方法会阻塞当前的线程，这样运行在该线程下的所有协程都会被阻塞。
//         * 注意，delay()函数只能在协程的作用域或其他挂起函数中调用
//         */
//        delay(1500)//如果这个时间大于下面的  还是看不到结束的打印 因为这个协程还在挂起的时候  下面的sleep已经跑完了  直接结束了
//        println("协程他妈的跑完了！")
//    }
//    //不加这个看不到信息 因为程序跑太快
//    Thread.sleep(1000)

    /**
     * 需要注意的是，runBlocking函数通常只应该在测试环境下使用，
     * 在正式环境中使用容易产生一些性能上的问题
     * 意思就是别瞎鸡巴用
     */
//    runBlocking {
////        println("协程他妈的又跑起来了！")
////        delay(1500)
////        println("协程他妈的终于跑完了！")
//        /**
//         * 这个launch和上面那个GlobalScope.launch不一样
//         * 这个必须在作用域里才能调用
//         * 其次就是它会在当前协程的作用域创建子协程
//         *      子协程的特点是如果外层作用域的协程结束了
//         *      该作用域下的所有子协程也会一同结束
//         * GlobalScope.launch创建的永远是顶层协程 和线程比较像 因为线程没有顶层这种说法 所以永远是顶层
//         */
//        launch {
//            println("协程1跑起来了！")
//            delay(1000)
//            println("协程1跑完了！")
//        }
//        launch {
//            println("协程2跑起来了！")
//            delay(1000)
//            println("协程2跑完了！")
//        }
//    }

//    val start = System.currentTimeMillis()
//    runBlocking {
//        repeat(100000){
////            launch {
//                printNMSL()
////            }
//        }
//    }
//    val end = System.currentTimeMillis()
//    println(end - start)
    /**
     * coroutineScope函数和runBlocking函数还有点类似，
     * 它可以保证其作用域内的所有代码和子协程在全部执行完之前，
     * 外部的协程会一直被挂起。
     */
    /**
     * coroutineScope函数只会阻塞当前协程，
     * 既不影响其他协程，也不影响任何线程，
     * 因此是不会造成任何性能上的问题的。
     * 而runBlocking函数由于会挂起外部线程，
     * 如果你恰好又在主线程中当中调用它的话，
     * 那么就有可能会导致界面卡死的情况，
     * 所以不太推荐在实际项目中使用。
     */
    runBlocking {
        coroutineScope {
            launch {
                for (i in 1..10){
                    println(i)
                    delay(1000)
                }
            }
        }
        println("coroutineScope他妈的跑完了！")
    }
    println("协程跑完了！")

}
/**
 * 提取方法出来 因为不在作用域 所以没办法用
 * 但是加了关键字就可以了
 * 加了以后可以将任意函数声明成挂起函数 而挂起函数之间是可以互相调用的
 * 但是这样没办法调用launch函数 可以用coroutineScope解决
 * coroutineScope也是一个挂起函数 因此可以在任何其他挂起函数中调用
 * 特点就是会继承外部的协程作用域并创建一个子协程
 */
suspend fun printNMSL() = coroutineScope {
    launch {
        println("NMSL")
        delay(1000)
    }
}