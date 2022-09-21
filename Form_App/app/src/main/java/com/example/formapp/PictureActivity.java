package com.example.formapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);


        @Override
                public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this,PictureActivity.class);

            startActivity(intent);
        }
    }
}