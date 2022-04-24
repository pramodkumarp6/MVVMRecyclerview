package com.example.mvvmrecyclerview.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    private boolean Error;

    @SerializedName("users")
    private List<Users> userList;

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    public boolean isError() {
        return Error;
    }

    public void setError(boolean error) {
        Error = error;
    }
}
