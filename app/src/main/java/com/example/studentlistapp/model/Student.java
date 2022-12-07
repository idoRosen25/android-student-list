package com.example.studentlistapp.model;

public class Student {
    public String name;
    public String id;
    public String avatarUrl;
    public String phone;
    public String address;
    public boolean cb;

    public Student(String name, String id, String avatarUrl,String phone,String address,boolean cb){
        this.name=name;
        this.id=id;
        this.avatarUrl=avatarUrl;
        this.phone=phone;
        this.address=address;
        this.cb=cb;
    }
}
