package com.example.jitendrakumarsahu.crudoperation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jitendrakumarsahu.crudoperation.com.database.Main2Activity;
import com.example.jitendrakumarsahu.crudoperation.com.database.MyDatabaseAdaptor;
import com.example.jitendrakumarsahu.crudoperation.com.database.UpdateEmp;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>{

    private List<Employee> employeeList;
    Context context;
    MyDatabaseAdaptor myDatabaseAdaptor;
    public static String parce_key = "abc";

    public EmployeeAdapter(List<Employee> employeeList, Context context ) {
        this.context = context;
        this.employeeList = employeeList;
        myDatabaseAdaptor = new MyDatabaseAdaptor(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_list_row, parent, false);
        return new MyViewHolder(view);


    }

    Dialog dialog;
    Button btnDelete;
    Button btnUpdate;
    ImageButton btnClose;

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Employee emp = employeeList.get(position);
        holder.id.setText(String.valueOf(emp.getId()));
        holder.name_emp.setText(emp.getName());
        holder.age.setText(String.valueOf(emp.getAge()));
        holder.salary.setText(String.valueOf( emp.getSalary()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom);

                btnDelete = (Button)dialog.findViewById(R.id.btnDelete);
                btnUpdate = (Button)dialog.findViewById(R.id.btnUpdate);
                btnClose = (ImageButton)dialog.findViewById(R.id.btnClose);

                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        myDatabaseAdaptor.deleteEmp(emp.getId());
                        Toast.makeText(context, "Delete Successfuly", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        int id,age;
//                        float salary;
//                        String name;
//
//                        id=emp.getId();
//                        age=emp.getAge();
//                        salary=emp.getSalary();
//                        name=emp.getName();
//
//
//                        Employee emp = new Employee(id, name, age, salary);
//                        emp.setId(id);
//                        emp.setName(name);
//                        emp.setAge(age);
//                        emp.setSalary(salary);

//                        bundle.putInt("id_key", id);
//                        bundle.putString("name_key",name);
//                        bundle.putInt("age",age);
//                        bundle.putFloat("salary",salary);

                        Intent intent = UpdateEmp.getStartIntent(context, emp);
                        context.startActivity(intent);

                       Toast.makeText(context, "Click on Update Button", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });



                dialog.show();

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return employeeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id,name_emp,age,salary;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = (TextView)itemView.findViewById(R.id.id);
            name_emp = (TextView)itemView.findViewById(R.id.name);
            age = (TextView)itemView.findViewById(R.id.age);
            salary = (TextView)itemView.findViewById(R.id.salary);
        }
    }
}