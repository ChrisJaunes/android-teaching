package com.chrisjaunes.android_teaching.notification.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chrisjaunes.android_teaching.notification.R;

public class Exp3Activity extends AppCompatActivity {
    private String CHANNEL_ID3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp3);

        ignoreIt();
    }
    /** Created By ChrisJaunes
     * 本处不是本实验(EXP3)的重点,已经在实验EXP2中进行学习，可以选择忽略掉这部分
     */
    private void ignoreIt() {
        CHANNEL_ID3 = getString(R.string.channel3_id);
        final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        ExpUtils.createNotificationChannel3(Exp3Activity.this, CHANNEL_ID3);

        Button button1 = findViewById(R.id.btn_exp3_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notification notification = Exp3Notification.Exp3_1(Exp3Activity.this, CHANNEL_ID3);
                    notificationManager.notify(20, notification);
                }catch (Exception e) {
                    Toast.makeText(Exp3Activity.this, "您的Exp3_1没有正确创建", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button2 = findViewById(R.id.btn_exp3_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notification notification = Exp3Notification.Exp3_2(Exp3Activity.this, CHANNEL_ID3);
                    notificationManager.notify(21, notification);
                }catch (Exception e) {
                    Toast.makeText(Exp3Activity.this, "您的Exp3_2没有正确创建", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button3 = findViewById(R.id.btn_exp3_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notification notification = Exp3Notification.Exp3_3(Exp3Activity.this, CHANNEL_ID3);
                    notificationManager.notify(22, notification);
                }catch (Exception e) {
                    Toast.makeText(Exp3Activity.this, "您的Exp3_3没有正确创建", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}