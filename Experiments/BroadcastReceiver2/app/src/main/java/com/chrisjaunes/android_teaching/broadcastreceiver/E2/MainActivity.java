package com.chrisjaunes.android_teaching.broadcastreceiver.E2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Button;

import com.chrisjaunes.android_teaching.broadcastreceiver.E2.example.Exp3Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button3 = findViewById(R.id.btn_exp3);
        button3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Exp3Activity.class);
            startActivity(intent);
        });
    }
}