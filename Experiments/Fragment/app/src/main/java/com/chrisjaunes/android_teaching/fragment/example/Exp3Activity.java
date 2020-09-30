package com.chrisjaunes.android_teaching.fragment.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.chrisjaunes.android_teaching.fragment.R;

public class Exp3Activity extends AppCompatActivity implements Exp3Interface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp3);
        Log.i("Exp3", "Exp3Activity的context为" + this);
        Log.i("Exp3", "Exp3Activity的FragmentManager为" + getSupportFragmentManager());
    }

    @Override
    public void changeTextView(String msg) {
        TextView tv = findViewById(R.id.tv_exp3_1);
        tv.setText(msg);
    }
}