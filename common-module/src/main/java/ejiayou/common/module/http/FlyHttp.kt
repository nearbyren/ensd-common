package ejiayou.common.module.http

import android.content.Context
import com.google.gson.Gson
import ejiayou.common.module.api.HttpClient
import ejiayou.common.module.api.HttpClientConfig
import ejiayou.common.module.api.interceptor.HttpLoggingInterceptor
import ejiayou.common.module.api.response.ResponseHolder
import ejiayou.common.module.utils.LogUtils
import okhttp3.Cache
import java.io.File
import java.lang.reflect.Type

/**
 * @author: Albert Li
 * @contact: albertlii@163.com
 * @time: 2021/3/19 8:10 PM
 * @description: -
 * @since: 1.0.0
 */
class FlyHttp {
    private val httClient by lazy { HttpClient() }
    private val LOG_TAG = "FlyHttp>>>"
    private val LOG_DIVIDER = "||================================================================="

    companion object {

        @Volatile
        private var instance: FlyHttp? = null

        @JvmStatic
        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FlyHttp().also { instance = it }
            }
    }


    fun init(context: Context) {
        val config = HttpClientConfig.builder()
                .setBaseUrl("https://api.ejiayou.com/gateway/ejy-portal-service/")
                .setCache(
                    Cache(
                        File(context.cacheDir.toString() + "FlyHttpCache"),
                        1024L * 1024 * 100
                    )
                )
                .openLog(true)
                .setGson(Gson())
                .setLogger(object : HttpLoggingInterceptor.Logger {
                    override fun log(message: String) {
                        if (message.contains("--> END") || message.contains("<-- END")) {
                            LogUtils.e(LOG_TAG, "||  " + message)
                            LogUtils.e(LOG_TAG, LOG_DIVIDER)
                        } else if (message.contains("-->") || message.contains("<--")) {
                            LogUtils.e(LOG_TAG, LOG_DIVIDER)
                            LogUtils.e(LOG_TAG, "||  " + message)
                        } else {
                            LogUtils.e(LOG_TAG, "||  " + message)
                        }
                    }
                })
                .setHeaders(mapOf(Pair("MyDevice", "1")))
                .build()
        httClient.init(context, config)
    }

    fun getClient(): HttpClient {
        return httClient
    }

    @JvmOverloads
    suspend fun <T> get(
        url: String,
        headers: Map<String, String>? = null,
        params: Map<String, String>? = null,
        type: Type,
        isInfoResponse: Boolean = true,
    ): ResponseHolder<T> = httClient.get(url, headers, params, type, isInfoResponse)

    @JvmOverloads
    suspend fun <T> post(
        url: String,
        headers: Map<String, String>? = null,
        params: Map<String, String>? = null,
        type: Type,
        isInfoResponse: Boolean = true,
    ): ResponseHolder<T> = httClient.postJson(url, headers, params, type, isInfoResponse)
}