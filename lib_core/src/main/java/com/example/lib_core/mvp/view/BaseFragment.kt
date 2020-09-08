package com.example.lib_core.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lib_core.mvp.presenter.IPresenter;
import com.example.lib_core.widget.LoadingDialog;

import javax.inject.Inject;

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView, IFragment {
    @Inject
    protected P mPresenter;
    private View mBaseView;
    private LoadingDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseView = inflater.inflate(bandLayout(), container, false);
        return mBaseView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new LoadingDialog(getContext());
        initView();
        initPresenter();
        initData();

    }

    @Override
    public <T extends View> T findViewById(int id) {
        return mBaseView.findViewById(id);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
        }
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
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }
}
