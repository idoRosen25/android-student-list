package com.example.studentlistapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();
    private List<Student> data = new LinkedList<>();
    public static Model instance(){
        return _instance;
    }

    private Model(){
        for(int i=1;i<=10;i++){
            addStudent(new Student("Moshe",""+i,"","","",false));
        }
    }

    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student st){
        data.add(st);
    }

    public void updateStudent (int pos, Student newSt){
        data.set(pos,newSt);
    }

    public void deleteStudent(int pos){
        data.remove(pos);
    }
}
