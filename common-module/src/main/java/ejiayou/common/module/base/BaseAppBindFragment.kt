package ejiayou.common.module.base

import androidx.databinding.ViewDataBinding
import ejiayou.common.module.dialog.LoadingDialog
import ejiayou.common.module.mvvm.BaseBindFragment

/**
 * @author: lr
 * @created on: 2022/7/10 3:33 下午
 * @description:
 */
abstract  class BaseAppBindFragment <B : ViewDataBinding> : BaseBindFragment<B>() {
    private val loadingDialog by lazy { LoadingDialog() }

    override fun showLoadingView(isShow: Boolean) {
        try {
            if (isShow) {
                if (isVisible && !loadingDialog.isAdded) {
                    loadingDialog.show(this)
                }
            } else {
                if (isVisible) {
                    loadingDialog.dismissAllowingStateLoss()
                }
            }
        } catch (e: Exception) {
        }
    }

    override fun showEmptyView(isShow: Boolean) {

    }
}