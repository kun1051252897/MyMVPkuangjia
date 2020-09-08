package com.example.lib_core.http.observer

import io.reactivex.observers.DisposableObserver

//观察者
abstract class BaseObserver<T> : DisposableObserver<T>(), IObserver<T> {
    override fun onNext(t: T) {
        success(t)
    }

    override fun onError(e: Throwable) {
        error(e.message)
    }

    override fun onComplete() {}
}