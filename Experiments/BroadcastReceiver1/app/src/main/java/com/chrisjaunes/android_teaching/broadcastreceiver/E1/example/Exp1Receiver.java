package com.chrisjaunes.android_teaching.broadcastreceiver.E1.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Exp1Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Exp1", "Exp1Receiver 接受到了广播 并且调用了 onReciver, [当前线程: " + Thread.currentThread() + "]");

        /* 本处模拟广播机制的运行，通过修改execTime来模拟广播的运行，单位是毫秒 */
        try {
            final long execTime = 1000;
            Thread.sleep(execTime);
            Log.i("Exp1", "Exp1Receiver 接受到了广播 并且执行了execTime秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //可以执行Toast、发布通知栏信息、对话框（此时的context必须是一个Activity)、发送广播、开启服务、开启新的Activity
        Toast.makeText(context, "来自Exp1： 广播是可以使用Toast的", Toast.LENGTH_SHORT).show();

        /* 本处说明使用线程（不建议使用），一旦广播接收器被销毁，子线程变成空线程，很容易被系统杀死*/
        //new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        //        try{
        //            Log.i("Exp1", "Exp1Receiver 开启了新的进程, [当前线程: " + Thread.currentThread() + "]");
        //            Thread.sleep(1000);
        //            Log.i("Exp1", "Exp1Receiver 执行完了这个进程, [当前线程: " + Thread.currentThread() + "]");
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //    }
        //}).start();
    }
}
