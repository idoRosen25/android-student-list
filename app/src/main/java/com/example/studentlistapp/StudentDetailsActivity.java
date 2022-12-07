package com.example.studentlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentlistapp.model.Model;
import com.example.studentlistapp.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    Student st;
    TextView nameTv;
    TextView idTv;
    TextView phoneTv;
    TextView addressTv;
    CheckBox cb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(st==null || st.id.equals(Model.instance().getAllStudents().get((int)getIntent().getExtras().get("index")).id)){
            st= Model.instance().getAllStudents().get((int)getIntent().getExtras().get("index"));
        }
        nameTv = findViewById(R.id.student_details_name_tv);
        idTv = findViewById(R.id.student_details_id_tv);
        phoneTv = findViewById(R.id.student_details_phone_tv);
        addressTv = findViewById(R.id.student_details_address_tv);
        cb = findViewById(R.id.student_details_cb);
        Button editBtn = findViewById(R.id.student_details_edit_btn);
        Button cancelBtn = findViewById(R.id.student_details_cancel_btn);

        nameTv.setText("Name: "+st.name);
        idTv.setText("ID: "+st.id);
        phoneTv.setText("Phone: "+(st.phone.length()>0 ? st.phone : "unkown"));
        addressTv.setText("Address: "+(st.address.length()>0 ? st.address : "unkown"));
        cb.setChecked(st.cb);

        cancelBtn.setOnClickListener(view->finish());

        editBtn.setOnClickListener(view->{
            Intent intent = new Intent(this,EditStudentActivity.class);
            intent.putExtra("student",(int)getIntent().getExtras().get("index"));
            startActivity(intent);
        });
    }

}