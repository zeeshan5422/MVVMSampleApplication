package com.zues.mvvmsampleapp.ui.home.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zues.mvvmsampleapp.data.repositories.MoviesRepository

/* ---  Created by akhtarz on 12/9/2019. ---*/
@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(
    private val repository: MoviesRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T
    }
}