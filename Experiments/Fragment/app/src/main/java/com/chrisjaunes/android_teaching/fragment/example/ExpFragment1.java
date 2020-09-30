package com.chrisjaunes.android_teaching.fragment.example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chrisjaunes.android_teaching.fragment.R;

public class ExpFragment1 extends Fragment {

    public ExpFragment1() {
        Log.i("Exp1F", "ExpFragment1 构造函数");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("Exp1F", "ExpFragment1 调用了onAttach");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Exp1F", "ExpFragment1 调用了onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("Exp1F", "ExpFragment1 调用了onCreateView");
        Log.i("Exp1F", "ExpFragment1 为" + this);
        View view =  inflater.inflate(R.layout.fragment_exp1, container, false);
        TextView tv_context = view.findViewById(R.id.tv_context);
        tv_context.setText("当前为" + this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("Exp1F", "ExpFragment1 调用了onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Exp1F", "ExpFragment1 调用了onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Exp1F", "ExpFragment1 调用了onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Exp1F", "ExpFragment1 调用了onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Exp1F", "ExpFragment1 调用了onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("Exp1F", "ExpFragment1 调用了onDestroyView");
        Log.i("Exp1F", "ExpFragment1 为" + this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Exp1F", "ExpFragment1 调用了onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Exp1F", "ExpFragment1 调用了onDetach");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Log.i("Exp1F", "ExpFragment1 调用了onSaveInstanceState");
        super.onSaveInstanceState(bundle);
    }
}