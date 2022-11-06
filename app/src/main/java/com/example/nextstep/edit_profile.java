package com.example.nextstep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class edit_profile extends AppCompatActivity {
    EditText name1, email1, gender1;
    Button savebt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        initViews();
        iniVariables();
        setUpClicks();
    }

    private void initViews() {
        name1 = findViewById(R.id.name1);
        email1 = findViewById(R.id.email1);
        gender1 = findViewById(R.id.gender1);
        savebt = findViewById(R.id.savebt);
    }

    private void iniVariables() {

    }

    private void setUpClicks() {
        savebt.setOnClickListener(view -> {
         /*   if (pass.getText().toString().trim().equals(rePass.getText().toString().trim()))
                CustomerSignUp();
            else Toast.makeText(this, "Check confirm password", Toast.LENGTH_SHORT).show();*/
            createTprofile();
        });
    }


}