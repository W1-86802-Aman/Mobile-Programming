package com.sunbeaminfo.employeedatabaseapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
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

public class MainActivity extends AppCompatActivity {
    Toolbar toolBar;
    RecyclerView recyclerView;
    EmployeeAdapter employeeAdapter;
    List<Employee> employeeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar=findViewById(R.id.toolBar);
        recyclerView=findViewById(R.id.recyclerView);
        setSupportActionBar(toolBar);
        employeeList=new ArrayList<>();
        employeeList.add(new Employee(1,"Aman",66));
        employeeAdapter=new EmployeeAdapter(this,employeeList);
        recyclerView.setAdapter(employeeAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAllEmployees();
    }

    public void getAllEmployees(){
        employeeList.clear();
        EmployeeDbHelper dbHelper=new EmployeeDbHelper(this);
        Cursor cursor=dbHelper.getAllEmployee();
        while(cursor.moveToNext()){
            Employee e= new Employee();
           e.setId(cursor.getInt(0));
           e.setName(cursor.getString(1));
           e.setMarks(cursor.getDouble(2));
           employeeList.add(e);
        }
        employeeAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add").setIcon(R.drawable.add).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=new Intent(this,EmployeeAddActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}