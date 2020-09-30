package com.chrisjaunes.android_teaching.notification.example;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import com.chrisjaunes.android_teaching.notification.R;

public class Exp1Service extends Service {
    public Exp1Service() {
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Notification notification =new NotificationCompat.Builder(this, getString(R.string.channel1_id))
                .setContentTitle("前台服务")
                .setContentText("这是前台服务")
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setTicker("前台服务")
                .build();

        startForeground(7,notification);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
