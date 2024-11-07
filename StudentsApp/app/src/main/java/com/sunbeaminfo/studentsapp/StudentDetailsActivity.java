package com.sunbeaminfo.studentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentDetailsActivity extends AppCompatActivity {
    TextView textRollno,textCourse,textName,textMarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        textRollno=findViewById(R.id.textRollno);
        textCourse=findViewById(R.id.textCourse);
        textName=findViewById(R.id.textName);
        textMarks=findViewById(R.id.textMarks);

        Intent intent=getIntent();
        Student student=(Student) intent.getSerializableExtra("student");
        textRollno.setText(String.valueOf(student.getRollno()));
        textCourse.setText(student.getCourse());
        textName.setText(student.getName());
        textMarks.setText(String.valueOf(student.getMarks()));


    }
}