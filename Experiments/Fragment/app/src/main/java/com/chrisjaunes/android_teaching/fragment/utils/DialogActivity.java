package com.chrisjaunes.android_teaching.fragment.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chrisjaunes.android_teaching.fragment.R;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
}