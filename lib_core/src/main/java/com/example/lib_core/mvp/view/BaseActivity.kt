package com.example.lib_core.mvp.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lib_core.mvp.presenter.IPresenter;
import com.example.lib_core.widget.LoadingDialog;

import javax.inject.Inject;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity, IView {
    @Inject
    protected P mPresenter;
    private LoadingDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bandLayout());
        dialog = new LoadingDialog(this);
        initView();
        initPresenter();
        initData();
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.hide();
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }
}
