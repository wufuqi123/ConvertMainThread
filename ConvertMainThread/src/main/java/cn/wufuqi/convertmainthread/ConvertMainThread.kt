package cn.wufuqi.convertmainthread

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

/**
 * 转成主线程
 */
object ConvertMainThread {

    /**
     * 创建一个最大为10个线程的线程池
     */
    private var mThreadPool = Executors.newFixedThreadPool(10)

    /**
     * 创建一个在主线程的  Handler
     */
    private val mHandler by lazy {
        Handler(Looper.getMainLooper())
    }


    /**
     * 把 func 方法里的代码转到主线程执行
     */
    fun runOnUiThread(func: () -> Unit) {
        if (Thread.currentThread() == Looper.getMainLooper().thread) {
            // 如果当前线程是主线程
            //直接执行回调
            func.invoke()
            return
        }
        mHandler.post {
            func.invoke()
        }
    }


    /**
     * 让代码在子线程执行
     */
    fun runOnNoMainThread(func: () -> Unit) {
        if (Thread.currentThread() != Looper.getMainLooper().thread) {
            // 如果当前线程不是主线程
            //直接执行回调
            func.invoke()
            return
        }
        mThreadPool.submit {
            func.invoke()
        }
    }


}