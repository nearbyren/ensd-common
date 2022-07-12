package ejiayou.common.http

import io.reactivex.Observable
import retrofit2.http.POST

/**
 * @author:
 * @created on: 2022/7/7 17:08
 * @description:
 */
open interface NetWorkTask {

    @POST("v2/music/search")
    fun search(): Observable<HttpResult<List<MusicBean>>>

}