package com.example.mvvmrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mvvmrecyclerview.adapter.MainAdapter;
import com.example.mvvmrecyclerview.databinding.ActivityMainBinding;
import com.example.mvvmrecyclerview.model.UserResponse;
import com.example.mvvmrecyclerview.model.Users;
import com.example.mvvmrecyclerview.repository.MainRepository;
import com.example.mvvmrecyclerview.viewmodel.MainViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private MainAdapter mainAdapter;

    private List<Users> users;
    private ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainBinding.reclyer.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(this, users);


        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        dataClick();


    }

    public void dataClick() {

        mainViewModel.getUserDetails().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                UserResponse response = userResponse;
                if (!response.isError()) {
                    List<Users> users = response.getUserList();
                    mainAdapter.setUser(users);
                    mainBinding.reclyer.setAdapter(mainAdapter);
                    mainAdapter.notifyDataSetChanged();

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("MainActivity", gson.toJson(users));
                }


            }
        });


    }
}
