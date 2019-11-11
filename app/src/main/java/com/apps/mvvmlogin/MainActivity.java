package com.apps.mvvmlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.mvvmlogin.response.SignInResponse;
import com.apps.mvvmlogin.viewmodels.SignInViewModel;

public class MainActivity extends AppCompatActivity {

    EditText email_et, password_et;
    SignInViewModel signInViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_et = findViewById(R.id.etEmail);
        password_et = findViewById(R.id.etPassword);

        signInViewModel = new ViewModelProvider(this).get(SignInViewModel.class);


        findViewById(R.id.SignIn_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(email_et.getText().toString())&& !TextUtils.isEmpty(password_et.getText().toString())){
                    SignInApiCall(email_et.getText().toString(),password_et.getText().toString());
                }
                else
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void SignInApiCall(String email, String password) {
        signInViewModel.getResponse(email, password, "1", "q213131").observe(this, new Observer<SignInResponse>() {
            @Override
            public void onChanged(SignInResponse signInResponse) {
                String status = signInResponse.getStatus();
                String message = signInResponse.getMessage();

                if (status.equalsIgnoreCase("SUCCESS")) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
