package com.chrisjaunes.android_teaching.notification.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Exp3BroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Exp3", "Exp3 接收了通知" +  context);
        Toast.makeText(context, "Exp3Receiver已接收，可以在此广播接收器内处理信息", Toast.LENGTH_SHORT).show();
    }
}
