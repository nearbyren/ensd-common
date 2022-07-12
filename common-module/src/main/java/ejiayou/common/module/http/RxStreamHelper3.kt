package ejiayou.common.http

import io.reactivex.Observable
import io.reactivex.ObservableTransformer


/**
 * @author:
 * @created on: 2022/7/7 15:54
 * @description:
 */

object RxStreamHelper3 {


    fun <T : Any> handleResult(): ObservableTransformer<HttpResult<T>, T> {
        return ObservableTransformer { upstream ->
            upstream.flatMap { t ->
                if (t.status == 0) {
                    Observable.create { emitter ->
                        try {
                            t.data?.let { emitter.onNext(it) }
                            emitter.onComplete()
                        } catch (e: Exception) {
                            emitter.onError(e)
                        }
                    }
                } else {
                    Observable.error(Exception(t.message))
                }
            }

        }
    }
}
