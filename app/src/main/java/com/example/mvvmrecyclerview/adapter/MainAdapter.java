package com.example.mvvmrecyclerview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmrecyclerview.R;
import com.example.mvvmrecyclerview.databinding.RowLayoutBinding;
import com.example.mvvmrecyclerview.model.Users;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    ;
    private Context context;
    private List<Users> users;

    public MainAdapter(Context context, List<Users> users) {
        this.context = context;
        this.users = users;
    }

    public void setUser(List<Users> users) {
        this.users = users;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RowLayoutBinding rowLayoutBinding = RowLayoutBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(rowLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.rowLayoutBinding.setUsers(users.get(position));
        holder.rowLayoutBinding.executePendingBindings();

        Log.e(users.get(position).getEmail().toString(), "Adapter");


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowLayoutBinding rowLayoutBinding;


        public MyViewHolder(@NonNull RowLayoutBinding rowLayoutBinding) {
            super(rowLayoutBinding.getRoot());
            this.rowLayoutBinding = rowLayoutBinding;
        }


    }


}

