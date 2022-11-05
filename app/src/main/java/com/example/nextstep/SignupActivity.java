package com.example.nextstep;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nextstep.model.Customer;
import com.example.nextstep.network.RetrofitCongClass;
import com.example.nextstep.services.Retrofit_Interface;
import com.example.nextstep.ui.login.LoginActivity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    TextView loginTv;
    Customer customer;
    ProgressDialog progressDialog;
    EditText name, email, pass, rePass;
    Button createAcc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        loginTv = findViewById(R.id.signupLogintv);
        initViews();
        iniVariables();
        setUpClicks();
    }

    private void iniVariables() {

    }

    private void setUpClicks() {
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(signupIntent);
                finish();
            }
        });
        createAcc.setOnClickListener(view -> {
         /*   if (pass.getText().toString().trim().equals(rePass.getText().toString().trim()))
                CustomerSignUp();
            else Toast.makeText(this, "Check confirm password", Toast.LENGTH_SHORT).show();*/
            CustomerSignUp();
        });

    }

    private void initViews() {
        name = findViewById(R.id.nameEt);
        email = findViewById(R.id.emailEt);
        pass = findViewById(R.id.passEt);
        rePass = findViewById(R.id.repassEt);
        createAcc = findViewById(R.id.signupBtn);
    }

    public void CustomerSignUp() {
        customer = new Customer();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Registration");
        progressDialog.setMessage("please wait...");
        progressDialog.show();
        progressDialog.setCancelable(false);
        RetrofitCongClass.getClient().register(name.getText().toString(),
                        email.getText().toString(), pass.getText().toString())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        if (response.isSuccessful()) {
                            progressDialog.dismiss();
                            try {
                                JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                                Boolean error = jsonObject.getBoolean("error");
                                String message = jsonObject.getString("message");
                                if(error){
                                    Toast.makeText(SignupActivity.this, message, Toast.LENGTH_SHORT).show();
                                }else {

                                    Toast.makeText(SignupActivity.this, message, Toast.LENGTH_SHORT).show();
                                }
                                Log.d("RegResponse", "onResponse: "+jsonObject);

                            }catch (Exception exception){
                                Toast.makeText(SignupActivity.this, exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        progressDialog.dismiss();
                        Log.d("RegResponse", "onFailure: "+t.getLocalizedMessage());
                        //t.printStackTrace();
                        // Toast.makeText(SignupActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}

