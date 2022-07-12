package ejiayou.common.http

import android.app.Activity
import androidx.annotation.NonNull
import com.orhanobut.logger.Logger
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference


object SchedulersCompat {
    /**
     * 请求弹出框
     *
     * @param activity
     * @param msg
     * @param <T>
     * @return
    </T> */
    fun <T> applyProgress(@NonNull activity: Activity, msg: String?): ObservableTransformer<T, T> {
        val contextWeakReference = WeakReference(activity)
        //        DialogRequest.getInstance(contextWeakReference.get()).show(contextWeakReference.get(), msg);
        return ObservableTransformer { upstream ->
            upstream.doOnSubscribe { Logger.d("accept") }.doOnTerminate {
                var context: Activity?
                Logger.d(" activity = " + contextWeakReference.get() + " - " + contextWeakReference.get()!!.isFinishing)
                if (contextWeakReference.get().also { context = it } != null) {
                    Logger.d("run  - doOnTerminate - 1")
                    //                            DialogRequest.getInstance(contextWeakReference.get()).dismiss(contextWeakReference.get());
                    Logger.d("run - doOnTerminate - 1")
                } else {
                    Logger.d("run - doOnTerminate - 2")
                }
            }.doOnSubscribe { Logger.d("观察者订阅了它生成的Observable.....................") }
        }
    }


    fun <T> main(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}
