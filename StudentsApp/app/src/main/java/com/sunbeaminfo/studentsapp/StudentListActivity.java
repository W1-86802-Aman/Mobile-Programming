package com.sunbeaminfo.studentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {
    Toolbar toolBar;
    RecyclerView recyclerView;

    List<Student> studentList;

    StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        toolBar=findViewById(R.id.toolBar);
        recyclerView=findViewById(R.id.recyclerView);
        setSupportActionBar(toolBar);
        studentList=new ArrayList<>();
        studentList.add(new Student(1,"Anil","Dac",60));
        studentAdapter=new StudentAdapter(this,studentList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }
    ActivityResultLauncher launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==1) {
                Intent intent = result.getData();
                Student student = (Student) intent.getSerializableExtra("student");
//                Log.e("student",student.toString());
                studentList.add(student);
                studentAdapter.notifyDataSetChanged();
            }
        }
    });
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this,StudentAddActivity.class);
        launcher.launch(intent);
        return super.onOptionsItemSelected(item);
    }
}