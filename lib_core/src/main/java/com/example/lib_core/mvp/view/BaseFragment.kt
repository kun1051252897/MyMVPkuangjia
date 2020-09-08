package com.example.lib_core.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lib_core.mvp.presenter.IPresenter
import com.example.lib_core.widget.LoadingDialog
import javax.inject.Inject

abstract class BaseFragment<P : IPresenter?> : Fragment(), IView, IFragment {
    @JvmField
    @Inject
    var mPresenter: P? = null
    private var mBaseView: View? = null
    private var dialog: LoadingDialog? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBaseView = inflater.inflate(bandLayout(), container, false)
        return mBaseView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog = LoadingDialog(context!!)
        initView()
        initPresenter()
        initData()
    }

    override fun <T : View?> findViewById(id: Int): T {
        return mBaseView!!.findViewById(id)
    }

    override fun showLoading() {
        dialog!!.show()
    }

    override fun hideLoading() {
        dialog!!.hide()
    }

    override fun showMsg(msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
            mPresenter?.onDestroy()
            mPresenter = null
    }
}