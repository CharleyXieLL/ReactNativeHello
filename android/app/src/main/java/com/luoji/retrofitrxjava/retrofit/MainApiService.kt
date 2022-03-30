package com.luoji.retrofitrxjava.retrofit

import com.luoji.httpsdata.ResponseBean
import com.luoji.retrofitrxjava.BuildConfig
import com.luoji.retrofitrxjava.bean.SendVerifyResponseBean
import com.luoji.retrofitrxjava.main.bean.WaterVolumeBean
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
interface MainApiService {

    @GET("vehicle/cup-drink-volume-logs/no-login/app/drinkVolumeCount")
    suspend fun getWaterList(@Query("deviceId") deviceId:String,@Query("type") type:Int): ResponseBean<WaterVolumeBean>

    @POST("verifyCode/login/send")
    suspend fun sendVerifyCode(@Body body:RequestBody):ResponseBean<SendVerifyResponseBean>


}
