package com.zues.mvvmsampleapp.ui.home.movies

import android.view.View
import com.zues.mvvmsampleapp.data.models.Movie

/* ---  Created by akhtarz on 12/10/2019. ---*/
interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: Movie)
}