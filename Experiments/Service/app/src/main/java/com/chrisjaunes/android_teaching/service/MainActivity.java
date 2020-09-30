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
import com.chrisjaunes.android_teaching.service.example.Exp5Activity;
import com.chrisjaunes.android_teaching.service.exp.DownloadActivity;
import com.chrisjaunes.android_teaching.service.exp.MusicActivity;

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

        final Button btn_exp5 = findViewById(R.id.btn_exp5);
        btn_exp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Exp5Activity.class);
                startActivity(intent);
            }
        });

        final Button btn_expA = findViewById(R.id.btn_expA);
        btn_expA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), DownloadActivity.class);
                startActivity(intent);
            }
        });

        final Button btn_expB = findViewById(R.id.btn_expB);
        btn_expB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MusicActivity.class);
                startActivity(intent);
            }
        });
    }
}