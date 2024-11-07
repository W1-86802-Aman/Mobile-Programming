package com.sunbeaminfo.coursedetails;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Course> courseList;

    CourseAdapter courseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        courseList=new ArrayList<>();
        courseList.add(new Course(1,"PG-DAC","The course aims to groom the students to enable them to work on current technology scenarios as well as prepare them to keep pace with the changing face of technology and the requirements of the growing IT industry.","Graduate in any discipline of Engineering",90000,R.drawable.dac));
        courseList.add(new Course(2,"PG-DMC","The main focus of this course is to enable the candidates fulfilling the eligibility criteria, to develop their skill set mainly in areas like Native and Hybrid Mobile Application Development.","Graduate in Engineering or Technology, Mech nd Civil not Eligible",100000,R.drawable.dmc));
        courseList.add(new Course(3,"PG-DESD","Embedded Systems is a unique field, where engineers need to have sound knowledge in hardware and software design.","Graduate in Engineering or Technology The candidates must have secured a minimum of 55% marks",90000,R.drawable.desd));
        courseList.add(new Course(4, "PG-DBDA","The course is also suitable for those who are already working in analytics to enhance their theoretical and conceptual knowledge as well as those with analytical aptitude and would like to start career in big data analytics in different business sectors.","Graduate in Engineering or Technology The candidates must have secured a minimum of 55% marks",115000,R.drawable.dbda));
        courseList.add(new Course(5,"PG-DITISS","To understand the Concepts of Data Centre Management, applications security implementation and use various techniques for Ethical Hacking and Cyber Forensics","Graduate in Engineering or Technology The candidates must have secured a minimum of 55% marks",90000,R.drawable.ditiss));

        courseAdapter=new CourseAdapter(this,courseList);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
}