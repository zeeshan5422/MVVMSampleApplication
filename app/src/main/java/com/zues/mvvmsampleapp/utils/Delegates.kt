package com.zues.mvvmsampleapp.utils

import kotlinx.coroutines.*

/* ---  Created by akhtarz on 12/6/2019. ---*/


fun <T> lazyDeferred(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}