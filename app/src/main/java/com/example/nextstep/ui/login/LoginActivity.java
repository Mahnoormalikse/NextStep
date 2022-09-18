package com.example.nextstep.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nextstep.R;
import com.example.nextstep.SignupActivity;

public class LoginActivity extends AppCompatActivity {
    TextView signupTv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        signupTv = findViewById(R.id.loginSignupTv);
        signupTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(signupIntent);
                finish();
            }

        });
    }
}
