package com.chrisjaunes.android_teaching.broadcastreceiver.E1.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.broadcastreceiver.E1.R;

public class Exp3Activity extends AppCompatActivity {
    private Exp3Receiver exp3Receiver;
    private Exp3Receiver1 exp3Receiver1;
    private Exp3Receiver2 exp3Receiver2;
    private Exp3Receiver3 exp3Receiver3;
    private Exp3Receiver4 exp3Receiver4;
    private Exp3Receiver5 exp3Receiver5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp3);
        registerReceivers();

        Button button2 = findViewById(R.id.btn_exp3_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(getString(R.string.BroadcastExp3_2));
                Log.i("Exp3,Exp2", "Exp2Activity 发送了一条广播 (exp3_2)");
                sendBroadcast(intent);
            }
        });

        Button button3 = findViewById(R.id.btn_exp3_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(getString(R.string.BroadcastExp3_3));
                Log.i("Exp3,Exp2", "Exp2Activity 发送了一条广播 (exp3_3)");
                sendOrderedBroadcast(intent, null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceivers();
    }

    /** Created by ChrisJaunes 2020/08/28
     * 以下内容在exp2中练习过，有兴趣的同学可以自己练习练习
     * 为Exp3Receiver、Exp3Receiver1、Exp3Receiver2、Exp3Receiver3、Exp3Receiver4、Exp3Receiver5进行注册
     * Exp3Receiver 优先级100，动态注册, 监听exp3_2、exp3_3
     * Exp3Receiver1 优先级99，动态注册, 监听exp3_2、exp3_3
     * Exp3Receiver2 优先级99，动态注册, 监听exp3_2、exp3_3
     * Exp3Receiver3 优先级99，动态注册, 监听exp3_2、exp3_3
     * Exp3Receiver4 优先级98，动态注册, 监听exp3_2、exp3_3
     * Exp3Receiver5 优先级98，动态注册, 监听exp3_2、exp3_3
     */
    private void registerReceivers() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getString(R.string.BroadcastExp3_2));

        IntentFilter intentFilter3_0 = new IntentFilter();
        intentFilter3_0.addAction(getString(R.string.BroadcastExp3_3));
        intentFilter3_0.setPriority(100);
        exp3Receiver = new Exp3Receiver();
        registerReceiver(exp3Receiver, intentFilter);
        registerReceiver(exp3Receiver, intentFilter3_0);

        IntentFilter intentFilter3_1 = new IntentFilter();
        intentFilter3_1.addAction(getString(R.string.BroadcastExp3_3));
        intentFilter3_1.setPriority(99);
        exp3Receiver1 = new Exp3Receiver1();
        registerReceiver(exp3Receiver1, intentFilter);
        registerReceiver(exp3Receiver1, intentFilter3_1);

        IntentFilter intentFilter3_2 = new IntentFilter();
        intentFilter3_2.addAction(getString(R.string.BroadcastExp3_3));
        intentFilter3_2.setPriority(99);
        exp3Receiver2 = new Exp3Receiver2();
        registerReceiver(exp3Receiver2, intentFilter);
        registerReceiver(exp3Receiver2, intentFilter3_2);

        IntentFilter intentFilter3_3 = new IntentFilter();
        intentFilter3_3.addAction(getString(R.string.BroadcastExp3_3));
        intentFilter3_3.setPriority(99);
        exp3Receiver3 = new Exp3Receiver3();
        registerReceiver(exp3Receiver3, intentFilter);
        registerReceiver(exp3Receiver3, intentFilter3_3);

        IntentFilter intentFilter3_4 = new IntentFilter();
        intentFilter3_4.addAction(getString(R.string.BroadcastExp3_3));
        intentFilter3_4.setPriority(99);
        exp3Receiver4 = new Exp3Receiver4();
        registerReceiver(exp3Receiver4, intentFilter);
        registerReceiver(exp3Receiver4, intentFilter3_4);

        IntentFilter intentFilter3_5 = new IntentFilter();
        intentFilter3_5.addAction(getString(R.string.BroadcastExp3_3));
        intentFilter3_5.setPriority(98);
        exp3Receiver5 = new Exp3Receiver5();
        registerReceiver(exp3Receiver5, intentFilter);
        registerReceiver(exp3Receiver5, intentFilter3_5);
    }

    /** Created By ChrisJaunes 2020/08/28
     * 取消注册广播接收器 Exp3Receiver、Exp3Receiver2、Exp3Receiver4、Exp3Receiver5
     */
    private void unregisterReceivers() {
        unregisterReceiver(exp3Receiver);
        unregisterReceiver(exp3Receiver1);
        unregisterReceiver(exp3Receiver2);
        unregisterReceiver(exp3Receiver3);
        unregisterReceiver(exp3Receiver4);
        unregisterReceiver(exp3Receiver5);
    }
}