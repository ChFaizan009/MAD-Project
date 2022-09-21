package com.uog.pk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FormDBMS extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FormData";

    public FormDBMS(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table FormDetails (Name TEXT PRIMARY KEY, " +
                "F_Name TEXT, Gender TEXT, D_Title TEXT, CNIC TEXT, " +
                "Campus TEXT, Department TEXT, Date TEXT, Address TEXT, " +
                "CGPA TEXT, MobileNo TEXT,Subject TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop TABLE if exists FormDetails");
    }



    public boolean insertUserData(String name, String f_Name, String gender, String title,
                                  String cNIC, String campus, String department, String date,
                                  String address, String cGPA, String mobileNo,String subject){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Name", name);
        contentValues.put("F_Name", f_Name);
        contentValues.put("gender", gender);
        contentValues.put("title", title);
        contentValues.put("cNIC", cNIC);
        contentValues.put("campus", campus);
        contentValues.put("department", department);
        contentValues.put("date", date);
        contentValues.put("address", address);
        contentValues.put("cGPA", cGPA);
        contentValues.put("mobileNo", mobileNo);
        contentValues.put("subject", subject);

        //MyDB.insert("FormDetails", null, contentValues);
        long result = MyDB.insert("FormDetails", null, contentValues);
        Log.d("data-1", "ininsert: " +result);
        Log.d("data-1", "ininsert: " +contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean updateUserData(String Name, String F_Name, String Gender, String D_Title,
                                  String CNIC, String Campus, String Department, String Date,
                                  String Address, String CGPA, String MobileNo,String Subject){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Name", Name);
        contentValues.put("F_Name", F_Name);
        contentValues.put("Gender", Gender);
        contentValues.put("Title", D_Title);
        contentValues.put("CNIC", CNIC);
        contentValues.put("Campus", Campus);
        contentValues.put("Department", Department);
        contentValues.put("Date", Date);
        contentValues.put("Address", Address);
        contentValues.put("CGPA", CGPA);
        contentValues.put("MobileNo", MobileNo);
        contentValues.put("Subject", Subject);
        Cursor cursor = MyDB.rawQuery("Select * from FormDetails where F_Name = ?", new String[] {F_Name});

        if (cursor.getCount() > 0) {
            long result = MyDB.update("FormDetails", contentValues, "F_Name=?", new String[]{F_Name});
            if (result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }

    public boolean deleteUserData(String rollNotodel){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from FormDetails where RollNo = ?", new String[] {rollNotodel});

        if (cursor.getCount() > 0) {
            Log.d("data-1", "onCreate: " +"enter del sql method");
            long result = MyDB.delete("FormDetails", "RollNo=?", new String[] {rollNotodel});
            Log.d("data-1", "onCreate: " +"executed del sql method");
            if (result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }


    public Cursor viewUserData(){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from FormDetails", null);
        return cursor;
    }
    public List<Model_Class> ToObject(Cursor cursor){
        List<Model_Class> mylist = new ArrayList<>();
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
        return mylist;
    }

}
