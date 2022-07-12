package ejiayou.common.module.mvvm

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import ejiayou.common.module.exts.observeNonNull
import ejiayou.common.module.exts.observeNullable


/**
 * @author: lr
 * @created on: 2022/7/10 11:47 上午
 * @description:基于MVVM模式的Activity的基类
 */
abstract class BaseBVMActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseBindActivity<B>(),
    ViewBehavior {


    //延迟初始化vm属性
    protected lateinit var viewModel: VM
        private set

    override fun initContentView() {
        super.initContentView()
        injectViewModel()
        initInternalObserver()
    }

    //抽取vm由使用者构建
    protected abstract fun createViewModel(): VM

    private fun injectViewModel() {
        val vm = createViewModel()
        viewModel = ViewModelProvider(this, BaseViewModel.createViewModelFactory(vm))
            .get(vm::class.java)
        viewModel.application = application
        lifecycle.addObserver(viewModel)
    }

    override fun onDestroy() {
        binding.unbind()
        lifecycle.removeObserver(viewModel)
        super.onDestroy()
    }

    private fun initInternalObserver() {
        viewModel._loadingEvent.observeNonNull(this) {
            showLoadingView(it)
        }
        viewModel._emptyPageEvent.observeNonNull(this) {
            showEmptyView(it)
        }
        viewModel._toastEvent.observeNonNull(this) {
            showToast(it)
        }
        viewModel._pageNavigationEvent.observeNonNull(this) {
            navigate(it)
        }
        viewModel._backPressEvent.observeNullable(this) {
            backPress(it)
        }
        viewModel._finishPageEvent.observeNullable(this) {
            finishPage(it)
        }
    }
}