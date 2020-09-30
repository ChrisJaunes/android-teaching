package com.chrisjaunes.android_teaching.broadcastreceiver.E1.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.broadcastreceiver.E1.R;

public class Exp2Activity extends AppCompatActivity implements View.OnClickListener{
    private Exp2Receiver exp2Receiver;
    private Exp2Receiver1 exp2Receiver1;
    private Exp2Receiver3 exp2Receiver3;
    private Exp2Receiver4 exp2Receiver4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp2);

//注册一个系统广播，接收来自网络的变化
        //使用IntentFilter添加过滤
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getString(R.string.NetChange));
        exp2Receiver = new Exp2Receiver();
        Log.i("Exp2", "Exp2Activity 动态注册了一条广播 (exp2Receiver)");
        registerReceiver(exp2Receiver, intentFilter);

//注册一个监听exp2.1广播
        final IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction(getString(R.string.BroadcastExp2_1));
        exp2Receiver1 = new Exp2Receiver1();
        Button button1 = findViewById(R.id.btn_exp2_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Exp2", "Exp2Activity 动态注册了一条广播 (exp2.1)");
                registerReceiver(exp2Receiver1, intentFilter1);
            }
        });
        //发送一条exp2.1的广播
        Button button1s = findViewById(R.id.btn_exp2_1s);
        button1s.setOnClickListener(this);

//注册监听exp2.2的广播,以下代码会引发内存泄漏，本处仅仅做实验使用
        final IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(getString(R.string.BroadcastExp2_2));
        Button button2 = findViewById(R.id.btn_exp2_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exp2Receiver2 exp2Receiver2 = new Exp2Receiver2();
                Log.i("Exp2", "Exp2Activity 动态注册了一条广播 (exp2.2), 实例: " + exp2Receiver2);
                registerReceiver(exp2Receiver2, intentFilter2);
            }
        });
        //发送一条exp2.2的广播
        Button button2s = findViewById(R.id.btn_exp2_2s);
        button2s.setOnClickListener(this);

//注册监听exp2.3的广播,该广播的接收者会开启新的Activity
        final IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction(getString(R.string.BroadcastExp2_3));
        exp2Receiver3 = new Exp2Receiver3();
        Log.i("Exp2", "Exp2Activity 动态注册了一条广播 (exp2.3)");
        registerReceiver(exp2Receiver3, intentFilter3);
        //发送一条exp2.3的广播
        Button button3 = findViewById(R.id.btn_exp2_3);
        button3.setOnClickListener(this);

//注册监听exp2.4/exp2.5的广播,有多个intentfilter
        final IntentFilter intentFilter4_1 = new IntentFilter();
        intentFilter4_1.addAction(getString(R.string.BroadcastExp2_4));
        final IntentFilter intentFilter4_2 = new IntentFilter();
        intentFilter4_2.addAction(getString(R.string.BroadcastExp2_5));
        exp2Receiver4 = new Exp2Receiver4();
        Log.i("Exp2", "Exp2Activity 动态注册了一条广播 (exp2.4)");
        registerReceiver(exp2Receiver4, intentFilter4_1);
        registerReceiver(exp2Receiver4, intentFilter4_2);
        //发送一条exp2.4的广播
        Button button4 = findViewById(R.id.btn_exp2_4);
        button4.setOnClickListener(this);
        //发送一条exp2.5的广播
        Button button5 = findViewById(R.id.btn_exp2_5);
        button5.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Exp2", "Exp2Activity 取消了一条广播 (exp2Receiver)");
        unregisterReceiver(exp2Receiver);
        try {
            Log.i("Exp2", "Exp2Activity 取消了一条广播 (exp2Receiver1)");
            unregisterReceiver(exp2Receiver1);
        }catch (RuntimeException e) {
            Log.e("Exp2", "Exp2Activity 中 exp2Receiver1 没有注册");
        }
        Log.i("Exp2", "Exp2Activity 取消了一条广播 (exp2Receiver3)");
        unregisterReceiver(exp2Receiver3);
        Log.i("Exp2", "Exp2Activity 取消了一条广播 (exp2Receiver4)");
        unregisterReceiver(exp2Receiver4);
    }

    /** Created By ChrisJaunes
     * 本处用于发送广播， 如何发送广播会在后续实验中进行探讨,本处可以选择性忽略
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_exp2_1s :
                Intent intent1 = new Intent();
                intent1.setAction(getString(R.string.BroadcastExp2_1));
                Log.i("Exp2", "Exp2Activity 发送了一条广播 (exp2.1)");
                sendBroadcast(intent1);
                break;
            case R.id.btn_exp2_2s:
                Intent intent2 = new Intent();
                intent2.setAction(getString(R.string.BroadcastExp2_2));
                Log.i("Exp2", "Exp2Activity 发送了一条广播 (exp2.2)");
                sendBroadcast(intent2);
                break;
            case R.id.btn_exp2_3:
                Intent intent3 = new Intent();
                intent3.setAction(getString(R.string.BroadcastExp2_3));
                Log.i("Exp2", "Exp2Activity 发送了一条广播 (exp2.3)");
                sendBroadcast(intent3);
                break;
            case R.id.btn_exp2_4:
                Intent intent4 = new Intent();
                intent4.setAction(getString(R.string.BroadcastExp2_4));
                Log.i("Exp2", "Exp2Activity 发送了一条广播 (exp2.4)");
                sendBroadcast(intent4);
                break;
            case R.id.btn_exp2_5:
                Intent intent5 = new Intent();
                intent5.setAction(getString(R.string.BroadcastExp2_5));
                Log.i("Exp2", "Exp2Activity 发送了一条广播 (exp2.5)");
                sendBroadcast(intent5);
        }
    }
}