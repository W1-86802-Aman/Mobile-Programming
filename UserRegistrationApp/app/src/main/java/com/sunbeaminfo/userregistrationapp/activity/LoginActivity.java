package com.sunbeaminfo.userregistrationapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunbeaminfo.userregistrationapp.R;
import com.sunbeaminfo.userregistrationapp.dbhelper.AppDbHelper;
import com.sunbeaminfo.userregistrationapp.entity.User;

public class LoginActivity extends AppCompatActivity {
     EditText editEmail,editPassword;
     CheckBox checkbox;
     TextView textRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences=getSharedPreferences("MyPreferences",MODE_PRIVATE);
        boolean status=preferences.getBoolean("login_status",false);
        if(status){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        editEmail=findViewById(R.id.editEmail);
        editPassword=findViewById(R.id.editPassword);
        checkbox=findViewById(R.id.checkbox);
        textRegister=findViewById(R.id.textRegister);
        textRegister.setOnClickListener(v -> {
            startActivity(new Intent(this,RegisterActivity.class));
        });
    }
    public void login(View v){
      String email=editEmail.getText().toString();
      String password=editPassword.getText().toString();
        AppDbHelper dbHelper=new AppDbHelper(this);
        User user =dbHelper.getUser(email,password);
        if(user!=null){
         if(checkbox.isChecked()){
             SharedPreferences preferences=getSharedPreferences("MyPreferences",MODE_PRIVATE);
             preferences.edit().putBoolean("login_status",true).apply();

         }
         Intent intent =new Intent(this,MainActivity.class);
         startActivity(intent);
         finish();
        }else{
            Toast.makeText(this, "Inavlid Credentials", Toast.LENGTH_SHORT).show();
        }
    }
}