package com.studentmanagement.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String department;
    private String email;

    public Student() {
    }

    public Student(String name, int age, String department, String email) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.email = email;
    }

    public Student(int id, String name, int age, String department, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.email = email;
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
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getDepartment() {
        return department = department;
    }
    public void setDepartment(String department) {
        this.department= department;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}