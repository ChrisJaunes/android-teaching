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

public class Exp3Activity extends AppCompatActivity {
    public static final int UPDATE_TEXT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp3);
        final TextView text = findViewById(R.id.text);
        @SuppressLint("HandlerLeak")
        final Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                Log.i("Exp3", "Exp3Activity 进入了 handleMessage，当前线程为" + Thread.currentThread());
                switch (msg.what) {
                    case  UPDATE_TEXT:
                        text.setText("文本发生了改变");
                        break;
                    default:
                        break;
                }
            }
        };

        final Button btn_exp3_change = findViewById(R.id.btn_exp3_change);
        btn_exp3_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Exp3", "Exp3Activity 按下了 btn_exp3_change 按钮，当前线程为" + Thread.currentThread());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Exp3", "Exp3Activity 开启了一个新的线程，当前线程为" + Thread.currentThread());
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });
    }
}