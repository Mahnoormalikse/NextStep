package com.example.nextstep;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nextstep.model.Customer;
import com.example.nextstep.network.RetrofitClient;
import com.example.nextstep.services.CustomerSignupService;
import com.example.nextstep.ui.login.LoginActivity;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

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
            if (pass.getText().toString().trim().equals(rePass.getText().toString().trim()))
                CustomerSignUp();
            else Toast.makeText(this, "Check confirm password", Toast.LENGTH_SHORT).show();
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

        CustomerSignupService service = RetrofitClient.getClient().create(CustomerSignupService.class);
        Customer customer = new Customer(name.getText().toString(), email.getText().toString(), pass.getText().toString());
        Call<JsonObject> call = service.customer_signup(customer);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    try {
                        JSONObject object = new JSONObject(response.body().getAsJsonObject().toString());
                        Toast.makeText(SignupActivity.this, "" + object.getString("message"), Toast.LENGTH_SHORT).show();
                        /*Git test*/

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progressDialog.dismiss();
                t.printStackTrace();
                Toast.makeText(SignupActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}

