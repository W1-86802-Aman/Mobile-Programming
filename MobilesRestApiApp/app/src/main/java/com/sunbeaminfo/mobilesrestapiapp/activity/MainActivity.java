package com.sunbeaminfo.mobilesrestapiapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sunbeaminfo.mobilesrestapiapp.R;
import com.sunbeaminfo.mobilesrestapiapp.adapter.UserAdapter;
import com.sunbeaminfo.mobilesrestapiapp.entities.User;
import com.sunbeaminfo.mobilesrestapiapp.utils.RetroFitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;

    List<User> userList;
    UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.recyclerView);
        setSupportActionBar(toolbar);
        userList=new ArrayList<>();
        userList.add(new User(1,"aman","aman@gmail.com","aman","89779878"));
        userAdapter=new UserAdapter(this,userList);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAllUsers();
    }

    public void getAllUsers(){
         RetroFitClient.getInstance().getApi().getAllUsers().enqueue(new Callback<JsonObject>() {
             @SuppressLint("NotifyDataSetChanged")
             @Override
             public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                 if(response.body().get("status").getAsString().equals("success")){
                     userList.clear();
                     JsonArray array=response.body().get("data").getAsJsonArray();
                     for(JsonElement element:array){
                         User user=new User();
                         user.setId(element.getAsJsonObject().get("id").getAsInt());
                         user.setName(element.getAsJsonObject().get("name").getAsString());
                         user.setEmail(element.getAsJsonObject().get("email").getAsString());
                         user.setPassword(element.getAsJsonObject().get("password").getAsString());
                         user.setMobile(element.getAsJsonObject().get("mobile").getAsString());
                         userList.add(user);
                     }
                     userAdapter.notifyDataSetChanged();
                 }
             }

             @Override
             public void onFailure(Call<JsonObject> call, Throwable throwable) {
                 Toast.makeText(MainActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
             }
         });
     }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.add){
            Intent intent=new Intent(this, UserAddEditActivity.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.search){
            Intent intent=new Intent(this, UserSearchActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}