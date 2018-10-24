package com.example.jitendrakumarsahu.crudoperation.com.database;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jitendrakumarsahu.crudoperation.Employee;
import com.example.jitendrakumarsahu.crudoperation.EmployeeAdapter;
import com.example.jitendrakumarsahu.crudoperation.R;

public class UpdateEmp extends AppCompatActivity {

    private static final String EXTRA_KEY_PARCEL_EMPLOYEE = "emp_key";

    Button btn_update;
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

    public static Intent getStartIntent(Context context, Employee emp) {
        Intent intent = new Intent(context, UpdateEmp.class);
        intent.putExtra(UpdateEmp.EXTRA_KEY_PARCEL_EMPLOYEE, emp);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_emp);

        final MyDatabaseAdaptor myDatabaseAdaptor=new MyDatabaseAdaptor(UpdateEmp.this);
        btn_update = (Button) findViewById(R.id.button_insert);
        btn_reset = (Button) findViewById(R.id.button_reset);

        textView_id = (TextView) findViewById(R.id.textView_emp_id);
        editText_id = (EditText) findViewById(R.id.editText_emp_id);
        textView_name = (TextView) findViewById(R.id.textView_emp_name);
        editText_name = (EditText) findViewById(R.id.editText_emp_name);
        textView_salary = (TextView) findViewById(R.id.textView_emp_salary);
        editText_salary = (EditText) findViewById(R.id.editText_emp_salary);
        textView_age = (TextView) findViewById(R.id.textView_emp_age);
        editText_age = (EditText) findViewById(R.id.editText_emp_age);
        button_ShowData = findViewById(R.id.button_show_all_Data);


 //       Employee emp =(Employee) getIntent().getParcelableExtra(EmployeeAdapter.parce_key);


//        Intent intent = getIntent();
//        final Bundle bundle = getIntent().getExtras();
//
            Employee emp = getIntent().getParcelableExtra(UpdateEmp.EXTRA_KEY_PARCEL_EMPLOYEE);
            final int id = emp.getId();
            final String name = emp.getName();
            final int age = emp.getAge();
            final float salary = emp.getSalary();

            editText_name.setText(name);
            editText_id.setText(String.valueOf(id));
            editText_age.setText(String.valueOf(age));
            editText_salary.setText(String.valueOf(salary));

    btn_update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(editText_id != null || editText_name != null || editText_age != null || editText_salary != null) {
                  Toast.makeText(UpdateEmp.this, "Button Update", Toast.LENGTH_SHORT).show();
                  myDatabaseAdaptor.updateEmp(Integer.parseInt(String.valueOf(editText_id.getText())),
                    String.valueOf(editText_name.getText()),
                    Integer.parseInt(String.valueOf(editText_age.getText())),
                    Float.parseFloat(String.valueOf(editText_salary.getText())));

            editText_id.setText("");
            editText_name.setText("");
            editText_age.setText("");
            editText_salary.setText("");
        }else
            {
                Toast.makeText(UpdateEmp.this, "Please fill compleate Data!!!!", Toast.LENGTH_SHORT).show();
            }
        }
    });

    btn_reset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            editText_id.setText("");
            editText_name.setText("");
            editText_age.setText("");
            editText_salary.setText("");
        }
    });

    button_ShowData.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });


    }
}
