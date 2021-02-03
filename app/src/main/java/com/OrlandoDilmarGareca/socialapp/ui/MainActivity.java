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
import com.OrlandoDilmarGareca.socialapp.common.Constantes;
import com.OrlandoDilmarGareca.socialapp.common.SharedPreferencesManager;
import com.OrlandoDilmarGareca.socialapp.retrofit.MiniTwitterClient;
import com.OrlandoDilmarGareca.socialapp.retrofit.MiniTwitterService;
import com.OrlandoDilmarGareca.socialapp.retrofit.Request.RequestLogin;
import com.OrlandoDilmarGareca.socialapp.retrofit.Response.ResponseAuth;
import com.OrlandoDilmarGareca.socialapp.retrofit.Response.ResponseLogin;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView tvGoSignUp;
    EditText etEmail, etPassword;
    MiniTwitterClient miniTwitterClient;
    MiniTwitterService miniTwitterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        retrofitInit();
        findViews();
        events();
    }

    private void retrofitInit() {
        miniTwitterClient = MiniTwitterClient.getInstance();
        miniTwitterService = miniTwitterClient.getMiniTwitterService();

    }


    private void findViews() {
        btnLogin = findViewById(R.id.buttonLogin);
        tvGoSignUp = findViewById(R.id.textViewGoSignUp);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
    }

    private void events() {
        btnLogin.setOnClickListener(this);
        tvGoSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.buttonLogin:
                goToLogin();
                break;
            case R.id.textViewGoSignUp:
                goToSignUp();
                break;
        }

    }

    private void goToLogin() {
        String username = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (username.isEmpty()) {
            etEmail.setError(("El email es requerida"));
        } else if (password.isEmpty()) {
            etEmail.setError(("La contraseña es requerida"));
        } else {
//            Toast.makeText(this, ""+username+password, Toast.LENGTH_SHORT).show();
            RequestLogin requestLogin = new RequestLogin(username, password);


            Call<ResponseLogin> call = miniTwitterService.doLogin(requestLogin);
            call.enqueue(new Callback<ResponseLogin>() {
                @Override
                public void onResponse(Call<ResponseLogin> call, @NotNull Response<ResponseLogin> response) {
                    if (response.isSuccessful()) {

                        Toast.makeText(MainActivity.this, "Inicio Correctamente.!", Toast.LENGTH_SHORT).show();
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_TOKEN, response.body().getToken());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_USERNAME, response.body().getUsername());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_EMAIL, response.body().getEmail());
                        SharedPreferencesManager.setSomeStringValue(Constantes.PREF_IMAGE, response.body().getImage());

                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        //destruimos activity para que no se pueda volver.
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Algo salio mal, revise sus datos de acceso", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "[Problemas de conexion. Intente denuevo] " + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    private void goToSignUp() {
        Intent i = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(i);
        finish();
    }
}