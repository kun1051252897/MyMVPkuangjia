package com.example.lib_core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

/**
 * 全部界面中发起网络请求时弹出的等待对话框
 * */
public class LoadingDialog extends Dialog {

    private ProgressBar bar;

    public LoadingDialog(@NonNull Context context) {
        super(context);
        setCancelable(false);
        getWindow().setDimAmount(0f);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(init());
    }

    private View init(){
        bar = new ProgressBar(getContext());
        return bar;
    }

}
