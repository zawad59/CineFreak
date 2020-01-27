package com.example.bintu.cinefreak;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static int SPLASH_TIME_OUT=3000;
    //DatabaseHandler d=new DatabaseHandler(this);
   // d.onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run()
            {
                Intent loginIntent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
