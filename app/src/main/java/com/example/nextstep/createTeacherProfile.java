package com.example.nextstep;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nextstep.R;

public class createTeacherProfile extends AppCompatActivity {
    EditText teachername, teacherquali, teachergender;
    Button createprofilebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);
        initViews();
        iniVariables();
        setUpClicks();

    }

    private void initViews() {
        teachername = findViewById(R.id.teachername);
        teacherquali = findViewById(R.id.teacherquali);
        teachergender = findViewById(R.id.teachergender);
        createprofilebtn = findViewById(R.id.createprofilebtn);
    }

    private void iniVariables() {
    }

    private void setUpClicks() {

    }
}