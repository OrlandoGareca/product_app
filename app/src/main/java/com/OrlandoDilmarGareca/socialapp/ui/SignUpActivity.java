package com.OrlandoDilmarGareca.socialapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.OrlandoDilmarGareca.socialapp.R;
import com.OrlandoDilmarGareca.socialapp.retrofit.MiniTwitterClient;
import com.OrlandoDilmarGareca.socialapp.retrofit.MiniTwitterService;
import com.OrlandoDilmarGareca.socialapp.retrofit.Request.RequestSignup;
import com.OrlandoDilmarGareca.socialapp.retrofit.Response.ResponseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSignUp;
    TextView tvGoLogin;
    EditText etUsername, etEmail, etPassword;
    MiniTwitterClient miniTwitterClient;
    MiniTwitterService miniTwitterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        retrofitInit();
        findViews();
        events();
    }

    private void retrofitInit() {
        miniTwitterClient = MiniTwitterClient.getInstance();
        miniTwitterService = miniTwitterClient.getMiniTwitterService();
    }

    private void events() {
        btnSignUp.setOnClickListener(this);
        tvGoLogin.setOnClickListener(this);

    }

    private void findViews() {
        btnSignUp = findViewById(R.id.buttonSignUp);
        tvGoLogin = findViewById(R.id.textViewGoLogin);
        etUsername = findViewById(R.id.editTextNombre);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.buttonSignUp:
                gotoSignUp();
                break;
            case R.id.textViewGoLogin:
                goToLogin();
                break;
        }

    }

    private void gotoSignUp() {
        String username = etUsername.getText().toString();
        String name = etUsername.getText().toString();
        String last_name = etUsername.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (username.isEmpty()){
            etUsername.setError("El nombre de usuario es requerido");
        } else if (email.isEmpty()){
            etEmail.setError("El email es requerido");
        } else if (password.isEmpty() || password.length() < 4) {
            etPassword.setError("La contraseña es requerida y debe tener al menos 4 catacteres");
        } else {
            RequestSignup requestSignup = new RequestSignup(username,email,password,name,last_name);
            Call<ResponseAuth> call = miniTwitterService.doSignUp(requestSignup);

            call.enqueue(new Callback<ResponseAuth>() {
                @Override
                public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                    if (response.isSuccessful()){
                        Intent i = new Intent(SignUpActivity.this,DashboardActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Algo ha salido mal, revise los datos de registro"+response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseAuth> call, Throwable t) {
                    Toast.makeText(SignUpActivity.this, "Error en la conexcion. Intente nuevamente"+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void goToLogin() {
        Intent i = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}