package ejiayou.common.http

import io.reactivex.Observable
import io.reactivex.Observer


/**
 * @author:
 * @created on: 2022/7/7 15:09
 * @description:
 */
class ObservableProxy<T>(observable: Observable<T>) {

    private val mObservable: Observable<T>

    fun origin(): Observable<T> {
        return mObservable
    }

    fun subscribe(observer: ObserverInterface<T>) {
        mObservable.subscribe(observer)
    }

    companion object {
        fun <T> createProxy(observable: Observable<T>?): ObservableProxy<T> {
            return ObservableProxy(observable!!
                    .compose(SchedulersCompat.main()))
        }
    }

    init {
        mObservable = observable
    }
}
