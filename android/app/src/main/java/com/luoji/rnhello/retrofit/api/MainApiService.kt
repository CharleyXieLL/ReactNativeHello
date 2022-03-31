package com.luoji.rnhello.retrofit.api

import com.luoji.httpsdata.ResponseBean
import com.luoji.rnhello.bean.HomeResponseBean
import retrofit2.http.POST

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
interface MainApiService {

    @POST("home")
    suspend fun getHome(): ResponseBean<HomeResponseBean>
}
