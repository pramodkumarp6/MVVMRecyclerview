package com.example.mvvmrecyclerview.app;

import com.example.mvvmrecyclerview.model.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api
{
    @GET("/simple/public/allusers")
    Observable<UserResponse> userData();
}
