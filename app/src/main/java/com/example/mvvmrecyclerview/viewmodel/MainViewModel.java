package com.example.mvvmrecyclerview.viewmodel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmrecyclerview.model.UserResponse;
import com.example.mvvmrecyclerview.repository.MainRepository;


public class MainViewModel extends ViewModel {
    private MainRepository mainRepository;



    public MutableLiveData<UserResponse> getUserDetails() {
        mainRepository = new MainRepository();
        return mainRepository.dataView();
    }

}
