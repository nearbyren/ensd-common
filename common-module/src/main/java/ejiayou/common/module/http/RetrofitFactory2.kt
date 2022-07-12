package ejiayou.common.http

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * @author:
 * @created on: 2022/7/7 17:17
 * @description:
 */
class RetrofitFactory2 {
    companion object {


        private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                .build()

        //特殊数据加密
        fun <T> createString(clazz: Class<T>): T {
            return Retrofit.Builder()
                    .baseUrl(getBaseUrl(clazz))
                    // 添加String转换器
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                    .create(clazz)
        }

        //普通json
        fun <T> createGson(clazz: Class<T>): T {
            return Retrofit.Builder()
                    .baseUrl(getBaseUrl(clazz))
                    // 添加Gson转换器
                    .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()
                    .create(clazz)
        }


        private fun <T> getBaseUrl(clazz: Class<T>): String {
            return "http://upload.ejiayou.com"
        }
    }
}