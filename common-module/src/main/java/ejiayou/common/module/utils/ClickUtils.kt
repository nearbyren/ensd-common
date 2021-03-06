package ejiayou.common.module.utils

/**
 * @description: 点击限制的工具类
 * @since: 1.0.0
 */
class ClickUtils private constructor() {
    private val SINGLE_INTERVAL = 400L
    private var lastClickTime: Long

    companion object {

        @JvmStatic
        fun getInstance(): ClickUtils {
            return SingletonHolder.holder
        }
    }

    private object SingletonHolder {
        val holder = ClickUtils()
    }

    init {
        lastClickTime = System.currentTimeMillis() - (1 + SINGLE_INTERVAL)
    }

    fun isNoFastClick(): Boolean {
        val t = System.currentTimeMillis()
        if (Math.abs(t - lastClickTime) > SINGLE_INTERVAL) {
            lastClickTime = t
            return true
        }
        return false
    }
}