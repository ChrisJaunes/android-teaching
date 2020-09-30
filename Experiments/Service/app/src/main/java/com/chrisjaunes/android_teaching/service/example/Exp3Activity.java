package com.chrisjaunes.android_teaching.service.example;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.service.R;

public class Exp3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp3);

        ignoreIt();

        Button button0 = findViewById(R.id.btn_exp3_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exp3Activity.this, Exp3Service.class);
                intent.putExtra("Argv", 0);
                startService(intent);
            }
        });
        Button button1 = findViewById(R.id.btn_exp3_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exp3Activity.this, Exp3Service.class);
                intent.putExtra("Argv", 1);
                startService(intent);
            }
        });
        Button button2 = findViewById(R.id.btn_exp3_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exp3Activity.this, Exp3Service.class);
                intent.putExtra("Argv", 2);
                startService(intent);
            }
        });
        Button button3 = findViewById(R.id.btn_exp3_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exp3Activity.this, Exp3Service.class);
                intent.putExtra("Argv", 3);
                startService(intent);
            }
        });
    }

    /** Create BY ChrisJaunes
     * 以下内容不是本次实验重点，可以选择性忽略
     */
    private void ignoreIt() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = getString(R.string.CHANNELNAME);
            CharSequence name = getString(R.string.CHANNELNAME);
            String description = getString(R.string.CHANNELDESC);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(id, name, importance);
            channel.setDescription(description);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.createNotificationChannel(channel);
        }
    }
}