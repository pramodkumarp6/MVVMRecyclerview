package com.example.mvvmrecyclerview.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmrecyclerview.app.RetrofitClient;
import com.example.mvvmrecyclerview.model.UserResponse;
import com.example.mvvmrecyclerview.model.Users;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainRepository {


    private MutableLiveData<UserResponse> data = new MutableLiveData<>();


    public MutableLiveData<UserResponse> dataView(){
        Observable<UserResponse> observable = RetrofitClient.getInstance().getApi().userData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<UserResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(UserResponse response) {
                             data.setValue(response);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

         return data;
    }
}
