package com.example.lib_core.mvp.view

interface IView {
    fun showLoading()
    fun hideLoading()
    fun showMsg(msg: String?)
}