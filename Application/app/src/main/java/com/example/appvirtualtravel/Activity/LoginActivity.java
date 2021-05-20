package com.example.appvirtualtravel.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appvirtualtravel.R;

public class LoginActivity extends AppCompatActivity {

    Button btnDangKy;
    Button btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnDangKy =(Button) findViewById(R.id.btnDangKy);
        btnDangNhap =(Button) findViewById(R.id.btnDangNhap);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }


}