package com.sunbeaminfo.employeedatabaseapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    Context context;
    List<Employee> employeeList;

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_employee,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.textId.setText(""+employeeList.get(position).getId());
      holder.textName.setText(employeeList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
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
            Intent intent=new Intent(context,EmployeeDetailsActivity.class);
            intent.putExtra("employee",employeeList.get(getAdapterPosition()));
            context.startActivity(intent);
        }

        @Override
        public boolean onLongClick(View v) {
            PopupMenu popupMenu=new PopupMenu(context,v);
            popupMenu.getMenu().add("edit");
            popupMenu.getMenu().add("delete");
            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(item -> {
                if(item.getTitle().equals("delete")){
                    EmployeeDbHelper dbHelper=new EmployeeDbHelper(context);
                    dbHelper.delete(employeeList.get(getAdapterPosition()).getId());
                    employeeList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
                if(item.getTitle().equals("edit")){
                    Intent intent=new Intent(context,EmployeeAddActivity.class);
                    intent.putExtra("editStatus",true);
                    intent.putExtra("employee",employeeList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
                return false;
            });
            return false;
        }
    }
}
