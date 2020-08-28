package com.chrisjaunes.android_teaching.broadcastreceiver.E1.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Exp4Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp4", "Exp4Receiver 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread() + "]");
    }
}
