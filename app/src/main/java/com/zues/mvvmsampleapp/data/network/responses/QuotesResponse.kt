package com.zues.mvvmsampleapp.data.network.responses

import com.zues.mvvmsampleapp.data.db.entities.Quote

/* ---  Created by akhtarz on 12/6/2019. ---*/
data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)