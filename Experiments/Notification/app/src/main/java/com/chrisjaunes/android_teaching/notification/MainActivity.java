package com.chrisjaunes.android_teaching.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.notification.example.Exp1Activity;
import com.chrisjaunes.android_teaching.notification.example.Exp2Activity;
import com.chrisjaunes.android_teaching.notification.example.Exp3Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_exp1 = findViewById(R.id.btn_exp1);
        btn_exp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp1Activity.class);
                startActivity(intent);
            }
        });
        Button btn_exp2 = findViewById(R.id.btn_exp2);
        btn_exp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp2Activity.class);
                startActivity(intent);
            }
        });
        Button btn_exp3 = findViewById(R.id.btn_exp3);
        btn_exp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp3Activity.class);
                startActivity(intent);
            }
        });
    }
}