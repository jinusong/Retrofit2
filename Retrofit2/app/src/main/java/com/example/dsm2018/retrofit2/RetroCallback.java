package com.example.dsm2018.retrofit2;

public interface RetroCallback<T> {
    void onError(Throwable t);

    void onSuccess(int cod, T receivedData);

    void onFailure(int code);
}
