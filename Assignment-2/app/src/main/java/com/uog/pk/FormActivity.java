package com.uog.pk;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FormActivity extends AppCompatActivity {

    List<Model_Class> mylist ;
    FormAdapter myadapter;
    RecyclerView recyclerView;
    FormDBMS db;
    public void calldelondetail(String roll){
        db.deleteUserData(roll);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        recyclerView = findViewById(R.id.rvListItems);
        mylist = new ArrayList<>();
        db = new FormDBMS(this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Cursor cursor = new FormDBMS(this).viewUserData();
        myadapter = new FormAdapter();

        while (cursor.moveToNext()){
            Model_Class obj = new Model_Class(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6),
                    cursor.getString(7), cursor.getString(8),
                    cursor.getString(9), cursor.getString(10),
                    cursor.getString(11));
            mylist.add(obj);

        }
        myadapter.setNocModels(mylist);
        Log.d("data-1", "onCreate: " + "oo");
        recyclerView.setAdapter(myadapter);

        findViewById(R.id.btnadd).setOnClickListener(v ->{
            Intent intent = new Intent(FormActivity.this, Detail_Form.class);
            startActivityForResult(intent,345);

        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 345 )
        {
            if(resultCode != RESULT_CANCELED) {

                String Name = data.getStringExtra("Name");
                String SoORdo = data.getStringExtra("Father Name");
                String RegistrationNo = data.getStringExtra("Gender");
                String RollNo = data.getStringExtra("Title");
                String Department = data.getStringExtra("CNIC");
                String Program = data.getStringExtra("Campus");
                String DegreeStatus = data.getStringExtra("Department");
                String CGPA = data.getStringExtra("Date");
                String InstituteWhereStudied = data.getStringExtra("Address");
                String InstituteMigratedTo = data.getStringExtra("CGPA");
                String NocDepositedFee = data.getStringExtra("MobileNo");
                String ChallanNo = data.getStringExtra("Subject");

                mylist.add(new Model_Class(Name, SoORdo, RegistrationNo,RollNo,
                        Department,Program,DegreeStatus,CGPA,InstituteWhereStudied,InstituteMigratedTo,
                        NocDepositedFee,ChallanNo));
                Boolean checkInsertData = db.insertUserData(Name, SoORdo, RegistrationNo,RollNo,
                        Department,Program,DegreeStatus,CGPA,InstituteWhereStudied,InstituteMigratedTo,
                        NocDepositedFee,ChallanNo);
                Log.d("data-1", "onCreate: " +checkInsertData);

                if (checkInsertData == true){
                    Toast.makeText(FormActivity.this, "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(FormActivity.this, "Data  Inserted!", Toast.LENGTH_SHORT).show();
                }

                myadapter.notifyDataSetChanged();
            }
        }


    }

}