package ejiayou.common.ui

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger

open abstract class BaseActivityTitleKot<T : PresenterKot?> : AppCompatActivity() {
    /**
     * 是否需要加载数据失败预览
     *
     * @return
     */
    open fun isStateLayout(): Boolean {
        return false
    }


    override fun onStart() {
        super.onStart()
        //获取子类实现的操作层 管理生命周期
        mPresenter = getPresenterKot()
        mPresenter?.let {
            Logger.d("onStart detachView let")
        } ?: Logger.d("onStart detachView ?: ")
    }

    /**
     * 管理操作数据层的生命周期
     */
    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.let {
            Logger.d("onStart detachView let")
            it.detachView()
        } ?: Logger.d("onStart detachView ?: ")
    }

    /**
     * 操作数据层
     */
    protected var mPresenter: T? = null

    /**
     * 抽象由子类实现
     *
     * @return
     */
    abstract fun getPresenterKot(): T

    /**
     * 加载布局文件
     *
     * @return
     */
    abstract fun layoutRes(): Int

    /**
     * 根布局 [可控制网络加载隐藏的部分]
     *
     * @return
     */
    abstract fun layoutViewGroup(): ViewGroup?

    /**
     * 内容布局[可控制网络加载隐藏的部分]
     *
     * @return
     */
    abstract fun layoutView(): View?

    /**
     * 初始化控件
     */
    abstract fun initView()

    /**
     * 当前activity
     *
     * @return
     */
    abstract fun getActivity(): BaseActivityKot?
}
