package ejiayou.common.module.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import ejiayou.common.module.dialog.LoadingDialog
import ejiayou.common.module.mvvm.BaseBindActivity
import ejiayou.common.module.utils.SystemUIUtils

/**
 * @author: lr
 * @created on: 2022/7/10 11:13 上午
 * @description:
 */

abstract class BaseAppBindActivity<B : ViewDataBinding> : BaseBindActivity<B>() {

    private val loadingDialog by lazy { LoadingDialog() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUIUtils.transparentStatusBar(this)
    }

    override fun showLoadingView(isShow: Boolean) {
        try {
            if (isShow) {
                if (!isFinishing && !loadingDialog.isAdded) {
                    loadingDialog.show(this)
                }
            } else {
                if (!isFinishing) {

                    loadingDialog.dismissAllowingStateLoss()
                }
            }
        } catch (e: Exception) {
        }
    }

    override fun showEmptyView(isShow: Boolean) {

    }
}