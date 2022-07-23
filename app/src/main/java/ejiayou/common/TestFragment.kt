package ejiayou.common

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import ejiayou.common.module.R
import ejiayou.common.module.base.BaseAppBindFragment
import ejiayou.common.module.databinding.TestFragmentBinding
import ejiayou.common.module.ui.BarHelperConfig
import ejiayou.common.module.utils.ToastUtils

/**
 * @author:
 * @created on: 2022/7/21 10:29
 * @description:
 */

class TestFragment : BaseAppBindFragment<TestFragmentBinding>() {


    override fun initBarHelperConfig(): BarHelperConfig? {
        return BarHelperConfig.builder()
                .setTitle("fragment")
                .setRightText("fragment")
                .setIconRight(R.drawable.next_right_back)
                .setBack(true).build()
    }


    override fun initialize(savedInstanceState: Bundle?) {
            ToastUtils.showToast(requireContext(),"initialize")

    }

    override fun layoutRes(): Int {
        return R.layout.test_fragment
    }

    override fun layoutViewGroup(): ViewGroup? {
        return null
    }

    override fun layoutView(): View? {
        return null
    }


}