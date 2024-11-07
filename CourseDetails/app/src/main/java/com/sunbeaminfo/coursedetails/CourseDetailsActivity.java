package com.sunbeaminfo.coursedetails;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CourseDetailsActivity extends AppCompatActivity {
    ImageView courseImage;
    TextView textCourseId,textCourseName,textCourseDesc,textCourseEligibilty,textCourseFees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        courseImage=findViewById(R.id.courseImage);
        textCourseId=findViewById(R.id.textCourseId);
        textCourseName=findViewById(R.id.textCourseName);
        textCourseDesc=findViewById(R.id.textCourseDesc);
        textCourseEligibilty=findViewById(R.id.textCourseEligiblity);
        textCourseFees=findViewById(R.id.textCourseFees);
        Intent intent= getIntent();
        Course course= (Course) intent.getSerializableExtra("course");
        if(course!=null) {
            courseImage.setImageResource(course.getImage());
            textCourseId.setText(String.valueOf(course.getCourseId()));
            textCourseName.setText(course.getCourseName());
            textCourseDesc.setText(course.getCourseDesc());
            textCourseEligibilty.setText(course.getCourseEligibility());
            textCourseFees.setText(String.valueOf(course.getFees()));
        }else
            Log.e("CoursedeatilsActivity","null");
//        courseImage.setImageResource(course.getImage());
//        textCourseId.setText(course.getCourseId());
//        textCourseName.setText(course.getCourseName());
//        textCourseDesc.setText(course.getCourseDesc());
//        textCourseEligibilty.setText(course.getCourseEligibility());
//        textCourseFees.setText(course.getFees());

    }
}