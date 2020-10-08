package com.chrisjaunes.android_teaching.service.example;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.chrisjaunes.android_teaching.service.R;

public class Exp3Service extends Service {
    public Exp3Service() {
    }
    @Override
    public void onCreate() {
        Log.i("Exp3", "Exp3Service 开启了一个服务");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
        int fg = intent.getIntExtra("Argv", 0);
        switch (fg) {
            case 0: Log.i("Exp3","Exp3Service 是一个 后台服务"); break;
            case 1: Log.i("Exp3","Exp3Service 调用了 startForeground");
            Notification notification = new NotificationCompat.Builder(this, getString(R.string.CHANNELID))
                            .setContentTitle("实验三")
                            .setContentText("这是一个前台服务")
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .build();
                startForeground(1, notification);
                break;
            case 2:
                Log.i("Exp3","Exp3Service 调用了 stopForeground");
                stopForeground(true);
                break;
            case 3:
                Log.i("Exp3","Exp3Service 调用了 stopSelf");
                stopSelf();
        }
        return super.onStartCommand(intent, flags, startid);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Exp3", "Exp3Service 调用了 onDestroy");
    }
}
