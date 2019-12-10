package com.zues.mvvmsampleapp.ui.home.profile

import androidx.lifecycle.ViewModel
import com.zues.mvvmsampleapp.data.repositories.UserRepository

class ProfileViewModel (repository: UserRepository) : ViewModel() {

    val user = repository.getUser()
}
