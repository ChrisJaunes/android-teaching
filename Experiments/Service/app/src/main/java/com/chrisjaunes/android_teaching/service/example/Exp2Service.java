package com.chrisjaunes.android_teaching.service.example;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class Exp2Service extends Service {
    private Exp2Binder exp2Binder = new Exp2Binder();

    public Exp2Service() {
        Log.i("Exp2", "Exp2Service 调用了构造函数");
    }

    @Override
    public void onCreate() {
        Log.i("Exp2", "Exp2Service 调用了onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
        Log.i("Exp2", "Exp2Service 调用了onStartCommand");
        return super.onStartCommand(intent, flags, startid);
    }

    @Override
    public void onDestroy() {
        Log.i("Exp2", "Exp2Service 调用了onDestory");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("Exp2", "Exp2Service 调用了onBind");
        return exp2Binder;
    }

    public long Exp2ServiceTest() {
        Log.i("Exp2", "Exp2Service 调用了 Exp2ServiceTest");
        return System.currentTimeMillis();
    }

    public class Exp2Binder extends Binder {
        Exp2Service getExp2Service() {
            Log.i("Exp2", "Exp2Binder 调用了 getExp2Service");
            return Exp2Service.this;
        }
        public long Exp2BinderTest() {
            Log.i("Exp2", "Exp2Binder 调用了 Exp2ServiceTest");
            return System.currentTimeMillis();
        }
    }
}
