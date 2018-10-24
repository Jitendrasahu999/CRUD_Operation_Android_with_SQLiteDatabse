package com.example.jitendrakumarsahu.crudoperation.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.jitendrakumarsahu.crudoperation.Employee;

import java.util.ArrayList;


public class MyDatabaseAdaptor
{
    ArrayList<Employee> employees;

    MyDatabaseHelper myDatabaseHelper;
    public MyDatabaseAdaptor(Context context)  //Creating a Constructor.
    {
        Log.d("Context: ", context == null ? "is null": "is not null");
        myDatabaseHelper = new MyDatabaseHelper(context);     //make a object of database helper.
    }

    public long insertData(String name,String age, String salary)
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(myDatabaseHelper.NAME, name);
        contentValues.put(myDatabaseHelper.AGE, age);
        contentValues.put(myDatabaseHelper.SALARY, salary);

        long id = sqLiteDatabase.insert(myDatabaseHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    public ArrayList<Employee> getData()
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        String [] collumn = {myDatabaseHelper.ID, myDatabaseHelper.NAME, myDatabaseHelper.AGE, myDatabaseHelper.SALARY};
        Cursor cursor = sqLiteDatabase.query(myDatabaseHelper.TABLE_NAME,collumn,null, null, null, null,null);

        employees = new ArrayList<Employee>();


        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(myDatabaseHelper.ID));
            String name = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.NAME));
            int age = cursor.getInt(cursor.getColumnIndex(myDatabaseHelper.AGE));
            float salary = cursor.getFloat(cursor.getColumnIndex(myDatabaseHelper.SALARY));
            employees.add(new Employee(id, name, age, salary));

        }
        return employees;
    }
// Delete All Employee code
    public void deleteEmp(int id)
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        sqLiteDatabase.delete(myDatabaseHelper.TABLE_NAME,myDatabaseHelper.ID +"= ?", new String[]{String.valueOf(id)});
    }

    public long updateEmp(int id, String name, int age, float salary)
    {
        try
        {
            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(myDatabaseHelper.NAME, name);
            contentValues.put(myDatabaseHelper.AGE,age);
            contentValues.put(myDatabaseHelper.SALARY,salary);

            sqLiteDatabase.update(myDatabaseHelper.TABLE_NAME, contentValues, myDatabaseHelper.ID +"=?", new String[]{String.valueOf(id)});

        }
        catch (Exception e)
        {
            System.out.println("Error in UpdateEmp()...???");
        }

        return 0;
    }
}
