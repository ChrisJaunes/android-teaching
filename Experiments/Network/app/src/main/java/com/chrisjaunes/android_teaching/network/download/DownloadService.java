package com.chrisjaunes.android_teaching.network.download;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.chrisjaunes.android_teaching.network.R;

/** Created by ChirsJaunes
 * 为了保证DownloadTask可以一直在后台运行
 * 参考郭霖大佬的《第一行代码》第二版
 * 利用NotificationManagerCompat.fromh获得一个NotificationManagerCompat对象
 * 由于Android8.0以后通知需要使用渠道，在createNotificationChannel中注册ID为DownloadNotification的渠道
 * 在Binder中定义了供Activity使用的方法
 * 利用DownloadListener提供回调方法
 */
public class DownloadService extends Service {
    static final String channel_id = "DownloadNotification";

    public DownloadBinder mBinder = new DownloadBinder();
    NotificationManagerCompat notificationManagerCompat;

    @Override
    public void onCreate() {
        notificationManagerCompat = NotificationManagerCompat.from(this);
        createNotificationChannel();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class DownloadBinder extends Binder {
        private DownloadTask downloadTask;

        private DownloadListener listener = new DownloadListener() {
            @Override
            public void onProgress(int progress) {
                notificationManagerCompat.notify(1, getNotification("Downloading ...",progress));
            }

            @Override
            public void onSuccess() {
                downloadTask = null;
                stopForeground(true);
                notificationManagerCompat.notify(1,getNotification("Download Success",-1));
                Toast.makeText(DownloadService.this,"下载成功",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed() {
                downloadTask = null;
                stopForeground(true);
                notificationManagerCompat.notify(1,getNotification("Download Failed",-1));
                Toast.makeText(DownloadService.this,"下载失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPaused() {
                downloadTask = null;
                Toast.makeText(DownloadService.this,"下载暂停",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCanceled() {
                downloadTask = null;
                Toast.makeText(DownloadService.this,"下载取消",Toast.LENGTH_SHORT).show();
            }
        };

        public void startDownload(String downloadUrl) {
            if(null == downloadTask) {
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(downloadUrl);
                startForeground(1, getNotification("下载开始，start",0));
            }
        }
        public void pauseDownload() {
            if(null != downloadTask) {
                downloadTask.pauseDownload();
            }
            Toast.makeText(DownloadService.this, "下载暂停，pause", Toast.LENGTH_SHORT).show();
        }
        public void cancelDownload() {
            if (null != downloadTask) {
                downloadTask.cancelDownload();
            }
            notificationManagerCompat.cancel(1);
            stopForeground(true);
            Toast.makeText(DownloadService.this, "下载取消，cancel", Toast.LENGTH_SHORT).show();
        }
    }

    void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(channel_id,"下载",NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription("用于下载服务的通知");
        notificationManagerCompat.createNotificationChannel(channel);
    }

    private Notification getNotification(String title,int progress) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channel_id)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentTitle("Downloading...")
                .setAutoCancel(true);
        if(progress>=0) {
            builder.setContentText(progress+"%");
            builder.setProgress(100,progress,false);
        }
        return builder.build();
    }
}