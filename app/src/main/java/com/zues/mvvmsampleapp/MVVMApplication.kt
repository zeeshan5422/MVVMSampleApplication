package com.zues.mvvmsampleapp

import android.app.Application
import com.zues.mvvmsampleapp.data.db.AppDatabase
import com.zues.mvvmsampleapp.data.network.MyApi
import com.zues.mvvmsampleapp.data.network.NetworkConnectionInterceptor
import com.zues.mvvmsampleapp.data.preferences.PreferenceProvider
import com.zues.mvvmsampleapp.data.repositories.MoviesRepository
import com.zues.mvvmsampleapp.data.repositories.QuotesRepository
import com.zues.mvvmsampleapp.data.repositories.UserRepository
import com.zues.mvvmsampleapp.ui.auth.AuthViewModelFactory
import com.zues.mvvmsampleapp.ui.home.movies.MoviesViewModelFactory
import com.zues.mvvmsampleapp.ui.home.profile.ProfileViewModelFactory
import com.zues.mvvmsampleapp.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/* ---  Created by akhtarz on 12/5/2019. ---*/
class MVVMApplication() : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from singleton { MoviesRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }
        bind() from provider { MoviesViewModelFactory(instance()) }
    }

}