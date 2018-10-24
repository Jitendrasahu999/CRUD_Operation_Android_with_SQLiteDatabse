package com.example.jitendrakumarsahu.crudoperation;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {
    public int id;
    public String name;
    public int age;
    public float salary;

    protected Employee(Parcel in) {
        id = in.readInt();
        name = in.readString();
        age = in.readInt();
        salary = in.readFloat();
    }

    public Employee()
    {

    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            Employee emp1 = new Employee();
            emp1.id = in.readInt();
            emp1.name = in.readString();
            emp1.age = in.readInt();
            emp1.salary = in.readFloat();
            return emp1;
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Employee(int id, String name, int age, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeFloat(salary);
    }
}
