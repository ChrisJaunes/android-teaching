package com.chrisjaunes.android_teaching.network;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.network.example.Exp1Activity;
import com.chrisjaunes.android_teaching.network.example.Exp2Activity;
import com.chrisjaunes.android_teaching.network.example.Exp3Activity;
import com.chrisjaunes.android_teaching.network.example.Exp4Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn_exp1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp1Activity.class);
                startActivity(intent);
            }
        });
        Button btn2 = findViewById(R.id.btn_exp2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp2Activity.class);
                startActivity(intent);
            }
        });
        Button btn3 = findViewById(R.id.btn_exp3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp3Activity.class);
                startActivity(intent);
            }
        });
        Button btn4 = findViewById(R.id.btn_exp4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp4Activity.class);
                startActivity(intent);
            }
        });
    }
}