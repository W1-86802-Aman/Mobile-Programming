package com.sunbeaminfo.employeedatabaseapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeDetailsActivity extends AppCompatActivity {
     TextView textId,textName,textMarks;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        textId=findViewById(R.id.textId);
        textName=findViewById(R.id.textName);
        textMarks=findViewById(R.id.textMarks);

        Intent intent =getIntent();
        Employee employee=(Employee) intent.getSerializableExtra("employee");
        textId.setText(""+ employee.getId());
        textName.setText(employee.getName());
        textMarks.setText(""+employee.getMarks());
    }
}