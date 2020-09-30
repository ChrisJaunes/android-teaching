package com.chrisjaunes.android_teaching.network.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.network.ExpConfig;
import com.chrisjaunes.android_teaching.network.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Exp1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp1);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Button btn1 = findViewById(R.id.btn_exp1_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Request request = new Request.Builder().url(ExpConfig.Exp1URL).build();
                Call call = okHttpClient.newCall(request);
                Log.i("Exp1_1", "在MainThread中进行网络操作会引发异常");
                try {
                    call.execute();
                } catch (NetworkOnMainThreadException e) {
                    Log.i("Exp1_1", "在MainThread中进行网络操作会引发NetworkOnMainThreadException");
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button btn2 = findViewById(R.id.btn_exp1_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp1_2", "本次实验的UI线程: " + Thread.currentThread());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Request request = new Request.Builder().url(ExpConfig.Exp1URL).build();
                        Call call = okHttpClient.newCall(request);
                        try {
                            Log.i("Exp1_2", "同步机制会阻塞线程,准备调用，当前时间戳:" + System.currentTimeMillis() + " 当前线程：" + Thread.currentThread());
                            Response response = call.execute();
                            Log.i("Exp1_2", "同步机制会阻塞线程,调用完成，当前时间戳:" + System.currentTimeMillis() + " 当前线程：" + Thread.currentThread());
                            ResponseBody responseBody = response.body();
                            assert responseBody != null;
                            Log.i("Exp1_2", "接收到的信息:" + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        Button btn3 = findViewById(R.id.btn_exp1_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Request request = new Request.Builder().url(ExpConfig.Exp1URL).build();
                Call call = okHttpClient.newCall(request);
                Log.i("Exp1_3", "异步机制不会阻塞线程,准备调用，当前时间戳:" + System.currentTimeMillis() + ", 当前线程：" + Thread.currentThread());
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Log.i("Exp1_3", "请求发生错误");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.i("Exp1_3", "异步机制不会阻塞线程,请求完成，当前时间戳:" + System.currentTimeMillis() + ", 当前线程：" + Thread.currentThread());
                        ResponseBody responseBody = response.body();
                        assert responseBody != null;
                        Log.i("Exp1_3", "接收到的信息" + responseBody.string());
                    }
                });
                Log.i("Exp1_3", "异步机制不会阻塞线程,调用完成，当前时间戳:" + System.currentTimeMillis() + ", 当前线程：" + Thread.currentThread());
            }
        });
    }
}