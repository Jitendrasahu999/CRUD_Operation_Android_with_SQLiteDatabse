package com.example.jitendrakumarsahu.crudoperation.com.database;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jitendrakumarsahu.crudoperation.Employee;
import com.example.jitendrakumarsahu.crudoperation.MainActivity;
import com.example.jitendrakumarsahu.crudoperation.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    Button btn_insert;
    Button btn_reset;

    TextView textView_id;
    EditText editText_id;
    TextView textView_name;
    EditText editText_name;
    TextView textView_salary;
    EditText editText_salary;
    TextView textView_age;
    EditText editText_age;
    Button  button_ShowData;

    MyDatabaseAdaptor myDatabaseAdaptor;
    MyDatabaseHelper myDatabaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_insert = (Button) findViewById(R.id.button_insert);
        btn_reset = (Button) findViewById(R.id.button_reset);

        textView_id = (TextView) findViewById(R.id.textView_emp_id);
        editText_id = (EditText) findViewById(R.id.editText_emp_id);
        textView_name = (TextView) findViewById(R.id.textView_emp_name);
        editText_name = (EditText) findViewById(R.id.editText_emp_name);
        textView_salary = (TextView) findViewById(R.id.textView_emp_salary);
        editText_salary = (EditText) findViewById(R.id.editText_emp_salary);
        textView_age = (TextView) findViewById(R.id.textView_emp_age);
        editText_age = (EditText) findViewById(R.id.editText_emp_age);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_name.setText("");
                editText_age.setText("");
                editText_salary.setText("");
            }
        });
        button_ShowData = findViewById(R.id.button_show_all_Data);
        button_ShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        myDatabaseAdaptor = new MyDatabaseAdaptor(this);

    }

    public void addUser(View view) {
        String s1 = editText_name.getText().toString();
        String s2 = editText_age.getText().toString();
        String s3 = editText_salary.getText().toString();

        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
            Toast.makeText(this, "Name, Age and Salary are Empty!!!!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            long id = myDatabaseAdaptor.insertData(s1, s2, s3);

            if (id <= 0) {
                Toast.makeText(this, "Insertion unsuccessful", Toast.LENGTH_SHORT).show();
                editText_id.setText("");
                editText_name.setText("");
                editText_age.setText("");
                editText_salary.setText("");
            } else {
                Toast.makeText(this, "Insertion Successfull", Toast.LENGTH_SHORT).show();
                editText_id.setText("");
                editText_name.setText("");
                editText_age.setText("");
                editText_salary.setText("");
            }

        }
    }

    /*public void  getData(View view)
    {

        Intent intent = new Intent(this, MainActivity.class);
         startActivity(intent);
    }*/

}