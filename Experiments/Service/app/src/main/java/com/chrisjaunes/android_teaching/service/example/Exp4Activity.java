package com.chrisjaunes.android_teaching.service.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chrisjaunes.android_teaching.service.R;

public class Exp4Activity extends AppCompatActivity {
    public static final int UPDATE_TEXT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp4);
        final TextView text = findViewById(R.id.text);

        /** Created by ChrisJaunes_hjj
         * 以下代码在有些时候会导致崩溃
         */
        final Button btn1 = findViewById(R.id.btn_exp4_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Exp4_1", "当前线程为" + Thread.currentThread());
                new Thread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        try {
                            Log.i("Exp4_1", "当前线程为" + Thread.currentThread());
                            text.setText("这是在非UI线程中执行的更改操作");
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.i("Exp4_1","非UI线程修改UI控件会引发异常");
                        }
                    }
                }).start();
            }
        });

        /** Created by ChrisJaunes_hjj
         * 以下写发可能导致内存泄漏， 由于匿名内部类会隐式持有外部类引用而导致外部类Activity无法销毁
         */
        @SuppressLint("HandlerLeak")
        final Handler handler = new Handler() {
            @SuppressLint("SetTextI18n")
            public void handleMessage(Message msg) {
                Log.i("Exp4", "Exp4Activity 进入了 handleMessage，当前线程为" + Thread.currentThread());
                if (msg.what == UPDATE_TEXT) {
                    final TextView text = findViewById(R.id.text);
                    text.setText("这是在非UI线程中执行的更改操作,采用Handle");
                }
            }
        };
        final Button btn2 = findViewById(R.id.btn_exp4_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Exp4", "Exp3Activity 按下了 btn1 按钮，当前线程为" + Thread.currentThread());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Exp4", "Exp4Activity 开启了一个新的线程，当前线程为" + Thread.currentThread());
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });

        final Button btn3 = findViewById(R.id.btn_exp4_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        final TextView text = findViewById(R.id.text);
                        text.setText("这是在非UI线程中执行的更改操作,采用runOnUiThread");
                    }
                });
            }
        });
    }
}