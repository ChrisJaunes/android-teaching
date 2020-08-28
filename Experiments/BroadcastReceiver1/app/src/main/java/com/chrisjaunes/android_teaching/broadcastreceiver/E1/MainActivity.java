package com.chrisjaunes.android_teaching.broadcastreceiver.E1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.broadcastreceiver.E1.example.Exp1Activity;
import com.chrisjaunes.android_teaching.broadcastreceiver.E1.example.Exp2Activity;
import com.chrisjaunes.android_teaching.broadcastreceiver.E1.example.Exp3Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Exp0", "基本信息: [当前线程: " + Thread.currentThread() + "]");

        Button btn_Exp1 = findViewById(R.id.btn_exp1);
        btn_Exp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp1Activity.class);
                startActivity(intent);
            }
        });
        Button btn_Exp2 = findViewById(R.id.btn_exp2);
        btn_Exp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp2Activity.class);
                startActivity(intent);
            }
        });
        Button btn_Exp3 = findViewById(R.id.btn_exp3);
        btn_Exp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exp3Activity.class);
                startActivity(intent);
            }
        });
    }
}