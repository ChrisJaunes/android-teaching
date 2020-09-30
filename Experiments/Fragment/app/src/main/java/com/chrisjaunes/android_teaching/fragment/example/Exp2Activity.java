package com.chrisjaunes.android_teaching.fragment.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chrisjaunes.android_teaching.fragment.R;

public class Exp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp2);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        Button button1 = findViewById(R.id.btn_exp2_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 执行事务 为fl_exp4_left 添加Expfragment1");
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.fl_exp4_left, new ExpFragment1())
                        .addToBackStack(null)
                        .commit();
            }
        });
        Button button2 = findViewById(R.id.btn_exp2_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 执行事务 替换fl_exp4_left 为Expfragment1");
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_exp4_left, new ExpFragment1())
                        .addToBackStack(null)
                        .commit();
            }
        });
        Button button3 = findViewById(R.id.btn_exp2_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 执行事务 替换fl_exp4_left 为Expfragment1， 不入返回栈");
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_exp4_left, new ExpFragment1())
                        .commit();
            }
        });

        Button button4 = findViewById(R.id.btn_exp2_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 执行事务 替换fl_exp4_left 为Expfragment1， 不入返回栈");
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_exp4_left, new ExpFragment1())
                        .replace(R.id.fl_exp4_right, new ExpFragment1())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
    @Override
    public void onBackPressed() {
        Log.i("Exp2", "Exp2Activity 调用了 onBackPressed 按钮");
        super.onBackPressed();
    }
}