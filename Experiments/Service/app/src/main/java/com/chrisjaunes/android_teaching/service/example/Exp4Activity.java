package com.chrisjaunes.android_teaching.service.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chrisjaunes.android_teaching.service.R;

public class Exp4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp4);
        Button btn_exp4_test = findViewById(R.id.btn_exp4_test);
        btn_exp4_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Exp4", "Exp4Activity 执行了 onClick， 当前线程为:" + Thread.currentThread());
                new Exp4AsyncTask((TextView) findViewById(R.id.text)).execute();
            }
        });
    }

    static class Exp4AsyncTask extends AsyncTask<Void, Integer, Boolean> {
        @SuppressLint("StaticFieldLeak")
        private TextView textView;

        Exp4AsyncTask(TextView textView) {
            Log.i("Exp4", "Exp4AsyncTask 执行了 构造函数， 当前线程为:" + Thread.currentThread());
            this.textView = textView;
        }
        @Override
        protected void onPreExecute() {
            Log.i("Exp4", "Exp4AsyncTask 执行了 onPreExecute， 当前线程为:" + Thread.currentThread());
            textView.setText("开始异步更新: 0");
        }
        @Override
        protected Boolean doInBackground(Void... voids) {
            Log.i("Exp4", "Exp4AsyncTask 执行了 doInBackground， 当前线程为:" + Thread.currentThread());
            try {
                for(int i = 1; i < 10; i++) {
                    Thread.sleep(1000);
                    publishProgress(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        @SuppressLint("DefaultLocale")
        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i("Exp4", "Exp4AsyncTask 执行了 onProgressUpdate， 当前值为:" + values[0] + ", 当前线程为:" + Thread.currentThread());
            textView.setText(String.format("开始异步更新: %d", values[0]));
        }
        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Boolean result) {
            Log.i("Exp4", "Exp4AsyncTask 执行了 onPostExecute， 当前线程为:" + Thread.currentThread());
            textView.setText("结束AsyncTask");
        }
    }
}