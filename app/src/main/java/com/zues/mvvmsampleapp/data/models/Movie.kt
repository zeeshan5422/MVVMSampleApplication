package com.zues.mvvmsampleapp.data.models

/* ---  Created by akhtarz on 12/9/2019. ---*/

data class Movie(
    val id: Int,
    val image: String,
    val is_new: Int,
    val language: String,
    val like_percent: Int,
    val rating: String,
    val title: String,
    val type: String,
    val vote_count: Int
) {
}