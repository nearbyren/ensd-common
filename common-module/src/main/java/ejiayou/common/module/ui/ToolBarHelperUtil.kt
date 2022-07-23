package ejiayou.common.ui


import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.gyf.immersionbar.ImmersionBar
import ejiayou.common.module.R
import ejiayou.common.module.ui.BarHelperConfig
import ejiayou.common.module.ui.ImmersionBarConfig


data class ToolBarHelperUtil(var barHelperConfig: BarHelperConfig? = null, var immersionBarConfig: ImmersionBarConfig? = null) {


    companion object {
        @JvmStatic
        fun builder() = ToolBarHelperUtilBuilder()

    }

    private lateinit var immersionBar: ImmersionBar

    fun init() {
        barHelperConfig?.let {
            it
            it.bgColor = if (it.bgColor == 0) R.color.white else it.bgColor
            it.activity?.let {
                initImmersionBar(it)
            }
            it.fragmentView?.let {
                fragmentView()
            } ?: isActivity()
        }
    }

    fun getImmersionBar() = immersionBar


    private fun initImmersionBar(activity: AppCompatActivity) {
        immersionBarConfig?.let {
            immersionBar = ImmersionBar.with(activity)
            if (it.statusBarColor > 0) {
                immersionBar.statusBarColor(it.statusBarColor)
            }
            if (it.navigationBarColor > 0) {
                immersionBar.navigationBarColor(it.navigationBarColor)
            }
            if (it.statusBarAlpha != 0.0f) {
                immersionBar.statusBarAlpha(it.statusBarAlpha)
            }
            if (it.navigationBarAlpha != 0.0f) {
                immersionBar.navigationBarAlpha(it.navigationBarAlpha)
            }
            if (it.barAlpha != 0.0f) {
                immersionBar.barAlpha(it.barAlpha)
            }
            if (it.statusBarDarkFont) {
                immersionBar.statusBarDarkFont(it.statusBarDarkFont)
            }
            if (it.flymeOSStatusBarFontColor > 0) {
                immersionBar.flymeOSStatusBarFontColor(it.flymeOSStatusBarFontColor)
            }
            if (it.fullScreen) {
                immersionBar.fullScreen(it.fullScreen)
            }
            immersionBar.hideBar(it.hideBar)
            if (it.addViewSupportTransformColor != null) {
                immersionBar.addViewSupportTransformColor(it.addViewSupportTransformColor)
            }
            if (it.titleBar != null) {
                immersionBar.titleBar(it.titleBar)
            }
            if (it.titleBarMarginTop != null) {
                immersionBar.titleBar(it.titleBarMarginTop)
            }
            if (it.statusBarView != null) {
                immersionBar.statusBarView(it.statusBarView)
            }
            if (it.fitsSystemWindows) {
                immersionBar.fitsSystemWindows(it.fitsSystemWindows)
            }
            if (it.supportActionBar) {
                immersionBar.supportActionBar(it.supportActionBar)
            }
            if (it.statusBarColorTransform > 0) {
                immersionBar.statusBarColorTransform(it.statusBarColorTransform)
            }
            if (it.navigationBarColorTransform > 0) {
                immersionBar.navigationBarColorTransform(it.navigationBarColorTransform)
            }
            if (it.barColorTransform > 0) {
                immersionBar.barColorTransform(it.barColorTransform)
            }
            if (it.removeSupportView != null) {
                immersionBar.removeSupportView(it.removeSupportView)
            }
            immersionBar.navigationBarEnable(it.navigationBarEnable)
            immersionBar.navigationBarWithKitkatEnable(it.navigationBarWithKitkatEnable)
            if (!TextUtils.isEmpty(it.addTag)) {
                immersionBar.addTag(it.addTag)
            }
            if (!TextUtils.isEmpty(it.getTag)) {
                immersionBar.getTag(it.getTag)
            }
            if (it.reset) {
                immersionBar.reset()
            }
            immersionBar.keyboardEnable(it.keyboardEnable)
            if (it.keyboardMode > 0) {
                immersionBar.keyboardMode(it.keyboardMode)
            }
            if (it.onKeyboardListener != null) {
                immersionBar.setOnKeyboardListener(it.onKeyboardListener)
            }
            if (it.onBarListener != null) {
                immersionBar.setOnBarListener(it.onBarListener)
            }
            if (it.onNavigationBarListener != null) {
                immersionBar.setOnNavigationBarListener(it.onNavigationBarListener)
            }
            immersionBar.init()
        }
    }


    //fragment
    private fun fragmentView() {
        barHelperConfig?.let {
            var activity = it.activity!!
            var fragmentView = it.fragmentView!!
            fragmentView.findViewById<View>(R.id.toolbar_id) ?: return
            val toolbarId: Toolbar = fragmentView.findViewById(R.id.toolbar_id)
            toolbarId.title = ""
            activity.setSupportActionBar(toolbarId)
            activity.supportActionBar?.setDisplayShowTitleEnabled(false)
            toolbarId.setNavigationOnClickListener {
                barHelperConfig!!.onBackListener?.let {
                    it.onBackClick()
                }
            }

            //标题栏信息
            val toolbarTitle = fragmentView.findViewById<TextView>(R.id.toolbar_title)
            toolbarTitle.setTextColor(
                if (it.titleColor == 0) ContextCompat.getColor(
                    activity,
                    R.color.theme_black_7f
                ) else ContextCompat.getColor(activity, it.titleColor)
            )

            //标题位置
            val relativeLayout = toolbarTitle.layoutParams as RelativeLayout.LayoutParams
            when (it.titleGravity) {
                Gravity.LEFT -> {
                    relativeLayout.addRule(RelativeLayout.RIGHT_OF, R.id.toolbar_id)
                }
                Gravity.CENTER -> {
                    relativeLayout.addRule(RelativeLayout.CENTER_IN_PARENT)

                }
            }

            //标题内容
            toolbarTitle.text = it.title ?: ""
            fragmentView.findViewById<View>(R.id.toolbar_view_line).visibility =
                if (it.title == null || it.title == "") View.GONE else View.VISIBLE

            //左边图标
            if (it.back) {
                activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                toolbarId.setNavigationIcon(if (it.iconLeft == 0) R.drawable.return_left_back else it.iconLeft)
            } else {
                activity.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }

            //右边icon
            if (it.iconRight > 0) {
                val toolbarIvRight =
                    fragmentView.findViewById<ImageView>(R.id.toolbar_iv_right)
                toolbarIvRight.isVisible = true
                toolbarIvRight.setBackgroundResource(it.iconRight)
                toolbarIvRight.setOnClickListener {
                    barHelperConfig!!.onNextListener?.let {
                        it.onNextClick()
                    }
                }
            }

            //右边标题
            if (it.rightText != null) {
                val toolbarTvRightTitle =
                    fragmentView.findViewById<View>(R.id.toolbar_tv_right_title) as TextView
                toolbarTvRightTitle.text = it.rightText
                toolbarTvRightTitle.isVisible = true
                toolbarTvRightTitle.setTextColor(
                    ContextCompat.getColor(
                        activity,
                        it.rightTextColor
                    )
                )
                toolbarTvRightTitle.setOnClickListener {
                    barHelperConfig!!.onNextListener?.let {
                        it.onNextClick()
                    }
                }
            }


            val toolbarLlRoot =
                fragmentView.findViewById<View>(R.id.toolbar_ll_root) as LinearLayout
            //背景色
            toolbarLlRoot.setBackgroundResource(if (it.bgColor == 0) R.drawable.common_toolbar_br_shape_bg else it.bgColor)
        }
    }


    //activity
    private fun isActivity() {
        barHelperConfig?.let {
            var activity = it.activity!!
            activity.findViewById<View>(R.id.toolbar_id) ?: return
            val toolbarId: Toolbar = activity.findViewById(R.id.toolbar_id)
            toolbarId.title = ""
            activity.setSupportActionBar(toolbarId)
            activity.supportActionBar!!.setDisplayShowTitleEnabled(false)
            toolbarId.setNavigationOnClickListener {
                barHelperConfig!!.onBackListener?.let {
                    it.onBackClick()
                }
            }

            //标题栏信息
            val toolbarTitle = activity.findViewById<TextView>(R.id.toolbar_title)
            toolbarTitle.setTextColor(
                if (it.titleColor == 0) ContextCompat.getColor(
                    activity,
                    R.color.theme_black_7f
                ) else ContextCompat.getColor(activity, it.titleColor)
            )

            //标题位置
            val relativeLayout = toolbarTitle.layoutParams as RelativeLayout.LayoutParams
            when (it.titleGravity) {
                Gravity.LEFT -> {
                    relativeLayout.addRule(RelativeLayout.RIGHT_OF, R.id.toolbar_id)
                }
                Gravity.CENTER -> {
                    relativeLayout.addRule(RelativeLayout.CENTER_IN_PARENT)

                }
            }

            //标题内容
            toolbarTitle.text = it.title ?: ""
            activity.findViewById<View>(R.id.toolbar_view_line).visibility =
                if (it.title == null || it.title == "") View.GONE else View.VISIBLE

            //左边图标
            if (it.back) {
                activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                toolbarId.setNavigationIcon(if (it.iconLeft == 0) R.drawable.return_left_back else it.iconLeft)
            } else {
                activity.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }

            //右边icon
            if (it.iconRight > 0) {
                val toolbarIvRight =
                    activity.findViewById<ImageView>(R.id.toolbar_iv_right)
                toolbarIvRight.isVisible = true
                toolbarIvRight.setBackgroundResource(it.iconRight)
                toolbarIvRight.setOnClickListener {
                    barHelperConfig!!.onNextListener?.let {
                        it.onNextClick()
                    }
                }
            }

            //右边标题
            if (it.rightText != null) {
                val toolbarTvRightTitle =
                    activity.findViewById<View>(R.id.toolbar_tv_right_title) as TextView
                toolbarTvRightTitle.text = it.rightText
                toolbarTvRightTitle.isVisible = true
                toolbarTvRightTitle.setTextColor(
                    ContextCompat.getColor(
                        activity,
                        it.rightTextColor
                    )
                )
                toolbarTvRightTitle.setOnClickListener {
                    barHelperConfig!!.onNextListener?.let {
                        it.onNextClick()
                    }
                }
            }

            val toolbarLlRoot =
                activity.findViewById<View>(R.id.toolbar_ll_root) as LinearLayout
            //背景色
            toolbarLlRoot.setBackgroundResource(if (it.bgColor == 0) R.drawable.common_toolbar_br_shape_bg else it.bgColor)
        }
    }
}

class ToolBarHelperUtilBuilder {

    private val config: ToolBarHelperUtil = ToolBarHelperUtil()

    fun setBarHelperConfig(barHelperConfig: BarHelperConfig): ToolBarHelperUtilBuilder {
        config.barHelperConfig = barHelperConfig
        return this
    }

    fun setImmersionBarConfig(immersionBarConfig: ImmersionBarConfig?): ToolBarHelperUtilBuilder {
        config.immersionBarConfig = immersionBarConfig
        return this
    }

    fun onDestroyImmersion() {
        config.getImmersionBar()
    }

    fun build(): ToolBarHelperUtil = config

}
