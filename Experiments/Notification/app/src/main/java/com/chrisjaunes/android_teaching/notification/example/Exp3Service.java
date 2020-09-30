package com.chrisjaunes.android_teaching.notification.example;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.chrisjaunes.android_teaching.notification.MainActivity;
import com.chrisjaunes.android_teaching.notification.R;

public class Exp3Service extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("Exp3", "Exp3 接收了通知" );
        Toast.makeText(this, "Exp3Service已启动，可以在此服务中处理消息", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
