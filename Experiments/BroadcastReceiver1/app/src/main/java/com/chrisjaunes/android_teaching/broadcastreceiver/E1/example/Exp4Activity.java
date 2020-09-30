package com.chrisjaunes.android_teaching.broadcastreceiver.E1.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.broadcastreceiver.E1.R;

public class Exp4Activity extends AppCompatActivity {
    private LocalBroadcastManager localBroadcastManage;
    private Exp4Receiver exp4Receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp4);

        localBroadcastManage = LocalBroadcastManager.getInstance(this);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getString(R.string.BroadcastExp4_1));
        exp4Receiver = new Exp4Receiver();
        localBroadcastManage.registerReceiver(exp4Receiver, intentFilter);

        Button button = findViewById(R.id.btn_exp4_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getString(R.string.BroadcastExp4_1));
                Log.i("Exp4", "Exp4Activity 发送了一条exp4.1广播");
                localBroadcastManage.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManage.unregisterReceiver(exp4Receiver);
    }
}