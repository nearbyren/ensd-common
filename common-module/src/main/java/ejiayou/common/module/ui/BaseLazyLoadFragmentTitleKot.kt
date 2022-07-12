package ejiayou.common.ui

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open abstract class BaseLazyLoadFragmentTitleKot: Fragment() {


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



}
