package ejiayou.common.module.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import ejiayou.common.module.dialog.LoadingDialog
import ejiayou.common.module.mvvm.BaseBVMActivity
import ejiayou.common.module.mvvm.BaseViewModel
import ejiayou.common.module.utils.SystemUIUtils

/**
 * @author: lr
 * @created on: 2022/7/10 2:36 下午
 * @description:
 */
abstract class BaseAppBVMActivity<B : ViewDataBinding, VM : BaseViewModel> :
    BaseBVMActivity<B, VM>() {
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