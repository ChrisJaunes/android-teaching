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

public class Exp1Activity extends AppCompatActivity {
    private String CHANNEL_ID1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp1);

        ignoreIt();
    }

    /** Create By ChrisJaunes
     * 本处不是本实验(EXP1)的重点,可以选择忽略掉这部分
     */
    private void ignoreIt() {
        CHANNEL_ID1 = getString(R.string.channel1_id);
        createNotificationChannel();
        final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        Button button1 = findViewById(R.id.btn_exp1_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notification notification = Exp1Notification.Exp1_1(Exp1Activity.this, CHANNEL_ID1);
                    notificationManager.notify(1, notification);
                }catch (Exception e) {
                    Toast.makeText(Exp1Activity.this, "您的Exp1_1没有正确创建", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button2 = findViewById(R.id.btn_exp1_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notification notification = Exp1Notification.Exp1_2(Exp1Activity.this, CHANNEL_ID1);
                    notificationManager.notify(2, notification);
                }catch (Exception e) {
                    Toast.makeText(Exp1Activity.this, "您的Exp1_2没有正确创建", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button3 = findViewById(R.id.btn_exp1_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notification notification = Exp1Notification.Exp1_3(Exp1Activity.this, CHANNEL_ID1);
                    notificationManager.notify(3, notification);
                }catch (Exception e) {
                    Toast.makeText(Exp1Activity.this, "您的Exp1_3没有正确创建", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button4 = findViewById(R.id.btn_exp1_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notification notification = Exp1Notification.Exp1_4(Exp1Activity.this, CHANNEL_ID1,
                            BitmapFactory.decodeResource(getResources(), R.drawable.notification_icon_large1));
                    notificationManager.notify(4, notification);
                }catch (Exception e) {
                    Toast.makeText(Exp1Activity.this, "您的Exp1_4没有正确创建", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button5 = findViewById(R.id.btn_exp1_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notification notification = Exp1Notification.Exp1_5(Exp1Activity.this, CHANNEL_ID1);
                    notificationManager.notify(5, notification);
                }catch (Exception e) {
                    Toast.makeText(Exp1Activity.this, "您的Exp1_5没有正确创建", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button button6 = findViewById(R.id.btn_exp1_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notification notification = Exp1Notification.Exp1_6(Exp1Activity.this, CHANNEL_ID1,
                            BitmapFactory.decodeResource(getResources(), R.drawable.notification_icon_large1));
                    notificationManager.notify(6, notification);
                }catch (Exception e) {
                    Toast.makeText(Exp1Activity.this, "您的Exp1_5没有正确创建", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /** Create By ChrisJaunes
     * 本处用于创建通知渠道，具体使用参见后续实验，而在本实验中，可以选择忽略掉这部分
     */
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel1_name);
            String description = getString(R.string.channel1_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID1, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }
}