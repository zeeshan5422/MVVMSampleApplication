package com.zues.mvvmsampleapp.data.network

import com.zues.mvvmsampleapp.data.models.Movie
import com.zues.mvvmsampleapp.data.network.responses.AuthResponse
import com.zues.mvvmsampleapp.data.network.responses.QuotesResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/* ---  Created by akhtarz on 12/4/2019. ---*/
interface MyApi {

    @FormUrlEncoded
    @POST("mvvm/login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>


    @FormUrlEncoded
    @POST("mvvm/signup")
    suspend fun userSignup(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>

    @GET("mvvm/quotes")
    suspend fun getQuotes(): Response<QuotesResponse>

    @GET("recyclerview/movies")
    suspend fun getMovies(): Response<List<Movie>>

    companion object {
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor): MyApi {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }


}