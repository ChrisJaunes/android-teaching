package com.chrisjaunes.android_teaching.broadcastreceiver.E1.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class Exp3Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp3", "Exp2Receiver 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread()
                + "], 实例为: " + this);
    }
}
class Exp3Receiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp3", "Exp2Receiver1 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread()
                + "], 实例为: " + this);
        //abortBroadcast();
    }
}
class Exp3Receiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp3", "Exp2Receiver2 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread()
                + "], 实例为: " + this);
        //abortBroadcast();
    }
}
class Exp3Receiver3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp3", "Exp2Receiver3 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread()
                + "], 实例为: " + this);
        //abortBroadcast();
    }
}
class Exp3Receiver4 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp3", "Exp2Receiver4 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread()
                + "], 实例为: " + this);
        //abortBroadcast();
    }
}
class Exp3Receiver5 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp3", "Exp2Receiver5 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread()
                + "], 实例为: " + this);
        //abortBroadcast();
    }
}
