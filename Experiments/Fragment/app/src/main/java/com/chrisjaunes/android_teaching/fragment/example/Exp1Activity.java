package com.chrisjaunes.android_teaching.fragment.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.fragment.R;
import com.chrisjaunes.android_teaching.fragment.utils.DialogActivity;
import com.chrisjaunes.android_teaching.fragment.utils.EmptyActivity;

public class Exp1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Exp1A", "Exp1Activity 调用了 onCreate");
        super.onCreate(savedInstanceState);
        Log.i("Exp1A", "Exp1Activity 结束调用 super.onCreate");
        setContentView(R.layout.activity_exp1);
        Log.i("Exp1A", "Exp1Activity 结束调用 setContentView");

        ignoreIt();
    }

    @Override
    protected void onStart() {
        Log.i("Exp1A", "Exp1Activity 调用了 onStart");
        super.onStart();
        Log.i("Exp1A", "Exp1Activity 结束调用 super.onStart");
    }

    @Override
    protected void onResume() {
        Log.i("Exp1A", "Exp1Activity 调用了 onResume");
        super.onResume();
        Log.i("Exp1A", "Exp1Activity 结束调用 super.onResume");
    }

    @Override
    protected void onPause() {
        Log.i("Exp1A", "Exp1Activity 调用了 onPause");
        super.onPause();
        Log.i("Exp1A", "Exp1Activity 结束调用 super.onPause");
    }

    @Override
    protected void onStop() {
        Log.i("Exp1A", "Exp1Activity 调用了 onStop");
        super.onStop();
        Log.i("Exp1A", "Exp1Activity 结束调用 super.onStop");
    }

    @Override
    protected void onDestroy() {
        Log.i("Exp1A", "Exp1Activity 调用了 onDestroy");
        super.onDestroy();
        Log.i("Exp1A", "Exp1Activity 结束调用 super.onDestroy");
    }

    /** Create By ChrisJaunes
     * 以下部分不是本实验的重点，可以选择性忽略
     */
    private void ignoreIt() {
        Button button1 = findViewById(R.id.btn_exp1_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exp1Activity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.btn_exp1_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exp1Activity.this, EmptyActivity.class);
                startActivity(intent);
            }
        });
    }
}