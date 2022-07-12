package ejiayou.common.http

import java.lang.RuntimeException

/**
 * @author:
 * @created on: 2022/7/7 16:42
 * @description:
 */

class ApiException(code_message: String?) : RuntimeException(code_message)