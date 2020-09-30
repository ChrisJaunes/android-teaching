package com.chrisjaunes.android_teaching.database1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.database1.example.Exp1Activity;
import com.chrisjaunes.android_teaching.database1.example.Exp2Activity;

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
    }
}