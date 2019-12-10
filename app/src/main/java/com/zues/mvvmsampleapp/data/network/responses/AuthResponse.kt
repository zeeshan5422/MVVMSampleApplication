package com.zues.mvvmsampleapp.data.network.responses

import com.zues.mvvmsampleapp.data.db.entities.User

/* ---  Created by akhtarz on 12/4/2019. ---*/
data class AuthResponse (val isSuccessful: Boolean?,
                         val message: String?,
                         val user: User?)