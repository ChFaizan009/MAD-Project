package com.uog.pk;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyDBForm {
    private static final String FILE_NAME = "Forms.txt";

    public static void writeToFile(Context context, Model_Class model) {
        File path = context.getFilesDir();
        try {
//            new FileWriter(new File(context.getFilesDir(), "rsapplications.csv"), false).close();
            BufferedWriter bo = new BufferedWriter(new FileWriter(new File(path, FILE_NAME), true));
            bo.write(model.toString());
            Log.d("data-1", "onCreate: " + model.toString());
            bo.newLine();
            bo.flush();
            bo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Model_Class> readFromFile(Context context) {
        //Log.d("data-1", "onCreate: " + "called readfromfile");
        List<Model_Class> Modelsss = new ArrayList<>();
        File path = context.getFilesDir();
        File readFrom = new File(path, FILE_NAME);
        try {
            BufferedReader br = new BufferedReader(new FileReader(readFrom));
            String line = "";
            while ((line = br.readLine()) != null) {
                Model_Class Mymodel = LinetoModel(line);
                Modelsss.add(Mymodel);
               // Log.d("data-1", "onCreate: " + "called readfromfile");
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Modelsss;
    }
    public static Model_Class LinetoModel(String data){
        String[] values = data.split(",");
        int ID =Integer.parseInt(values[0].trim());
        String Name = values[1].trim();
        String fname = values[2].trim();
        String gender  = values[3].trim();
        String title  = values[4].trim();
        String campus  = values[5].trim();
        String CNIC = values[6].trim();
        String Dept  = values[7].trim();
        String date = values[8].trim();
        String address  = values[9].trim();
        String cpga = values[10].trim();
        String mobile  = values[11].trim();
        String subject = values[12].trim();
        Model_Class mymodel = new Model_Class(ID,Name,fname,gender,title,campus,
                CNIC,Dept,date,address,cpga,
                mobile,subject);
        return mymodel;
    }
    public static Model_Class FindOne(int Model_ID, Context context){

        List<Model_Class> models = new ArrayList<Model_Class>();
        String line;
        File path = context.getFilesDir();
        File readFrom = new File(path, FILE_NAME);
        try {
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(new FileReader(readFrom));

            while ((line = br.readLine()) != null) {
                Model_Class Mymodel = LinetoModel(line);
                if (Mymodel.getFormID() == Model_ID)
                    models.add(Mymodel);


                return Mymodel;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    return null;
    }
    public static Model_Class DelOne(int Model_ID) {

        FileWriter filewriter;
        List<Model_Class> persons = FindAll();
        Context context = null;
        Model_Class person = MyDBForm.FindOne(Model_ID,context);
        try {
            filewriter = new FileWriter(FILE_NAME);

            for(int i=0;i<persons.size();i++) {
                if(persons.get(i).getFormID()!=Model_ID) {
                    filewriter.append(persons.get(i).toString());
                    filewriter.append("\n");
                }
            }
            persons.add(person);
            filewriter.flush();
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return person;
    }
    public static List<Model_Class> FindAll(){
        List<Model_Class> models= new ArrayList<Model_Class>();
        String line ;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
            while((line=bufferedReader.readLine()) != null) {
                Model_Class Mymodel = LinetoModel(line);
                models.add(Mymodel);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return models;
    }
}
