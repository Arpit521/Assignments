package com.example.arpit.assignment1.JsonCalling;

/**
 * Created by arpit on 15/2/17.
 */

public class messageUser {

    public int getHttp_code() {
        return http_code;
    }

    public void setHttp_code(int http_code) {
        this.http_code = http_code;
    }

    public com.example.arpit.assignment1.JsonCalling.message getMessage() {
        return message;
    }

    public void setMessage(com.example.arpit.assignment1.JsonCalling.message message) {
        this.message = message;
    }


    private int http_code;
    private message message;



}
