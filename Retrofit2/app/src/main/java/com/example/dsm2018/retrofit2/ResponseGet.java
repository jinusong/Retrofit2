package com.example.dsm2018.retrofit2;

public class ResponseGet {
    public final int userId;
    public final int id;
    public final String title;
    public final String body;

    public ResponseGet(int userId, int id, String title, String body){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
