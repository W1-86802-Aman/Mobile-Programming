package com.sunbeaminfo.mobilesrestapiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunbeaminfo.mobilesrestapiapp.R;
import com.sunbeaminfo.mobilesrestapiapp.entities.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    Context context;
    List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_user,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     User user= userList.get(position);
     holder.textName.setText(user.getName());
     holder.textPhone.setText(user.getMobile());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder{
          TextView textName,textPhone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName= itemView.findViewById(R.id.textName);
            textPhone= itemView.findViewById(R.id.textPhone);
        }
    }

}
