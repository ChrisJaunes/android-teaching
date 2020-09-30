package com.chrisjaunes.android_teaching.notification.example;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;

import androidx.core.app.NotificationCompat;

import com.chrisjaunes.android_teaching.notification.R;

public class Exp1Notification {
    /** Created By ChrisJaunes
     * 本例展示了如何创建一条基本通知
     * @return
     */
    static Notification Exp1_1(Context context, String CHANNEL_ID) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("Exp1_1")
                .setContentText("创建了一条基本通知")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }

    /** Created By ChrisJaunes
     * 本例要求：创建一条自定义时间戳的通知
     * tips：了解setWhen方法、System.currentTimeMillis()方法
     * @return
     */
    static Notification Exp1_2(Context context, String CHANNEL_ID) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("Exp1_2")
                .setContentText("创建一条自定义时间戳的通知")
                .setWhen(System.currentTimeMillis() - 1000000)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }

    /** Created By ChrisJaunes
     * 本例要求：创建一条不显示时间戳的通知
     * tips: 了解setShowWhen方法
     * @return
     */
    static Notification Exp1_3(Context context, String CHANNEL_ID) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("Exp1_3")
                .setContentText("创建一条不显示时间戳的通知")
                .setShowWhen(false)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }

    /** Created By ChrisJaunes
     * 本例要求：创建一条拥有大图标的通知
     * tips：了解setLargeIcon()方法，了解Bitmap, 大图标位于drawable下的notification_icon_large1
     * @return
     */
    static Notification Exp1_4(Context context, String CHANNEL_ID, Bitmap bitmap) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("Exp1_4")
                .setContentText("创建一条拥有大图标的通知")
                .setLargeIcon(bitmap)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }

    /** Created By ChrisJaunes
     * 本例要求：创建一条拥有大文本的通知
     * tips：了解setStyle方法、NotificationCompat.BigTextStyle类
     * @return
     */
    static Notification Exp1_5(Context context, String CHANNEL_ID) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("Exp1_5")
                .setContentText("创建一条拥有大文本的通知")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("这是一个很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长的通知"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }
    /** Created By ChrisJaunes
     * 本例要求：创建一条拥有大图片的通知
     * tips：了解setStyle方法、NotificationCompat.BigPictureStyle类
     * @return
     */
    static Notification Exp1_6(Context context, String CHANNEL_ID, Bitmap bitmap) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_small1)
                .setContentTitle("Exp1_6")
                .setContentText("创建一条拥有大图片的通知")
                .setLargeIcon(bitmap)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap)
                        .bigLargeIcon(null))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }
}
