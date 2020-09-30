package com.chrisjaunes.android_teaching.service.example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Exp1Service extends Service {
    public Exp1Service() {
        Log.i("Exp1", "Exp1Service1 调用了构造函数");
    }

    @Override
    public void onCreate() {
        Log.i("Exp1", "Exp1Service1 调用了onCreate");
    }

    /** Created By ChrisJaunes
     * 以下操作模拟服务的执行
     * 通过修改execTime来模拟服务执行情况, 单位是毫秒
     * 通过修改execAutoStop来模拟服务执行完自动停止的情况
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
        Log.i("Exp1", "Exp1Service1 调用了onStartCommand");
        try {
            final long execTime = 1000;
            final boolean execAutoStop = false;

            Thread.sleep(execTime);
            if(execAutoStop) stopSelf();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startid);
    }

    @Override
    public void onDestroy() {
        Log.i("Exp1", "Exp1Service1 调用了onDestory");
        super.onDestroy();
    }

    /** Created By ChrisJaunes
     * 以下内容不是本次实验重点，可以选择性忽略
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
