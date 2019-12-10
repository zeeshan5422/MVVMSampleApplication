package com.zues.mvvmsampleapp.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.zues.mvvmsampleapp.data.repositories.QuotesRepository
import com.zues.mvvmsampleapp.utils.lazyDeferred

class QuotesViewModel(repository: QuotesRepository) : ViewModel() {

    val quotes by lazyDeferred() {
        repository.getQuotes()
    }
}
