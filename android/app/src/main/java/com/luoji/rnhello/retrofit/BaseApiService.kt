package com.luoji.rnhello.retrofit

import com.luoji.rnhello.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Author:Ace
 * Date:On 2022/1/12
 */
interface BaseApiService {

    companion object{
        fun <T> createApi(serviceClass:Class<T>):T{
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient().newBuilder().addInterceptor(logger).build()
            return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(serviceClass)
        }
    }
}