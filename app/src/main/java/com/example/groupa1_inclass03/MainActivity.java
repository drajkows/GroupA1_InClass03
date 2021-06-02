package com.example.groupa1_inclass03;
/*
* InClass03
* Group A1 - Deanna Rajkowski and Kris Bowen
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TAG = "InClass03";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        setTitle("Registration");

        //From Registration Activity, click on "Select" to move to the Department activity
        findViewById(R.id.selectButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDeptActivity = new Intent(MainActivity.this, DepartmentActivity.class);
                startActivity(intentDeptActivity);
            }
        });

        //From Registration Activity, click on "Submit" to move to the Profile activity
        findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSubmit = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intentSubmit);
            }
        });


        //look for intent from Department to receive the department of choice
        if(getIntent() !=null && getIntent().getExtras() != null && getIntent().hasExtra(DepartmentActivity.DEPT_KEY)){
            String dept = getIntent().getStringExtra(DepartmentActivity.DEPT_KEY);

            TextView deptResult = findViewById(R.id.deptSelectText);
            deptResult.setText(dept);
        }
    }//end of onCreate

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: ");

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause: ");


    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop: ");
    }

}