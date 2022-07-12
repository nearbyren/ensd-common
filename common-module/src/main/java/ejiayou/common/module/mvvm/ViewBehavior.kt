package ejiayou.common.module.mvvm


interface ViewBehavior {
    /**
     * 是否显示Loading视图
     */
    fun showLoadingView(isShow: Boolean)

    /**
     * 是否显示空白视图
     */
    fun showEmptyView(isShow: Boolean)

    /**
     * 弹出Toast提示
     */
    fun showToast(event:ToastEvent)

    /**
     * 不带参数的页面跳转
     */
    fun navigate(page: Any)

    /**
     * 返回键点击
     */
    fun backPress(arg: Any?)

    /**
     * 关闭页面
     */
    fun finishPage(arg: Any?)
}