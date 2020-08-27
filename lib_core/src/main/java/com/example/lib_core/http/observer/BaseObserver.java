package com.example.lib_core.http.observer;

import io.reactivex.observers.DisposableObserver;

//观察者
public abstract class BaseObserver<T> extends DisposableObserver<T> implements IObserver<T> {
    @Override
    public void onNext(T t) {
        success(t);
    }

    @Override
    public void onError(Throwable e) {
        error(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
