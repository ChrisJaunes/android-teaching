package com.chrisjaunes.android_teaching.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.service.example.Exp1Activity;
import com.chrisjaunes.android_teaching.service.example.Exp2Activity;
import com.chrisjaunes.android_teaching.service.example.Exp3Activity;
import com.chrisjaunes.android_teaching.service.example.Exp4Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_exp1 = findViewById(R.id.btn_exp1);
        btn_exp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Exp1Activity.class);
                startActivity(intent);
            }
        });

        final Button btn_exp2 = findViewById(R.id.btn_exp2);
        btn_exp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Exp2Activity.class);
                startActivity(intent);
            }
        });

        final Button btn_exp3 = findViewById(R.id.btn_exp3);
        btn_exp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Exp3Activity.class);
                startActivity(intent);
            }
        });

        final Button btn_exp4 = findViewById(R.id.btn_exp4);
        btn_exp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Exp4Activity.class);
                startActivity(intent);
            }
        });
    }
}