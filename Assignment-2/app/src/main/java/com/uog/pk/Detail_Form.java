package com.uog.pk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Detail_Form extends AppCompatActivity {

    FormDBMS db;
    List<Model_Class> mylist = new ArrayList<>();
    EditText name;
    EditText f_name;
    EditText gender;
    EditText d_title;
    EditText cnic;
    EditText campus;
    EditText Department;
    EditText CGPA;
    EditText Date;
    EditText Address;
    EditText MobileNo;
    EditText Subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.edittxtName);
        f_name = findViewById(R.id.edittxtf_Name);
        gender  = findViewById(R.id.edittxtgender);
        d_title = findViewById(R.id.edittxttitle);
        cnic = findViewById(R.id.edittxtcnic);
        campus = findViewById(R.id.edittxtcampus);
        Department = findViewById(R.id.edittxtDepartment);
        CGPA = findViewById(R.id.edittxtcgpa);
        Date = findViewById(R.id.edittxtdate);
        Address = findViewById(R.id.edittxtaddress);
        MobileNo = findViewById(R.id.edittxtmobile);
        Subject = findViewById(R.id.edittxtsubject);


        findViewById(R.id.btnDone).setOnClickListener(v ->{

             String Name = name.getText().toString();
             String F_Name = f_name.getText().toString();
             String Gender = gender.getText().toString();
             String D_title = d_title.getText().toString();
             String Cnic = cnic.getText().toString();
             String Campus = campus.getText().toString();
             String Deepartment = Department.getText().toString();
             String cGPA = CGPA.getText().toString();
             String date = Date.getText().toString();
             String address = Address.getText().toString();
             String mobileNo = MobileNo.getText().toString();
             String subject = Subject.getText().toString();



             Intent intent = new Intent();

             intent.putExtra("Name",Name);
             intent.putExtra("F Name",F_Name);
             intent.putExtra("Gender",Gender);
             intent.putExtra("d_title",D_title);
             intent.putExtra("cnic",Cnic);
             intent.putExtra("campus",Campus);
             intent.putExtra("Department",Deepartment);
             intent.putExtra("CGPA",cGPA);
             intent.putExtra("Date",date);
             intent.putExtra("Address",address);
             intent.putExtra("MobileNo",mobileNo);
             intent.putExtra("Subject",subject);
             //startActivity(intent);
            Detail_Form.this.setResult(RESULT_OK, intent);
            Detail_Form.this.finish();
        });

    }
}