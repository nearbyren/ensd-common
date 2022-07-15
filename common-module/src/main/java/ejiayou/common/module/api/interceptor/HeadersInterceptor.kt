package ejiayou.common.module.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @description: 请求头部拦截器
 * @since: 1.0.0
 */
class HeadersInterceptor(private val headers: Map<String, String>) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        // Request customization: add request headers
        headers.forEach {
            requestBuilder.addHeader(it.key, it.value)
        }
        return chain.proceed(requestBuilder.build())
    }
}