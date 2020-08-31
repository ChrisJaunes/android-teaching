package com.chrisjaunes.android_teaching.notification.example;

import android.app.Notification;
import android.content.Context;

import androidx.core.app.NotificationCompat;

import com.chrisjaunes.android_teaching.notification.R;

public class Exp2Notification {
    static Notification Exp2_1(Context context, String CHANNEL_ID) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("这里用来测试通知的更新")
                .setContentText("测试一")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        return builder.build();
    }
    static Notification Exp2_2(Context context, String CHANNEL_ID) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("这里用来测试通知的更新")
                .setContentText("测试二")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        return builder.build();
    }
    static Notification Exp2_3(Context context, String CHANNEL_ID, int progress_max, int progress) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("这里用来测试通知的更新")
                .setProgress(progress_max,progress, false)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        return builder.build();
    }
    static Notification Exp2_4(Context context, String CHANNEL_ID) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("这里用来测试通知的更新")
                .setContentText("测试三")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        return builder.build();
    }
}
