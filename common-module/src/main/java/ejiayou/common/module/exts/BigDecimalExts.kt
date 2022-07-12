package ejiayou.common.module.exts

import ejiayou.common.module.utils.NumberUtils
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * @author: Albert Li
 * @contact: albertlii@163.com
 * @time: 2020/10/27 3:26 PM
 * @description: BigDeciaml相关扩展
 * @since: 1.0.0
 */

/**
 * 加法运算
 */
fun BigDecimal.numPlus(
    v: String?,
    precision: Int? = null,
    mode: RoundingMode = RoundingMode.FLOOR
): BigDecimal {
    return NumberUtils.plus(this.toString(), v, precision, mode)
}

/**
 * 减法运算
 */
fun BigDecimal.numMinus(
    v: String?,
    precision: Int? = null,
    mode: RoundingMode = RoundingMode.FLOOR
): BigDecimal {
    return NumberUtils.minus(this.toString(), v, precision, mode)
}

/**
 * 乘法运算
 */
fun BigDecimal.numMultiply(
    v: String?,
    precision: Int? = null,
    mode: RoundingMode = RoundingMode.FLOOR
): BigDecimal {
    return NumberUtils.multiply(this.toString(), v, precision, mode)
}

/**
 * 除法运算
 */
fun BigDecimal.numDivide(
    v: String?,
    precision: Int? = null,
    mode: RoundingMode = RoundingMode.HALF_EVEN
): BigDecimal {
    return NumberUtils.divide(this.toString(), v, precision, mode)
}

/**
 * 是否为0
 */
fun BigDecimal.isZero(): Boolean {
    return this.compareTo(BigDecimal.ZERO) == 0
}