package com.chrisjaunes.android_teaching.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.chrisjaunes.android_teaching.fragment.example.Exp1Activity;
import com.chrisjaunes.android_teaching.fragment.example.Exp2Activity;
import com.chrisjaunes.android_teaching.fragment.example.Exp3Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btn_exp1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp1Activity.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.btn_exp2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp2Activity.class);
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.btn_exp3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp3Activity.class);
                startActivity(intent);
            }
        });


    }
}