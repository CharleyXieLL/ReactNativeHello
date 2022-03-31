package com.luoji.retrofitrxjava.retrofit.api

import com.luoji.httpsdata.ResponseBean
import com.luoji.retrofitrxjava.bean.HomeResponseBean
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
interface MainApiService {

    @POST("home")
    suspend fun getHome(): ResponseBean<HomeResponseBean>
}
