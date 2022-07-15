package ejiayou.common.module.base

import androidx.databinding.ViewDataBinding
import ejiayou.common.module.dialog.LoadingDialog
import ejiayou.common.module.mvvm.BaseBVMFragment
import ejiayou.common.module.mvvm.BaseViewModel

/**
 * @description: -
 * @since: 1.0.0
 */
abstract class BaseAppBVMFragment<B : ViewDataBinding, VM : BaseViewModel> :
    BaseBVMFragment<B, VM>() {
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