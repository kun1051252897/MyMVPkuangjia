package com.example.lib_core.widget

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ProgressBar

/**
 * 全部界面中发起网络请求时弹出的等待对话框
 */
class LoadingDialog(context: Context) : Dialog(context) {
    private var bar: ProgressBar? = null
    private fun init(): View {
        bar = ProgressBar(context)
        return bar!!
    }

    init {
        setCancelable(false)
        window!!.setDimAmount(0f)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(init())
    }
}