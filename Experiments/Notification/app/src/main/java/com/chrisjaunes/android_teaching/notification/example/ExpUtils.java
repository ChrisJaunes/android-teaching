package com.chrisjaunes.android_teaching.notification.example;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationManagerCompat;

import com.chrisjaunes.android_teaching.notification.R;

public class ExpUtils {
    /** Created By ChrisJaunes
     * 本处用于创建通知渠道
     */
    static void createNotificationChannel1(Context context, String CHANNEL_ID1) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = context.getString(R.string.channel1_name);
            String description = context.getString(R.string.channel1_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID1, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    /** Created By ChrisJaunes
     * 本处用于创建通知渠道
     * 了解NotificationChannel的构造函数、getSystemService服务、setDescription方法
     */
    static void createNotificationChannel2(Context context, String CHANNEL_ID2) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = context.getString(R.string.channel2_name);
            String description = context.getString(R.string.channel2_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID2, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    /** Created By ChrisJaunes
     * 本处用于构造一个更重要程度的渠道
     * tips：了解IMPORTANCE_HIGH
     */
    static void createNotificationChannel3(Context context, String CHANNEL_ID3) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = context.getString(R.string.channel3_name);
            String description = context.getString(R.string.channel3_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID3, name, importance);
            channel.setDescription(description);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
