package com.sunbeaminfo.employeedatabaseapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeAddActivity extends AppCompatActivity {
    EditText editId,editName,editMarks;
    Boolean editStatus;
    Employee e;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_add);
//        editId=findViewById(R.id.editId);
        editName=findViewById(R.id.editName);
        editMarks=findViewById(R.id.editMarks);
        Intent intent=getIntent();
        editStatus=intent.getBooleanExtra("editStatus",false);
        if(editStatus){
            e=(Employee) intent.getSerializableExtra("employee");
            editName.setText(e.getName());
            editMarks.setText(""+e.getMarks());
        }

    }
    public void save(View v){

        String name=editName.getText().toString();
        double marks=Double.parseDouble(editMarks.getText().toString());

        EmployeeDbHelper dbHelper=new EmployeeDbHelper(this);
        if(editStatus)
            dbHelper.editEmployee(e.getId(),name,marks);
        else
            dbHelper.insertEmployee(name,marks);
        finish();
    }
    public void cancel(View v){
        finish();
    }
}