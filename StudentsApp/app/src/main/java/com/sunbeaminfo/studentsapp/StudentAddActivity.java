package com.sunbeaminfo.studentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentAddActivity extends AppCompatActivity {
    EditText editRollno,editName,editMarks,editCourse;
    StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        editRollno=findViewById(R.id.editRollno);
        editName=findViewById(R.id.editName);
        editMarks=findViewById(R.id.editMarks);
        editCourse=findViewById(R.id.editCourse);

    }
    public void save(View v){
        Student student=new Student();
        student.setRollno(Integer.parseInt(editRollno.getText().toString()));
        student.setName(editName.getText().toString());
        student.setCourse(editCourse.getText().toString());
        student.setMarks(Double.parseDouble(editMarks.getText().toString()));

        Intent intent = new Intent();
        intent.putExtra("student",student);
        setResult(1,intent);

        finish();
    }
    public void cancel(View v){
        finish();
    }

}