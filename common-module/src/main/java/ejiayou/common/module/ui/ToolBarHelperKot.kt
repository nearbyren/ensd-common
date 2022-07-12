package ejiayou.common.ui

import android.graphics.Typeface
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.orhanobut.logger.Logger
import ejiayou.common.module.R
import ejiayou.common.module.view.empty.PageStateLayout

class ToolBarHelperKot @JvmOverloads constructor(builder: Builder) {

    var activity: BaseActivityKot
    var onBackListener: OnBackListener
    var onNextListener: OnNextListener? = null
    var onEmptyListener: OnEmptyListener? = null
    var onErrorListener: OnErrorListener? = null
    var fragmentView: View? = null
    var title: String? = null
    var titleColor: Int = 0
    var backgroundColor: Int = 0
    var titlePosition: Int = 0
    var iconLeft: Int = 0
    var isBack: Boolean = false
    var iconRight: Int = 0
    var fontTypeStr: String? = null
    var rightText: String? = null
    var rightTextColor: Int = 0
    var layout: Int = 0
    var parent: ViewGroup? = null
    var content: View? = null
    var pageStateLayout: PageStateLayout? = null
    var statusBarType: Int = 0


    interface OnEmptyListener {
        fun onEmptyClick()
    }

    interface OnErrorListener {
        fun onOnErrorClick()
    }

    interface OnBackListener {
        fun onBackClick()
    }

    interface OnNextListener {
        fun onNextClick()
    }

    //初始化基本数据
    class Builder {
        lateinit var activity: BaseActivityKot
        var onBackListener: OnBackListener? = null
        var onNextListener: OnNextListener? = null
        var onEmptyListener: OnEmptyListener? = null
        var onErrorListener: OnErrorListener? = null
        var fragmentView: View? = null
        var title: String? = null
        var titleColor = 0
        var backgroundColor = 0
        var titlePosition = 1
        var fontTypeStr: String? = null
        var iconLeft = 0
        var isBack = false
        var iconRight = 0
        var rightText: String? = null
        var rightTextColor = 0
        var statusBarTintResource = 0
        var layout = 0
        var parent: ViewGroup? = null
        var content: View? = null
        var pageStateLayout: PageStateLayout? = null
        var statusBarType = 0

        constructor() {}
        constructor(activity: BaseActivityKot) {
            //默认初始化方法
            this.activity = activity;
        }

        fun onLoading(): Builder {
            Logger.d(if (pageStateLayout == null) "pageStateLayout - 1 " else "pageStateLayout - 2")
            if (pageStateLayout != null) {
                pageStateLayout!!.onLoading()
            }
            return this
        }

        fun onRequesting(): Builder {
            if (pageStateLayout != null) {
                pageStateLayout!!.onRequesting()
            }
            return this
        }

        fun onEmpty(): Builder {
            if (pageStateLayout != null) {
                pageStateLayout!!.onEmpty()
            }
            return this
        }

        fun onError(): Builder {
            if (pageStateLayout != null) {
                pageStateLayout!!.onError()
            }
            return this
        }

        fun onSucceed(): Builder {
            if (pageStateLayout != null) {
                pageStateLayout!!.onSucceed()
            }
            return this
        }

        fun setPageStateLayout(
            parent: ViewGroup?,
            content: View?,
            pageStateLayout: PageStateLayout?
        ): Builder {
            this.parent = parent
            this.content = content
            this.pageStateLayout = pageStateLayout
            return this
        }

        fun setPageStateLayout(layout: Int, pageStateLayout: PageStateLayout?): Builder {
            this.layout = layout
            this.pageStateLayout = pageStateLayout
            return this
        }

        fun setOnBackListener(onBackListener: BaseActivityKot): Builder {
            this.onBackListener = onBackListener
            return this
        }

        fun setOnNextListener(onNextListener: OnNextListener?): Builder {
            this.onNextListener = onNextListener
            return this
        }

        fun setonEmptyListener(onEmptyListener: OnEmptyListener?): Builder {
            this.onEmptyListener = onEmptyListener
            return this
        }

        fun setonErrorListener(onErrorListener: OnErrorListener?): Builder {
            this.onErrorListener = onErrorListener
            return this
        }

        fun setStatusBarType(statusBarType: Int): Builder {
            this.statusBarType = statusBarType
            return this
        }

        fun setFragmentView(fragmentView: View?): Builder {
            this.fragmentView = fragmentView
            return this
        }

        fun setTitle(title: String?): Builder {
            this.title = title
            return this
        }

        fun setTitleColor(titleColor: Int): Builder {
            this.titleColor = titleColor
            return this
        }

        fun setBackgroundColor(backgroundColor: Int): Builder {
            this.backgroundColor = backgroundColor
            return this
        }

        fun setTitlePosition(titlePosition: Int): Builder {
            this.titlePosition = titlePosition
            return this
        }

        fun setFontTypeStr(fontTypeStr: String?): Builder {
            this.fontTypeStr = fontTypeStr
            return this
        }

        fun setIconLeft(iconLeft: Int): Builder {
            this.iconLeft = iconLeft
            return this
        }

        fun setBack(back: Boolean): Builder {
            isBack = back
            return this
        }

        fun setIconRight(iconRight: Int): Builder {
            this.iconRight = iconRight
            return this
        }

        fun setIsRightText(rightText: String?): Builder {
            this.rightText = rightText
            return this
        }

        fun setIsRightTextColor(rightTextColor: Int): Builder {
            this.rightTextColor = rightTextColor
            return this
        }

        fun setStatusBarTintResource(statusBarTintResource: Int): Builder {
            this.statusBarTintResource = statusBarTintResource
            return this
        }

        fun build(): ToolBarHelperKot {
            return ToolBarHelperKot(this)
        }
    }

    init {
        activity = builder.activity
        onBackListener = builder.onBackListener!!
        fragmentView = builder.fragmentView
        title = builder.title
        titleColor = builder.titleColor
        backgroundColor = builder.backgroundColor
        titlePosition = builder.titlePosition
        iconLeft = builder.iconLeft
        isBack = builder.isBack
        iconRight = builder.iconRight
        fontTypeStr = builder.fontTypeStr
        rightText = builder.rightText
        rightTextColor = builder.rightTextColor
        layout = builder.layout
        parent = builder.parent
        content = builder.content
        pageStateLayout = builder.pageStateLayout
        statusBarType = builder.statusBarType
    }

    /**
     * @param activity        Activity界面
     * @param onBackListener  是否开启左边点击事件
     * @param onNextListener  是否开启右边点击事件
     * @param view            Fragment
     * @param title           标题内容
     * @param titleColor      标题颜色
     * @param backgroundColor 标题栏背景色
     * @param titlePosition   标题显示的位置
     * @param iconLeft        是否更新左边按钮图标
     * @param isBack          是否开启左边点击事件
     * @param iconRight       是否更新右边按钮图标
     * @param fontTypeStr     标题字体类型
     * @param rightText       是否设置右边字体
     * @param rightTextColor  是否设置右边字体颜色
     */
    init {
        activity?.let {
            it
            backgroundColor =if (backgroundColor == 0) R.color.white else backgroundColor
            fragmentView?.let {
                fragmentView()
            } ?: isActivity()
        }
    }

    private fun isActivity() {
        if (layout != 0) { //网络加载错误隐藏全屏幕布局
            val stateview = LayoutInflater.from(activity).inflate(layout, null)
            pageStateLayout!!.setOnEmptyListener { onEmptyListener!!.onEmptyClick() }
                    .setOnErrorListener { onErrorListener!!.onOnErrorClick() }
                    .load(activity!!, stateview)
        } else { //指定被隐藏的布局
            pageStateLayout?.setOnEmptyListener { onEmptyListener!!.onEmptyClick() }
                    ?.setOnErrorListener { onErrorListener!!.onOnErrorClick() }
                    ?.load(parent!!, content!!)
        }
        val ensdToolbarId = activity!!.findViewById<View>(R.id.ensd_toolbar_id) as Toolbar
        if (ensdToolbarId != null) {
            ensdToolbarId.title = ""
            activity.setSupportActionBar(ensdToolbarId)
            activity.supportActionBar!!.setDisplayShowTitleEnabled(false)
            ensdToolbarId.setNavigationOnClickListener { onBackListener!!.onBackClick() }

            //标题栏信息
            val ensdToolbarTitle =
                activity.findViewById<View>(R.id.ensd_toolbar_title) as TextView
            ensdToolbarTitle.setTextColor(
                if (titleColor == 0) ContextCompat.getColor(
                    activity,
                    R.color.theme_black_7f
                ) else ContextCompat.getColor(activity, titleColor)
            )
            val ensdRlTitle = activity.findViewById<View>(R.id.ensd_rl_title) as RelativeLayout
            val ensdToolbarBg = activity.findViewById<View>(R.id.ensd_toolbar_bg) as LinearLayout
            val lp = Toolbar.LayoutParams(
                Toolbar.LayoutParams.MATCH_PARENT,
                Toolbar.LayoutParams.WRAP_CONTENT
            )
            //标题栏位置
            if (titlePosition == 0) {
                ensdRlTitle.gravity = Gravity.LEFT
                ensdRlTitle.layoutParams = lp
            }
            //标题内容
            ensdToolbarTitle.text = title ?: ""
            activity.findViewById<View>(R.id.ensd_toolbar_view_line).visibility =
                if (title == null || title == "") View.GONE else View.VISIBLE
            //标题栏字体类型
            if (fontTypeStr != null) { //字体类型
                val toolbar_tv_title_bttom =
                    activity.findViewById<View>(R.id.toolbar_tv_title_bttom) as TextView
                toolbar_tv_title_bttom.visibility = View.VISIBLE
                val face2 = Typeface.createFromAsset(
                    activity.assets,  /*fontTypeStr*/
                    "fonts/hwcy.ttf"
                )
                toolbar_tv_title_bttom.setTypeface(face2)
                val face = Typeface.createFromAsset(
                    activity.assets,  /*fontTypeStr*/
                    "fonts/hwcy.ttf"
                )
                ensdToolbarTitle.setTypeface(face)
            }


            //左边图标
            if (isBack) {
                activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                ensdToolbarId.setNavigationIcon(if (iconLeft == 0) R.drawable.ensd_return_left_black else iconLeft)
            } else {
                activity.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }
            //右边图标
            if (iconRight != 0 && rightText == null) {
                val ensdToolbarIvRight =
                    activity.findViewById<View>(R.id.ensd_toolbar_iv_right) as ImageView
                ensdToolbarIvRight.visibility = View.VISIBLE
                ensdToolbarIvRight.setBackgroundResource(iconRight)
                ensdToolbarIvRight.setOnClickListener { onNextListener!!.onNextClick() }
            }
            //右边字体
            if (iconRight == 0 && rightText != null) {
                val ensdToolbarTvRightTitle =
                    activity.findViewById<View>(R.id.ensd_toolbar_tv_right_title) as TextView
                ensdToolbarTvRightTitle.text = rightText
                ensdToolbarTvRightTitle.visibility = View.VISIBLE
                ensdToolbarTvRightTitle.setTextColor(ContextCompat.getColor(activity, rightTextColor))
                ensdToolbarTvRightTitle.setOnClickListener { onNextListener!!.onNextClick() }
            }
            //背景色
            ensdToolbarBg.setBackgroundResource(if (backgroundColor == 0) R.drawable.ensd_toolbar_br else backgroundColor)
        }
    }

    private fun fragmentView() {
        val ensdToolbarId: Toolbar = fragmentView!!.findViewById(R.id.ensd_toolbar_id)
        ensdToolbarId.title = ""
        activity!!.setSupportActionBar(ensdToolbarId)
        activity.supportActionBar!!.setDisplayShowTitleEnabled(false)
        ensdToolbarId.setNavigationOnClickListener { onBackListener!!.onBackClick() }

        //标题栏信息
        val ensdToolbarTitle = fragmentView!!.findViewById<TextView>(R.id.ensd_toolbar_title)
        ensdToolbarTitle.setTextColor(
            if (titleColor == 0) ContextCompat.getColor(
                activity,
                R.color.theme_black_7f
            ) else ContextCompat.getColor(activity, titleColor)
        )
        val ensdRlTitle = fragmentView!!.findViewById<RelativeLayout>(R.id.ensd_rl_title)
        val ensdToolbarBg = fragmentView!!.findViewById<View>(R.id.ensd_toolbar_bg) as LinearLayout
        val lp = Toolbar.LayoutParams(
            Toolbar.LayoutParams.MATCH_PARENT,
            Toolbar.LayoutParams.WRAP_CONTENT
        )
        //标题栏位置
        if (titlePosition == 0) {
            ensdRlTitle.gravity = Gravity.LEFT
            ensdRlTitle.layoutParams = lp
        }
        //标题内容
        ensdToolbarTitle.text = title ?: ""
        fragmentView!!.findViewById<View>(R.id.ensd_toolbar_view_line).visibility =
            if (title == null || title == "") View.GONE else View.VISIBLE
        //标题栏字体类型
        if (fontTypeStr != null) { //字体类型
            val toolbar_tv_title_bttom =
                fragmentView!!.findViewById<TextView>(R.id.toolbar_tv_title_bttom)
            toolbar_tv_title_bttom.visibility = View.VISIBLE
            val face2 = Typeface.createFromAsset(
                activity.assets,  /*fontTypeStr*/
                "fonts/hwcy.ttf"
            )
            toolbar_tv_title_bttom.setTypeface(face2)
            val face = Typeface.createFromAsset(
                activity.assets,  /*fontTypeStr*/
                "fonts/hwcy.ttf"
            )
            ensdToolbarTitle.setTypeface(face)
        }


        //左边图标
        if (isBack) {
            activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            ensdToolbarId.setNavigationIcon(if (iconLeft == 0) R.drawable.ensd_return_left_black else iconLeft)
        } else {
            activity.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        }

        //右边图标
        if (iconRight != 0 && rightText == null) {
            val ensdToolbarIvRight =
                fragmentView!!.findViewById<ImageView>(R.id.ensd_toolbar_iv_right)
            ensdToolbarIvRight.visibility = View.VISIBLE
            ensdToolbarIvRight.setBackgroundResource(iconRight)
            ensdToolbarIvRight.setOnClickListener { onNextListener!!.onNextClick() }
        }
        //右边字体
        if (iconRight == 0 && rightText != null) {
            val ensdToolbarTvRightTitle =
                fragmentView!!.findViewById<View>(R.id.ensd_toolbar_tv_right_title) as TextView
            ensdToolbarTvRightTitle.text = rightText
            ensdToolbarTvRightTitle.visibility = View.VISIBLE
            ensdToolbarTvRightTitle.setTextColor(
                ContextCompat.getColor(
                    activity,
                    rightTextColor
                )
            )
            ensdToolbarTvRightTitle.setOnClickListener { onNextListener!!.onNextClick() }
        }
        //背景色
        ensdToolbarBg.setBackgroundResource(if (backgroundColor == 0) R.drawable.ensd_toolbar_br else backgroundColor)
    }
}

