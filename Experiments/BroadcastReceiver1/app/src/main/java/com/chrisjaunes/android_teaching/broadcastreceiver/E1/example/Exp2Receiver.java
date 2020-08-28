package com.chrisjaunes.android_teaching.broadcastreceiver.E1.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Exp2Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp2", "Exp2Receiver 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread()
                + "]，当前Context" + context.toString());

        //对于Activity，可以使用对话框
        if(context instanceof Activity) {
            new AlertDialog.Builder(context)
                    .setTitle("网络变化通知")
                    .setMessage("您的网络状态发生了改变")
                    .setPositiveButton("知道啦", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create()
                    .show();
        }else{
            Toast.makeText(context, "您的网络状态发生了改变", Toast.LENGTH_SHORT).show();
        }
    }
}

class Exp2Receiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp2", "Exp2Receiver1 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread() + "]");
    }
}

class Exp2Receiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp2", "Exp2Receiver2 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread()
                + "], 实例为: " + this);
    }
}

class Exp2Receiver3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp2", "Exp2Receiver3 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread() + "]");
        Intent intent2 = new Intent(context, Exp2EmptyActivity.class);
        context.startActivity(intent2);;
    }
}
class Exp2Receiver4 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp2", "Exp2Receiver1 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread() + "]");
        Toast.makeText(context, "Exp2.4/Exp3.1", Toast.LENGTH_SHORT).show();
    }
}