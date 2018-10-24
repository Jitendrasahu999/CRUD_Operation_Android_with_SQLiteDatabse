package com.example.jitendrakumarsahu.crudoperation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.jitendrakumarsahu.crudoperation.com.database.Main2Activity;
import com.example.jitendrakumarsahu.crudoperation.com.database.MyDatabaseAdaptor;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private List<Employee> employeeList = new ArrayList<Employee>();
    private RecyclerView recyclerView;
    private EmployeeAdapter mAdapter;
    Context context;

   FloatingActionButton floatingActionButton;
   MyDatabaseAdaptor myDatabaseAdaptor;


   SwipeRefreshLayout swipeRefreshLayout;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_layout);

        //SwipeRefreshLayout creating with recycler View.
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        myDatabaseAdaptor=new MyDatabaseAdaptor(MainActivity.this);
                        ArrayList<Employee> employees = myDatabaseAdaptor.getData();
                        Collections.reverse(employees);
                        mAdapter = new EmployeeAdapter(employees ,MainActivity.this);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }
                }, 1000);
            }
        });


        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


         myDatabaseAdaptor=new MyDatabaseAdaptor(MainActivity.this);
         ArrayList<Employee> employees = myDatabaseAdaptor.getData();
         Collections.reverse(employees);
         mAdapter = new EmployeeAdapter(employees ,MainActivity.this);
         RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
         recyclerView.setLayoutManager(mLayoutManager);
         recyclerView.setItemAnimator(new DefaultItemAnimator());
         recyclerView.setAdapter(mAdapter);
         mAdapter.notifyDataSetChanged();

    }


}
