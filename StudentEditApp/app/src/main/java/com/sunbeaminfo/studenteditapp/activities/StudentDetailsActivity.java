package com.sunbeaminfo.studenteditapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunbeaminfo.studenteditapp.R;
import com.sunbeaminfo.studenteditapp.entity.Student;

public class StudentDetailsActivity extends AppCompatActivity {
    TextView textId,textName,textCourse,textMarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Intent intent=getIntent();
        Student student=(Student) intent.getSerializableExtra("student");
       textId=findViewById(R.id.textId);
       textName=findViewById(R.id.textName);
        textCourse=findViewById(R.id.textCourse);
        textMarks=findViewById(R.id.textMarks);

        textId.setText(""+student.getId());
        textName.setText(student.getName());
        textCourse.setText(student.getCourse());
        textMarks.setText(""+student.getMarks());
    }
}