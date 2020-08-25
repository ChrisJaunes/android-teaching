package com.chrisjaunes.android_teaching.service.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chrisjaunes.android_teaching.service.R;

public class Exp2Activity extends AppCompatActivity {
    private Exp2Service.Exp2Binder exp2Binder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("Exp2", "ServiceConnection 调用了 onServiceConnected");
            exp2Binder = (Exp2Service.Exp2Binder) iBinder;
            exp2Binder.Exp2ServiceStart();
            exp2Binder.Exp2ServiceTest();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("Exp2", "ServiceConnection 调用了 onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp2);

        final Button btn_exp2_bind_service = findViewById(R.id.btn_exp2_bind_service);
        btn_exp2_bind_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 绑定服务 Exp2Service");
                Intent intent = new Intent(Exp2Activity.this, Exp2Service.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
            }
        });
        final Button btn_exp2_test_service = findViewById(R.id.btn_exp2_test_service);
        btn_exp2_test_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 测试服务 Exp2Service");
                Toast.makeText(Exp2Activity.this, "返回值:" + exp2Binder.Exp2ServiceTest(), Toast.LENGTH_SHORT).show();
            }
        });
        final Button btn_exp2_unbind_service = findViewById(R.id.btn_exp2_unbind_service);
        btn_exp2_unbind_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 解绑服务 Exp2Service");
                unbindService(connection);
            }
        });
    }
}