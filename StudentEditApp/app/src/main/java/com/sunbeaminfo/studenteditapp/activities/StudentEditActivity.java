package com.sunbeaminfo.studenteditapp.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunbeaminfo.studenteditapp.R;

public class StudentEditActivity extends AppCompatActivity {
    EditText editName,editCourse,editMarks;
    TextView textId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);
       textId=findViewById(R.id.textId);
        editName=findViewById(R.id.editName);
        editCourse=findViewById(R.id.editCourse);
        editMarks=findViewById(R.id.editMarks);
        

    }
}