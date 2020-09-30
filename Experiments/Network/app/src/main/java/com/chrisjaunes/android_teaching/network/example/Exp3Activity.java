package com.chrisjaunes.android_teaching.network.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.network.ExpConfig;
import com.chrisjaunes.android_teaching.network.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Exp3Activity extends AppCompatActivity {
    final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp3);

        Button btn1 = findViewById(R.id.btn_exp3_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp3_1", "利用post提交键值对");
                RequestBody requestBody = new FormBody.Builder()
                        .add("exp3_a","post测试")
                        .add("exp3_b", "利用post提交键值对")
                        .build();
                Request request = new Request.Builder().url(ExpConfig.Exp3URL1).post(requestBody).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Log.i("Exp3_1", "请求发生错误");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody responseBody = response.body();
                        assert responseBody != null;
                        Log.i("Exp3_1", "接收到的信息" + responseBody.string());
                    }
                });
            }
        });

        Button btn2 = findViewById(R.id.btn_exp3_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp3_2", "利用post提交文件");
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setType("*/*");
                startActivityForResult(intent, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            try {
                InputStream in = getContentResolver().openInputStream(uri);
                byte[] text = new byte[in.available()];
                in.read(text);
                Log.i("Exp3_2", "发出的文件长度:" + text.length);
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), text);
                Request request = new Request.Builder().url(ExpConfig.Exp3URL2).post(requestBody).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Log.i("Exp3_2", "请求发生错误");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody responseBody = response.body();
                        assert responseBody != null;
                        Log.i("Exp3_2", "接收到的信息: " + responseBody.string());
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}