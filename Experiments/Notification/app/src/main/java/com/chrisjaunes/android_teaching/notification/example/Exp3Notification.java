package com.chrisjaunes.android_teaching.notification.example;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.chrisjaunes.android_teaching.notification.MainActivity;
import com.chrisjaunes.android_teaching.notification.R;

public class Exp3Notification {
    /** Create By ChrisJaunes
     * 本例展示了如何创建一条能够具有点按功能的通知
     * @return
     */
    static Notification Exp3_1(Context context, String CHANNEL_ID) {
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("Exp3_1")
                .setContentText("了解通知的点按操作")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        return builder.build();
    }
    /** Create By ChrisJaunes
     * 本例展示了如何创建一条能够具有操作按钮的通知
     * @return
     */
    static Notification Exp3_2(Context context, String CHANNEL_ID) {
        Intent intent1 = new Intent(context, Exp3Activity.class);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(context, 0, intent1, 0);

        Intent intent2 = new Intent(context, Exp3BroadcastReceiver.class);
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(context, 0, intent2, 0);

        Intent intent3 = new Intent(context, Exp3Service.class);
        PendingIntent pendingIntent3 = PendingIntent.getService(context, 0, intent3, 0);
        NotificationCompat.Action action3 = new NotificationCompat.Action.Builder(R.drawable.ic_jump, "启动一个服务", pendingIntent3).build();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("EXP3_2")
                .setContentText("了解为通知添加按钮")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent1)
                .addAction(R.drawable.ic_jump, "发送一个广播", pendingIntent2)
                .addAction(action3);
        return builder.build();
    }
    /** Create By ChrisJaunes
     * 本例展示了如何创建一条能够关联全屏活动的通知
     * @return
     */
    static Notification Exp3_3(Context context, String CHANNEL_ID) {
        Intent fullScreenIntent = new Intent(context, EmptyActivity.class);
        PendingIntent fullScreenPendingIntent = PendingIntent.getActivity(context, 0,
                fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("Exp3")
                .setContentText("显示紧急消息")
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setFullScreenIntent(fullScreenPendingIntent, true);
        return builder.build();
    }
}
