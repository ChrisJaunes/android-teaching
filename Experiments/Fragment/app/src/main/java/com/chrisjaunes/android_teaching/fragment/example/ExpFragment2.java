package com.chrisjaunes.android_teaching.fragment.example;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chrisjaunes.android_teaching.fragment.R;
public class ExpFragment2 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChildFragmentManager().setFragmentResultListener("Exp3", this, new FragmentResultListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey");
                ((TextView)getView().findViewById(R.id.tv_exp3_4)).setText("接收到"+ result);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_exp2, container, false);
        Button button1 = view.findViewById(R.id.btn_exp3_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                Log.d("Exp2F", "ExpFragment2 调用 getActivity, Activity" + activity);
            }
        });
        Button button2 = view.findViewById(R.id.btn_exp3_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exp3Interface exp3Interface = (Exp3Interface) getActivity();
                assert exp3Interface != null;
                exp3Interface.changeTextView("这是由ExpFragment2发出的");
            }
        });
        Button button3 = view.findViewById(R.id.btn_exp3_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("bundleKey", "这是由ExpFragment2发出的");
                getParentFragmentManager().setFragmentResult("Exp3", result);
            }
        });
        return view;
    }
}