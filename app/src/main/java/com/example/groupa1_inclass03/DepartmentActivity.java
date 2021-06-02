package com.example.groupa1_inclass03;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DepartmentActivity extends AppCompatActivity {

    private RadioButton deptButton;
    final static public String DEPT_KEY = "testdept";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        setTitle("Department");

        RadioGroup deptGroup = findViewById(R.id.departmentGroup);


        //department info is retrieved by clicking the "Select" button
        //need toast messaging for invalid inputs
        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                int selectedDept = deptGroup.getCheckedRadioButtonId();
                deptButton = (RadioButton) findViewById(selectedDept);

                Intent intent = new Intent(DepartmentActivity.this, MainActivity.class);
                String departmentText = deptButton.getTransitionName();
                intent.putExtra(DEPT_KEY, departmentText);
                setResult(RESULT_OK, intent);

                finish();
            }
        });




        //from Department Activity, click on Cancel button to go back to Registration
        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}