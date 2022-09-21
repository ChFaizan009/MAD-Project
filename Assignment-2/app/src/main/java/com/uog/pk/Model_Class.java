package com.uog.pk;

public class Model_Class extends FormApp {
    private int FormID;

    private String Department;
    private String Date;
    private String Address;
    private String CGPA;
    private String MobileNo;
    private String Subject;
    
    public int getFormID() {
        return FormID;
    }

    public void setFormID(int FormID) {
        this.FormID = FormID;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public Model_Class(int FormID, String name, String f_name, String gender, String d_title,
                       String cnic, String campus, String department, String date , String address,
                       String cgpa, String mobileNo, String subject) {
        FormID = FormID;
        super.setName(name);
        super.setF_Name(f_name);
        super.setGender(gender);
        super.setD_Title(d_title);
        super.setCNIC(cnic);
        super.setCampus(campus);
        Department=department;
        this.CGPA = cgpa;
        Date= date;
        Address = address;
        MobileNo = mobileNo;
        Subject=subject;


    }
    public Model_Class(String name, String f_name, String gender, String d_title,
                       String cnic, String campus, String department, String date , String address,
                       String cgpa, String mobileNo, String subject) {
        super.setName(name);
        super.setF_Name(f_name);
        super.setGender(gender);
        super.setD_Title(d_title);
        super.setCNIC(cnic);
        super.setCampus(campus);
        Department=department;
        this.CGPA = cgpa;
        Date= date;
        Address = address;
        MobileNo = mobileNo;
        Subject=subject;
    }
    public Model_Class(String name, String f_name, String gender){
        super.setName(name);
        super.setF_Name(f_name);
        super.setGender(gender);
    }

    @Override
    public String toString() {
        return
                 FormID +
                ", " + super.getName() +
                ", " + super.getF_Name() +
                ", " + super.getGender() +
                ", " + super.getD_Title() +
                ", " + super.getCNIC() +
                ", " + super.getCampus() +
                ", " + Department +
                ", " + CGPA +
                ", " + Date +
                ", " + Address +
                ", " + MobileNo +
                ", " + Subject;


    }
    public String forRead() {
        return
                FormID +
                        ",Name = " + super.getName() +
                        ", Father Name = " + super.getF_Name() +
                        ", Gender = " + super.getGender() +
                        ", Title = " + super.getD_Title() +
                        ",  CNIC = " + super.getCNIC() +
                        ", Campus = " + super.getCampus() +
                        ", Department = " + Department +
                        ", CGPA = " + CGPA +
                        ", Date = " + Date +
                        ", Address = " + Address +
                        ", Mobile No = " + MobileNo +
                        ", Subject = " + Subject;

    }

}
