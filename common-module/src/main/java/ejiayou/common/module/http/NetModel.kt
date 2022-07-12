package ejiayou.common.http

import io.reactivex.Observable
import java.util.HashMap

/**
 * @author:
 * @created on: 2022/7/7 17:12
 * @description:
 */
class NetModel private constructor() {

    //封装所有的请求参数成requestbody
    fun search(q: String): Observable<HttpResult<List<MusicBean>>> {
        val map: MutableMap<String, String> = HashMap()
        map["q"] = q
        return RetrofitFactory2.createGson(NetWorkTask::class.java).search()
    }
    companion object {
        private var netModel: NetModel? = null
        const val url = "https://api.douban.com/"
        val instance: NetModel?
            get() {
                if (netModel == null) {
                    netModel = NetModel()
                }
                return netModel
            }
    }
}
