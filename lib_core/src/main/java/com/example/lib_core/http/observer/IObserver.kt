package com.example.lib_core.http.observer;

public interface IObserver<T> {
    void success(T bean);

    void error(String msg);
}
