package com.chrisjaunes.android_teaching.service.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.service.R;

public class Exp1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp1);

        final Button btn_exp1_start_service = findViewById(R.id.btn_exp1_start_service);
        btn_exp1_start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp1", "Exp1Activity 启动了服务 Exp1Service");
                Intent intent = new Intent(Exp1Activity.this, Exp1Service.class);
                startService(intent);
            }
        });
        final Button btn_exp1_stop_service = findViewById(R.id.btn_exp1_stop_service);
        btn_exp1_stop_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp1", "Exp1Activity 停止了服务 Exp1Service");
                Intent intent = new Intent(Exp1Activity.this, Exp1Service.class);
                stopService(intent);
            }
        });
    }
}