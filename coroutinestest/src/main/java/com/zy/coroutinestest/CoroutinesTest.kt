import kotlinx.coroutines.*

fun main(){


    /**
     * withContext()函数是一个挂起函数，
     * 大体可以将它理解成async函数的一种简化版写法
     * 调用withContext()函数之后，会立即执行代码块中的代码，
     * 同时将外部协程挂起。当代码块中的代码全部执行完之后，
     * 会将最后一行的执行结果作为withContext()函数的返回值返回，
     * 因此基本上相当于valresult = async{ 5 + 5 }.await()的写法。
     * 唯一不同的是，withContext()函数强制要求我们指定一个线程参数
     *
     * Dispatchers.Default
     *      表示会使用一种默认低并发的线程策略
     *      当你要执行的代码属于计算密集型任务时，
     *      开启过高的并发反而可能会影响任务的运行效率，
     *      此时就可以使用Dispatchers.Default
     * Dispatchers.IO
     *      表示会使用一种较高并发的线程策略，
     *      当你要执行的代码大多数时间是在阻塞和等待中，
     *      比如说执行网络请求时，为了能够支持更高的并发数量，
     *      此时就可以使用Dispatchers.IO
     * Dispatchers.Main
     *      则表示不会开启子线程，而是在Android主线程中执行代码
     */
    runBlocking {
        val result = withContext(Dispatchers.Default){
            5+5
        }
        println("最后计算结果:$result")
    }

    /**
     * 调用了async函数之后，
     * 代码块中的代码就会立刻开始执行。
     * 当调用await()方法时，如果代码块中的代码还没执行完，
     * 那么await()方法会将当前协程阻塞住，
     * 直到可以获得async函数的执行结果。
     * 这样写法就跟不在协程一个样了
     */
//    runBlocking {
//        val start = System.currentTimeMillis()
////        //这是没优化过的写法
////        val result1 = async {
////            delay(1000)
////            5+5
////        }.await()
////        val result2 = async {
////            delay(1000)
////            10+10
////        }.await()
////        println("最后计算结果应该是30，实际结果为：${result1+result2}")
//        //这是优化过的写法 仅在需要用到async函数的执行结果时才调用await()方法进行获取  效率快了很多
//        val result1 = async {
//            delay(1000)
//            5+5
//        }
//        val result2 = async {
//            delay(1000)
//            10+10
//        }
//        println("最后计算结果应该是30，实际结果为：${result1.await()+result2.await()}")
//        val end = System.currentTimeMillis()
//        println("计算完成时间：${end-start}")
//    }




    /**
     * async函数必须在协程作用域当中才能调用，
     * 它会创建一个新的子协程并返回一个Deferred对象，
     * 如果我们想要获取async函数代码块的执行结果，
     * 只需要调用Deferred对象的await()方法即可
     */
//    runBlocking {
//        val result = async {
//            5+5
//        }.await()
//        println("计算结果：$result")
//    }


    /**
     * 项目中常用的方法
     * 现在所有调用CoroutineScope的launch函数所创建的协程，
     * 都会被关联在Job对象的作用域下面。
     * 这样只需要调用一次cancel()方法，
     * 就可以将同一作用域内的所有协程全部取消，从而大大降低了协程管理的成本。
     */
//    val job = Job()
//    val scope = CoroutineScope(job)
//    scope.launch {
//        //处理具体逻辑
//        println("协程1跑起来了")
//        delay(1000)
//    }
//    scope.launch {
//        println("协程2跑起来了")
//        delay(1000)
//    }
//    job.cancel()

//    val job = GlobalScope.launch {
//        //做一些事情
//    }
//    job.cancel()//取消协程的操作

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
//    runBlocking {
//        coroutineScope {
//            launch {
//                for (i in 1..10){
//                    println(i)
//                    delay(1000)
//                }
//            }
//        }
//        println("coroutineScope他妈的跑完了！")
//    }
//    println("协程跑完了！")
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






}
/**
 * 提取方法出来 因为不在作用域 所以没办法用delay
 * 但是加了关键字 suspend 就可以了
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