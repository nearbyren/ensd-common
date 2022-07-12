package ejiayou.common.http

/**
 * @author:
 * @created on: 2022/7/7 15:56
 * @description:
 */
class HttpResult< T> {

    var status: Int = 0

    var code: Int = 0

    var message: String? = null


    var data:  T? = null
}