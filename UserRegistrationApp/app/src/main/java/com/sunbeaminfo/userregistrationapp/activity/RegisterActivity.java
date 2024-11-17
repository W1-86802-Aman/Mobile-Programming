package com.sunbeaminfo.userregistrationapp.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunbeaminfo.userregistrationapp.R;
import com.sunbeaminfo.userregistrationapp.dbhelper.AppDbHelper;
import com.sunbeaminfo.userregistrationapp.entity.User;

public class RegisterActivity extends AppCompatActivity {
    EditText editName,editEmail,editPassword,editConfirmPassword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editName=findViewById(R.id.editName);
        editEmail=findViewById(R.id.editEmail);
        editPassword=findViewById(R.id.editPassword);
        editConfirmPassword=findViewById(R.id.editConfirmPassword);
    }
    public void register(View v){
        String password=editPassword.getText().toString();
        String confirmPassword=editConfirmPassword.getText().toString();
        if(password.equals(confirmPassword)){
            User user=new User();
            user.setName(editName.getText().toString());
            user.setEmail(editEmail.getText().toString());
            user.setPassword(password);
            AppDbHelper dbHelper=new AppDbHelper(this);
            dbHelper.insertUser(user);
            finish();
        }else{
            Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
        }
    }
    public void cancel(View v){
        finish();
    }
}