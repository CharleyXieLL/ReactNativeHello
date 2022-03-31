/**
 * Author:Ace
 * Date:On 2022/1/5
 */
object Versions {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val applicationId = "com.luoji.reactdemo"
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 100
    const val versionName = "1.0.0"
    const val apkName = "android_start_retrofit"

    const val constraintlayout = "2.1.2"
    const val appcompat = "1.3.1"
    const val material = "1.4.0"
    const val core_ktx = "1.6.0"
    const val retrofit2 = "2.9.0"
    const val okhttp3 = "4.9.3"
    const val gson = "2.8.6"
    const val glide4 = "4.11.0"
    const val eventbus = "3.1.1"
    const val toastcompat_drakeet = "1.1.0"
    const val databinding = "3.1.4"
    const val kotlinx_coroutines = "1.4.1"
    const val kotlin_version = "1.5.30"

    const val livedata = "2.3.1"
    const val swiperefreshlayout = "1.1.0"

    const val react_native = "0.67.3"
}

object Libs {
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"

    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    const val retrofit2_converter_gson =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}"
    const val okhttp3_logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val glide4 = "com.github.bumptech.glide:glide:${Versions.glide4}"
    const val glide4_compiler = "com.github.bumptech.glide:compiler:${Versions.glide4}"

    const val eventbus = "org.greenrobot:eventbus:${Versions.eventbus}"

    const val toastcompat_drakeet = "me.drakeet.support:toastcompat:${Versions.toastcompat_drakeet}"
    const val databinding = "com.android.databinding:compiler:${Versions.databinding}"

    const val kotlinx_coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_coroutines}"

    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedata}"

    const val react_native = "com.facebook.react:react-native:+"
    const val android_jsc = "org.webkit:android-jsc:+"
    const val swiperrefresh_layout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
}