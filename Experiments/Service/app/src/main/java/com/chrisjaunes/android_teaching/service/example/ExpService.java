package com.chrisjaunes.android_teaching.service.example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ExpService extends Service {
    public ExpService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
