package ejiayou.common.http

/**
 * @author:
 * @created on: 2022/7/7 16:19
 * @description:
 */
open interface ResponseCallBack<T> {
    /**
     * 请求开始
     *
     * @param action
     */
    fun onDataStart(action: Int)

    /**
     * 响应反馈的信息
     * @param message
     */
    fun onToast(message: String?)

    /**
     * 请求结果
     *
     * @param from 指定是哪个动作请求
     * @param results 响应的结果集
     */
    fun onDataSuccess(from: Int, results: Any?)

    /**
     * 请求结果
     * @param from 指定是哪个动作请求
     * @param error 响应失败的信息
     */
    fun onDataFailure(from: Int, error: String?)
}
