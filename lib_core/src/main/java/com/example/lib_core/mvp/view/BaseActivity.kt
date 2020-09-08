package com.example.lib_core.mvp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lib_core.mvp.presenter.IPresenter
import com.example.lib_core.widget.LoadingDialog
import javax.inject.Inject

abstract class BaseActivity<P : IPresenter?> : AppCompatActivity(), IActivity, IView {
    @JvmField
    @Inject
    var mPresenter: P? = null
    private var dialog: LoadingDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bandLayout())
        dialog = LoadingDialog(this)
        initView()
        initPresenter()
        initData()
    }

    override fun showLoading() {
        dialog!!.show()
    }

    override fun hideLoading() {
        dialog!!.hide()
    }

    override fun showMsg(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
            mPresenter?.onDestroy()
            mPresenter = null
    }
}