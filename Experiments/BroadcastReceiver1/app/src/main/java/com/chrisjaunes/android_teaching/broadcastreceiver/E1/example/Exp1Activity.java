package com.chrisjaunes.android_teaching.broadcastreceiver.E1.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chrisjaunes.android_teaching.broadcastreceiver.E1.R;

public class Exp1Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp1);
        findViewById(R.id.btn_exp1_1).setOnClickListener(this);
        findViewById(R.id.btn_exp1_2).setOnClickListener(this);
        findViewById(R.id.btn_exp1_3).setOnClickListener(this);
        findViewById(R.id.btn_exp1_4).setOnClickListener(this);
    }

    public static class Exp1ActivityReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("Exp1", "Exp1ActivityReceiver 接受到了广播 并且调用了 onReciver ");
        }
    }

    /** Created By ChrisJaunes
     * 本处用于发送广播， 如何发送广播会在后续实验中进行探讨
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_exp1_1:
                Intent intent1 = new Intent(getString(R.string.BroadcastExp1_1));
                Log.i("Exp1", "Exp1Activity 发送了一条隐式广播");
                sendBroadcast(intent1);
                break;
            case R.id.btn_exp1_2:
                Intent intent2 = new Intent();
                intent2.setAction("如果指定了组件，这里填什么都会被忽略");
                intent2.setComponent(new ComponentName(Exp1Activity.this, Exp1Receiver.class));
                Log.i("Exp1", "Exp1Activity 发送了一条显式广播");
                sendBroadcast(intent2);
                break;
            case R.id.btn_exp1_3:
                Intent intent3 = new Intent(getString(R.string.BroadcastExp1_3));
                Log.i("Exp1", "Exp1Activity 发送了一条隐式广播（接收者为静态内部类）");
                sendBroadcast(intent3);
                break;
            case R.id.btn_exp1_4:
                Intent intent4 = new Intent();
                intent4.setComponent(new ComponentName(Exp1Activity.this, Exp1ActivityReceiver.class));
                Log.i("Exp1", "Exp1Activity 发送了一条显式广播（接收者为静态内部类）");
                sendBroadcast(intent4);
                break;
        }
    }
}