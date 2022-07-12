package ejiayou.common.http

import com.orhanobut.logger.Logger
import io.reactivex.Observer
import java.lang.IllegalStateException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author:
 * @created on: 2022/7/7 16:47
 * @description:
 */
abstract class ObserverInterface<T> : Observer<T?> {
    override fun onError(e: Throwable) {
        Logger.d("进入异常 - ${e.message}")
        if (e is UnknownHostException) {
            throwError("网络连接异常")
            return
        }
        if (e is ConnectException) {
            //HTTP没有互联网连接异常
            throwError("服务连接异常")
            return
        } else if (e is SocketTimeoutException) {
            //HTTP服务器向下异常HTTP一般错误异常
            throwError("网络连接超时")
            return
        } else if (e is ServerException) {
            throwError("服务器异常")
            return
        } else if (e is IllegalStateException) {
            throwError("数据解析异常")
            return
        }

        throwError(e.message)
    }

    abstract fun throwError(msg: String?)
}
