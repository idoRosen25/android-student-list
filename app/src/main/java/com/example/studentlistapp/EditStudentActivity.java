package com.example.studentlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentlistapp.model.Model;
import com.example.studentlistapp.model.Student;

public class EditStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        int stIndex =(int)getIntent().getExtras().get("student");
        Student st = Model.instance().getAllStudents().get(stIndex);

        EditText nameEt = findViewById(R.id.editstudent_name_et);
        EditText idEt = findViewById(R.id.editstudent_id_et);
        EditText phoneEt = findViewById(R.id.editstudent_phone_et);
        EditText addressEt = findViewById(R.id.editstudent_address_et);
        CheckBox cb = findViewById(R.id.editstudent_cb);
        Button cancelBtn = findViewById(R.id.editstudent_cancel_btn);
        Button saveBtn = findViewById(R.id.editstudent_save_btn);
        Button deleteBtn = findViewById(R.id.editstudent_delete_btn);

        nameEt.setText(st.name);
        idEt.setText(st.id);
        phoneEt.setText(st.phone);
        addressEt.setText(st.address);
        cb.setChecked(st.cb);

        cancelBtn.setOnClickListener(view->finish());
        deleteBtn.setOnClickListener(view->{
            Model.instance().deleteStudent(stIndex);
            getIntent().putExtra("fromEditActivity","delete user");
            finish();
        });
        saveBtn.setOnClickListener(view->{
            Model.instance().updateStudent(stIndex,new Student(nameEt.getText().toString(),idEt.getText().toString(),"",phoneEt.getText().toString(),addressEt.getText().toString(),cb.isChecked()));
            getIntent().putExtra("fromEditActivity","update user");
            finish();
        });

    }
}