package com.chrisjaunes.android_teaching.notification.example;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import com.chrisjaunes.android_teaching.notification.MainActivity;
import com.chrisjaunes.android_teaching.notification.R;

public class Exp3Service extends Service {
    @Override
    public void onCreate() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, getString(R.string.channel3_id))
                        .setContentTitle("前台服务")
                        .setContentText("这是前台服务")
                        .setSmallIcon(R.drawable.notification_icon_small1)
                        .setContentIntent(pendingIntent)
                        .setTicker("前台")
                        .build();

        startForeground(40, notification);
    }
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
