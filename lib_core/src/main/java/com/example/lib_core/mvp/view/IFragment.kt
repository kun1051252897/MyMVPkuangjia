package com.example.lib_core.mvp.view;

import android.view.View;

public interface IFragment extends IActivity {
    <T extends View> T findViewById(int id);
}
