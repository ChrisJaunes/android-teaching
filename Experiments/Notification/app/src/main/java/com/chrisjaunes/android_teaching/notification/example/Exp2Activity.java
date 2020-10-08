package com.chrisjaunes.android_teaching.notification.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.notification.R;

public class Exp2Activity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private String CHANNEL_ID2;
    private String CHANNEL_ID3;
    private int exp2_3_progress = 0;
    private int exp2_3_progress_max = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp2);
        CHANNEL_ID2 = getString(R.string.channel2_id);
        CHANNEL_ID3 = getString(R.string.channel3_id);

        notificationManager = NotificationManagerCompat.from(this);
        ExpUtils.createNotificationChannel2(Exp2Activity.this, CHANNEL_ID2);
        ExpUtils.createNotificationChannel3(Exp2Activity.this, CHANNEL_ID3);

        Button button1 =  findViewById(R.id.btn_exp2_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notification = Exp2Notification.Exp2_1(Exp2Activity.this, CHANNEL_ID2);
                notificationManager.notify(10, notification);
            }
        });
        Button button2 = findViewById(R.id.btn_exp2_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notification = Exp2Notification.Exp2_2(Exp2Activity.this, CHANNEL_ID2);
                notificationManager.notify(10, notification);
            }
        });

        Button button3 = findViewById(R.id.btn_exp2_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp2_3_progress = (exp2_3_progress + 10) % exp2_3_progress_max;
                Notification notification = Exp2Notification.Exp2_3(Exp2Activity.this, CHANNEL_ID2, exp2_3_progress_max, exp2_3_progress);
                notificationManager.notify(11, notification);
            }
        });

        Button button4 = findViewById(R.id.btn_exp2_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notification = Exp2Notification.Exp2_4(Exp2Activity.this, CHANNEL_ID3);
                notificationManager.notify(12, notification);
            }
        });

        Button button5 = findViewById(R.id.btn_exp2_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                startActivity(intent);
            }
        });

        Button button6 = findViewById(R.id.btn_exp2_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                intent.putExtra(Settings.EXTRA_CHANNEL_ID, getString(R.string.channel3_id));
                startActivity(intent);
            }
        });

        Button button7 = findViewById(R.id.btn_exp2_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.cancel(10);
            }
        });

        Button button8 = findViewById(R.id.btn_exp2_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.cancelAll();
            }
        });
    }


}