package com.example.jitendrakumarsahu.crudoperation.com.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "employeeDB";
    public static final String DATABASE_VERSION = "1";
    public static final String TABLE_NAME = "employeeData";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String SALARY = "salary";

    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(20),"+AGE+" VARCHAR(10), "+SALARY+" VARCHAR(20));";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " +TABLE_NAME;
    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, Integer.parseInt(DATABASE_VERSION));
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        try
        {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }
        catch (Exception e)
        {
            System.out.println("Error in onCreate method");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        try
        {
            sqLiteDatabase.execSQL(DROP_TABLE);
        }
        catch (Exception e)
        {
            System.out.println("Error in onUpgrade method");
        }
    }
}
