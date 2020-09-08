package com.example.lib_core.http.observer

interface IObserver<T> {
    fun success(bean: T)
    fun error(msg: String?)
}