package com.example.lib_core.mvp.presenter

import com.example.lib_core.mvp.model.IModel
import com.example.lib_core.mvp.view.IView
import javax.inject.Inject

class BasePresenter<M : IModel?, V : IView?>(mModel: M, mView: V) : IPresenter {
    @JvmField
    @Inject
    var mModel: M?
    protected var mView: V?
    override fun onDestroy() {
        if (mModel != null) {
            mModel!!.onDestroy()
            mModel = null
        }
        if (mView != null) {
            mView = null
        }
    }

    init {
        this.mModel = mModel
        this.mView = mView
    }
}