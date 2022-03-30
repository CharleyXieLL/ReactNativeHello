package com.luoji.retrofitrxjava.retrofit

import android.content.Context
import android.os.Build
import com.luoji.retrofitrxjava.BuildConfig
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception
import java.lang.StringBuilder
import java.nio.charset.Charset
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

/**
 * Author:Ace
 * Date:On 2022/1/14
 */
class CommonRequestHeaderInterceptor(var context:Context):Interceptor {

    companion object{
        val UTF8: Charset = Charset.forName("UTF-8")
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBody = request.body
        var body:String?=null
        if (requestBody != null) {
            val buffer = Buffer()
            requestBody.writeTo(buffer)
            var charset: Charset = UTF8
            val contentType: MediaType? = requestBody.contentType()
            if (contentType != null) {
                charset = contentType.charset(UTF8)!!
            }
            body = buffer.readString(charset)
        }
        val builder: Request.Builder = request.newBuilder()
        try {
            //todo 增加自定义header
//            builder.addHeader("basicParams", genBasicParams(body))
            builder.addHeader("Accept-Language", getAcceptLanguage())
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return chain.proceed(builder.build())
    }

    private fun genBasicParams(body: String?):String{
        val time = System.currentTimeMillis()
        val versionName: String = BuildConfig.VERSION_NAME
        val versionCode: Int = BuildConfig.VERSION_CODE
        val imei: String = UUID.randomUUID().toString()
        val token = ""
        val netType = "wifi"
        val channel = "kotlin"
        val openId = UUID.randomUUID().toString()

        val basicJson = JSONObject()
        basicJson.put("appKey", "123456")
            .put("appVersion", versionName)
            .put("appClient", "android")
            .put("versionCode", versionCode)
            .put("timestamp", time)
            .put("guestId", imei)
            .put("token", token)
            .put("channel", channel)
            .put("openId", openId)
            .put("from", "cashloan")
            .put("clientId", "")
            .put("appCode", "0000002")
            .put("categoryCode", "lonaall")
            .put("net", netType)

        basicJson.put("horse", "sss")

        val signSB = StringBuilder()
        signSB.append("123456")
        signSB.append(versionName)
        signSB.append("android")
        signSB.append(versionCode)
        signSB.append(time)
        signSB.append(imei)
        signSB.append(token)
        signSB.append(body)

        signSB.append("460bd2ae05a0756a443b72778a9e96b9")

        val appSign: String = md5(md5(signSB.toString()))

        basicJson.put("appSign", appSign)
        return basicJson.toString()
    }

    private fun getAcceptLanguage(): String {
        try {
            var locale: Locale? = null
            locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                context.resources.configuration.locales.get(0)
            } else {
                context.resources.configuration.locale
            }
            val sb = StringBuilder()
            if (locale.country.isNotBlank()) {
                sb.append(locale.language).append("-").append(locale.country).append(",")
            }
            sb.append(locale.language).append(";q=0.8")
            return sb.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "en-US,en;q=0.8"
    }

    private fun md5(plainText: String): String {
        return try {
            val md = MessageDigest.getInstance("MD5")
            md.update(plainText.toByteArray())
            val b = md.digest()
            val buf = StringBuffer("")
            for (offset in b.indices) {
                var i = b[offset].toInt()
                if (i < 0) {
                    i += 256
                }
                if (i < 16) {
                    buf.append("0")
                }
                buf.append(Integer.toHexString(i))
            }
            buf.toString()
        } catch (exception: NoSuchAlgorithmException) {
            exception.printStackTrace()
            ""
        }
    }

}