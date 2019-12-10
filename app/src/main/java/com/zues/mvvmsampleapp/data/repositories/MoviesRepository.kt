package com.zues.mvvmsampleapp.data.repositories

import com.zues.mvvmsampleapp.data.network.MyApi
import com.zues.mvvmsampleapp.data.network.SafeApiRequest

/* ---  Created by akhtarz on 12/9/2019. ---*/
class MoviesRepository(private val api: MyApi) : SafeApiRequest() {

    suspend fun getListOfMovies() =
        apiRequest {
            api.getMovies()
        }

}