package com.zues.mvvmsampleapp.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.zues.mvvmsampleapp.utils.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

/* ---  Created by akhtarz on 12/5/2019. ---*/
class NetworkConnectionInterceptor(context: Context) : Interceptor {

    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable()) {
            throw NoInternetException("Internet is not available")
        }
        return chain.proceed(chain.request())
    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }
}