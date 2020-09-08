package com.example.lib_core.mvp.view

import android.view.View

interface IFragment : IActivity {
    fun <T : View?> findViewById(id: Int): T
}