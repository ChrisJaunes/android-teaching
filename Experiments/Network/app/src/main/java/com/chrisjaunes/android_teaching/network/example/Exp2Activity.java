package com.chrisjaunes.android_teaching.network.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chrisjaunes.android_teaching.network.ExpConfig;
import com.chrisjaunes.android_teaching.network.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Exp2Activity extends AppCompatActivity {
    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp2);
        textView = findViewById(R.id.tv_exp2);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Button btn1 = findViewById(R.id.btn_exp2_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2_1", "利用拼接方式进行get请求");
                Request request = new Request.Builder().url(ExpConfig.Exp2URL + "?exp2_a=get测试&&exp2_b=利用拼接").get().build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Log.i("Exp2_1", "请求发生错误");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody responseBody = response.body();
                        assert responseBody != null;
                        Log.i("Exp2_1", "接收到的信息" + responseBody.string());
                    }
                });
            }
        });

        Button btn2 = findViewById(R.id.btn_exp2_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2_2", "利用httpUrl方式进行get请求");
                HttpUrl httpUrl = HttpUrl.parse(ExpConfig.Exp2URL).newBuilder()
                        .addQueryParameter("exp2_a","get测试")
                        .addQueryParameter("exp2_b","利用httpurl拼接")
                        .build();
                Request request = new Request.Builder().url(httpUrl).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Log.i("Exp2_2", "请求发生错误");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody responseBody = response.body();
                        assert responseBody != null;
                        Log.i("Exp2_2", "接收到的信息" + responseBody.string());
                    }
                });
            }
        });

        Button btn3 = findViewById(R.id.btn_exp2_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2_3", "利用httpUrl方式进行get请求, 当前线程：" + Thread.currentThread());
                HttpUrl httpUrl = HttpUrl.parse(ExpConfig.Exp2URL).newBuilder()
                        .addQueryParameter("exp2_a","get测试")
                        .addQueryParameter("exp2_b","不能在非UI线程中修改UI组件")
                        .build();
                Request request = new Request.Builder().url(httpUrl).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Log.i("Exp2_3", "请求发生错误");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody responseBody = response.body();
                        assert responseBody != null;
                        String res = responseBody.string();
                        Log.i("Exp2_3", "接收到的信息" + res);
                        Log.i("Exp2_3", "不能在非UI线程中修改UI组件, 当前线程：" + Thread.currentThread());
                        try {
                            Thread.sleep(1000);
                            textView.setText(res);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.i("Exp2_3", "在非UI线程中线程中更新UI组件会导致CalledFromWrongThreadException异常");
                        }
                    }
                });
            }
        });

        Button btn4 = findViewById(R.id.btn_exp2_4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2_4", "利用httpUrl方式进行get请求, 当前线程：" + Thread.currentThread());
                HttpUrl httpUrl = HttpUrl.parse(ExpConfig.Exp2URL).newBuilder()
                        .addQueryParameter("exp2_a","get测试")
                        .addQueryParameter("exp2_b","不能在非UI线程中修改UI组件")
                        .build();
                Request request = new Request.Builder().url(httpUrl).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Log.i("Exp2_4", "请求发生错误");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final ResponseBody responseBody = response.body();
                        assert responseBody != null;
                        final String res = responseBody.string();
                        Log.i("Exp2_4", "接收到的信息" + res);
                        Log.i("Exp2_4", "不能在非UI线程中修改UI组件, 当前线程：" + Thread.currentThread());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Log.i("Exp2_4", "runOnUiThread会切换回主线程, 当前线程：" + Thread.currentThread());
                                    Thread.sleep(1000);
                                    textView.setText(res);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            }
        });
    }
}