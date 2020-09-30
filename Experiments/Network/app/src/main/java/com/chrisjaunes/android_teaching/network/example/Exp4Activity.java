package com.chrisjaunes.android_teaching.network.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.network.ExpConfig;
import com.chrisjaunes.android_teaching.network.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Exp4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp4);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Button btn1 = findViewById(R.id.btn_exp4_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp4_1", "对于XML进行解析");
                Request request = new Request.Builder().url(ExpConfig.Exp4URL + "?exp4=xml").get().build();
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
                        String res = responseBody.string();
                        Log.i("Exp4_2", "接收到的信息" + res);
                        parseXMLWithPull(res);
                    }
                });
            }
        });

        Button btn2 = findViewById(R.id.btn_exp4_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp4_2", "利用拼接方式进行get请求");
                Request request = new Request.Builder().url(ExpConfig.Exp4URL + "?exp4=json").get().build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Log.i("Exp4_2", "请求发生错误");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody responseBody = response.body();
                        assert responseBody != null;
                        String res = responseBody.string();
                        Log.i("Exp4_2", "接收到的信息" + res);
                        parseJsonWithJsonObject(res);
                    }
                });
            }
        });
    }

    void parseXMLWithPull(String xmlData) {
        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String id = null, msg = null;
            while(eventType != xmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch(eventType) {
                    case XmlPullParser.START_TAG:{
                        if("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        }else if("msg".equals(nodeName)) {
                            msg = xmlPullParser.nextText();
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG:{
                        if("app".equals(nodeName)) {
                            Log.i("Exp4_2", String.format("id = %s, msg = %s", id, msg));
                        }
                        break;
                    }
                }
                eventType = xmlPullParser.next();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    void parseJsonWithJsonObject(String jsonData) {
        try{
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String msg = jsonObject.getString("msg");
                Log.i("Exp4_2", String.format("id = %s, msg = %s", id, msg));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}