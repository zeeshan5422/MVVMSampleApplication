package com.zues.mvvmsampleapp.ui.home.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zues.mvvmsampleapp.data.repositories.QuotesRepository
import com.zues.mvvmsampleapp.data.repositories.UserRepository

/* ---  Created by akhtarz on 12/5/2019. ---*/
@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory(private val repository: QuotesRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel (repository) as T
    }
}