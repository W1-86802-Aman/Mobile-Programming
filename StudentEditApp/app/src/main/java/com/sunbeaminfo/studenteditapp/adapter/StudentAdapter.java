package com.sunbeaminfo.studenteditapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunbeaminfo.studenteditapp.R;
import com.sunbeaminfo.studenteditapp.activities.StudentAddActivity;
import com.sunbeaminfo.studenteditapp.activities.StudentDetailsActivity;
import com.sunbeaminfo.studenteditapp.activities.StudentEditActivity;
import com.sunbeaminfo.studenteditapp.entity.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    Context context;
    List<Student> studentList;
    ActivityResultLauncher launcher;
    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    public StudentAdapter(Context context, List<Student> studentList, ActivityResultLauncher launcher) {
        this.context = context;
        this.studentList = studentList;
        this.launcher = launcher;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_student,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     holder.textId.setText(""+studentList.get(position).getId());
     holder.textName.setText(studentList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        TextView textId,textName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textId=itemView.findViewById(R.id.textId);
            textName=itemView.findViewById(R.id.textName);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, StudentDetailsActivity.class);
            intent.putExtra("student",studentList.get(getAdapterPosition()));
            context.startActivity(intent);
        }

        @Override
        public boolean onLongClick(View v) {
            PopupMenu popupMenu=new PopupMenu(context,v);
            popupMenu.getMenu().add("edit");
            popupMenu.getMenu().add("delete");
            popupMenu.show();

            popupMenu.setOnMenuItemClickListener(item -> {
             if(item.getTitle().equals("edit")) {
                 Intent intent = new Intent(context, StudentEditActivity.class);
                 intent.putExtra("student", getAdapterPosition());
                 launcher.launch(intent);
             }
                if(item.getTitle().equals("delete")){
                    studentList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
                return false;
            });
            return false;
        }
    }



}
