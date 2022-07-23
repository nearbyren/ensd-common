package ejiayou.common.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import ejiayou.common.module.mvvm.ToastEvent
import ejiayou.common.module.mvvm.ViewBehavior
import ejiayou.common.module.ui.BarHelperConfig
import ejiayou.common.module.ui.ImmersionBarConfig
import ejiayou.common.module.utils.ToastUtils

abstract class BaseActivityKot : AppCompatActivity(), ViewBehavior {

    private lateinit var barHelper: ToolBarHelperUtilBuilder

    protected val simpleBaseName: String get() = javaClass.simpleName

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d("监听生命周期 - onCreate")
        ARouter.getInstance().inject(this)
        initIntent()
        initContentView()
        initViewHeader()
        initialize(savedInstanceState)

    }

    protected abstract fun initialize(savedInstanceState: Bundle?)

    protected open fun initContentView() {
        setContentView(layoutRes())
    }

    open fun initIntent() {
        Logger.d("监听生命周期 - initIntent")
    }

    override fun onStart() {
        super.onStart()
        Logger.d("监听生命周期 - onStart")
    }

    override fun onResume() {
        super.onResume()
        Logger.d("监听生命周期 - onResume")
    }

    override fun onPause() {
        super.onPause()
        Logger.d("监听生命周期 - onPause")
    }

    override fun onStop() {
        super.onStop()
        Logger.d("监听生命周期 - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.d("监听生命周期 - onDestroy")
        barHelper?.let {
            it.onDestroyImmersion()
        }
    }


    protected open fun initBarHelperConfig(): BarHelperConfig? {
        return BarHelperConfig.builder().build()

    }

    protected open fun initImmersionBarConfig(): ImmersionBarConfig? {
        return ImmersionBarConfig.builder().build()
    }


    private fun initViewHeader() {
        //标题栏适配器
        barHelper = ToolBarHelperUtil.builder()
        //沉浸式config
        var immersionBarConfig = initImmersionBarConfig()

        immersionBarConfig?.let {
            barHelper.setImmersionBarConfig(immersionBarConfig)
        }

        //标题栏config
        var barHelperConfig = initBarHelperConfig()

        barHelperConfig!!.activity = this

        barHelperConfig?.let {
            barHelper.setBarHelperConfig(barHelperConfig)
        }
        barHelper.build().init()

    }


    override fun getResources(): Resources {
        var resources = super.getResources()
        val newConfig = resources.configuration
        val displayMetrics = resources.displayMetrics
        if (resources != null && newConfig.fontScale != 1f) {
            newConfig.fontScale = 1f
            if (Build.VERSION.SDK_INT >= 17) {
                val configurationContext = createConfigurationContext(newConfig)
                resources = configurationContext.resources
                displayMetrics.scaledDensity = displayMetrics.density * newConfig.fontScale
            } else {
                resources.updateConfiguration(newConfig, displayMetrics)
            }
        }
        return resources
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun layoutViewGroup(): ViewGroup?

    protected abstract fun layoutView(): View?


    protected fun showToast(text: String, showLong: Boolean = false) {
        showToast(ToastEvent(content = text, showLong = showLong))
    }

    protected fun showToast(@StringRes resId: Int, showLong: Boolean = false) {
        showToast(ToastEvent(contentResId = resId, showLong = showLong))
    }

    override fun showToast(event: ToastEvent) {
        if (event.content != null) {
            ToastUtils.showToast(this, event.content!!, event.showLong)
        } else if (event.contentResId != null) {
            ToastUtils.showToast(this, getString(event.contentResId!!), event.showLong)
        }
    }

    override fun navigate(page: Any) {
        startActivity(Intent(this, page as Class<*>))
    }

    override fun backPress(arg: Any?) {
        onBackPressed()
    }

    override fun finishPage(arg: Any?) {
        finish()
    }


}
