package com.sunbeaminfo.studenteditapp.activities;

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

import com.sunbeaminfo.studenteditapp.R;
import com.sunbeaminfo.studenteditapp.entity.Student;

public class StudentAddActivity extends AppCompatActivity {
    EditText editId,editName,editCourse,editMarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        editId =findViewById(R.id.editId);
        editName=findViewById(R.id.editName);
        editCourse=findViewById(R.id.editCourse);
        editMarks=findViewById(R.id.editMarks);

    }
    public void save(View v){
        Student s= new Student();
        s.setId(Integer.parseInt(editId.getText().toString()));
        s.setName(editName.getText().toString());
        s.setCourse(editCourse.getText().toString());
        s.setMarks(Double.parseDouble(editMarks.getText().toString()));
        Intent intent = new Intent();
        intent.putExtra("student",s);
        setResult(1,intent);
        finish();
    }
    public void cancel(View view){
        finish();
    }
}