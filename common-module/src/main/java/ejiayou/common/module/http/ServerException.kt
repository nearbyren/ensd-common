package ejiayou.common.http

import java.lang.RuntimeException

/**
 * @author:
 * @created on: 2022/7/7 16:48
 * @description:
 */
class ServerException(code: Int, message: String?) : RuntimeException(message) {
    var code: Int

    init {
        this.code = code
    }
}
