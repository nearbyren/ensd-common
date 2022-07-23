package ejiayou.common

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import ejiayou.common.databinding.TestActivityBinding
import ejiayou.common.http.TestViewModel
import ejiayou.common.module.base.BaseAppBVMActivity
import ejiayou.common.module.ui.*
import ejiayou.common.module.utils.ToastUtils

/**
 * @author: lr
 * @created on: 2022/7/15 10:30 下午
 * @description:
 */
class TestActivity : BaseAppBVMActivity<TestActivityBinding, TestViewModel>() {
    override fun layoutRes(): Int {
        return R.layout.test_activity
    }


    override fun initialize(savedInstanceState: Bundle?) {
        Log.d("TTT", "initialize")
        val manager = supportFragmentManager
        val beginTransaction = manager.beginTransaction()
        val fragment = TestFragment()

        beginTransaction.add(R.id.frameLayout, fragment)

        beginTransaction.commit()
        binding.testHttp.setOnClickListener {
            binding.emptyLoading.loadingEmptyView.start()
            viewModel.getTestList()
            binding.ltGift.setAnimation("lottie/loading.json")
            binding.ltGift.playAnimation()
        }
    }

    override fun initImmersionBarConfig(): ImmersionBarConfig? {
        return ImmersionBarConfig.builder().build()
    }

    override fun initBarHelperConfig(): BarHelperConfig? {
        return BarHelperConfig.builder()
                .setTitle("哈哈哈")
                .setOnBackListener(object : BarOnBackListener {
                    override fun onBackClick() {
                        ToastUtils.showToast(applicationContext, "onBackClick")

                    }

                }).setOnNextListener(object : BarOnNextListener {
                    override fun onNextClick() {
                        ToastUtils.showToast(applicationContext, "OnNextListener")
                    }

                })

                .setBack(true).build()
    }


    override fun layoutViewGroup(): ViewGroup? {
        return null
    }

    override fun layoutView(): View? {
        return null
    }


    override fun createViewModel(): TestViewModel {
        return TestViewModel()
    }
}