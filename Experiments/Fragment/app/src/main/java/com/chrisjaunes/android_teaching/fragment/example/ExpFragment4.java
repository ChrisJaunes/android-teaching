package com.chrisjaunes.android_teaching.fragment.example;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chrisjaunes.android_teaching.fragment.R;
public class ExpFragment4 extends Fragment { @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exp4, container, false);
        Button button = view.findViewById(R.id.btn_exp3_4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("bundleKey", "这是ExpFragment4发送的");
                getParentFragmentManager().setFragmentResult("Exp3", result);
            }
        });
        return view;
    }
}