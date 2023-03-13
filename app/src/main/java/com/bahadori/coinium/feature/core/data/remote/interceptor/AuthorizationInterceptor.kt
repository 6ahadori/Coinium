package com.bahadori.coinium.feature.core.data.remote.interceptor

import com.bahadori.coinium.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
            .addHeader("Accept", "application/json, text/plain, */*")
            .addHeader("Authorization", "Apikey ${BuildConfig.API_KEY}")

        return chain.proceed(builder.build())
    }
}