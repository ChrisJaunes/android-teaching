package com.chrisjaunes.android_teaching.broadcastreceiver.E2.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.chrisjaunes.android_teaching.broadcastreceiver.E2.R;

public class Exp3Activity extends AppCompatActivity {
    private Exp3Receiver exp3Receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp3);

        registerReceivers();
    }
    private void registerReceivers() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getString(R.string.BroadcastExp3_2));

        IntentFilter intentFilter3_0 = new IntentFilter();
        intentFilter3_0.addAction(getString(R.string.BroadcastExp3_3));
        intentFilter3_0.setPriority(100);
        exp3Receiver = new Exp3Receiver();
        registerReceiver(exp3Receiver, intentFilter);
        registerReceiver(exp3Receiver, intentFilter3_0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceivers();
    }
    private void unregisterReceivers() {
        unregisterReceiver(exp3Receiver);
    }
    static class Exp3Receiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Log.i("Exp3", "Exp3Receiver 接受了 Exp3_3的广播");
            Toast.makeText(context, "BroadcastReceiver2 接收了广播", Toast.LENGTH_SHORT).show();
        }
    }
}