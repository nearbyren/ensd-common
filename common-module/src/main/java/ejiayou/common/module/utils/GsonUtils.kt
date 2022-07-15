package ejiayou.common.module.utils

import com.google.gson.GsonBuilder
import java.lang.reflect.Type

/**
 * @description: Gson工具类
 * @since: 1.0.0
 */
object GsonUtils {

    private val gson = GsonBuilder().serializeNulls().disableHtmlEscaping().create()

    fun <T> fromJson(json: String?, type: Class<T>): T {
        return gson.fromJson(json, type)
    }

    fun <T> fromJson(json: String?, type: Type): T {
        return gson.fromJson(json, type)
    }

    fun toJson(src: Any?): String {
        return gson.toJson(src)
    }

    fun toJson(src: Any?, typeOfSrc: Type): String {
        return gson.toJson(src, typeOfSrc)
    }
}