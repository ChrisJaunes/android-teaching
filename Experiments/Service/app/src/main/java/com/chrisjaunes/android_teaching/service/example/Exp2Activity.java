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
    private Exp2Service Exp2Service1;
    private Exp2Service.Exp2Binder exp2Binder2;
    private ServiceConnection connection1 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("Exp2", "ServiceConnection1 调用了 onServiceConnected");
            Exp2Service.Exp2Binder exp2Binder1 = (Exp2Service.Exp2Binder) iBinder;
            Exp2Service1 = exp2Binder1.getExp2Service();
            Log.i("Exp2", "exp2Binder1的content为" + exp2Binder1);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("Exp2", "ServiceConnection1 调用了 onServiceDisconnected");
        }
    };

    private ServiceConnection connection2 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("Exp2", "ServiceConnection2 调用了 onServiceConnected");
            exp2Binder2 = (Exp2Service.Exp2Binder) iBinder;
            Log.i("Exp2", "exp2Binder2的content为" + exp2Binder2);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("Exp2", "ServiceConnection2 调用了 onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp2);

        final Button btn_exp2_bind_service1 = findViewById(R.id.btn_exp2_bind_service1);
        btn_exp2_bind_service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 绑定服务 Exp2Service");
                Intent intent = new Intent(Exp2Activity.this, Exp2Service.class);
                bindService(intent, connection1, BIND_AUTO_CREATE);
            }
        });
        final Button btn_exp2_test_service1 = findViewById(R.id.btn_exp2_test_service1);
        btn_exp2_test_service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 测试服务 Exp2Service");
                if(Exp2Service1 == null) {
                    Toast.makeText(Exp2Activity.this, "服务未绑定", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Exp2Activity.this, "返回值:" + Exp2Service1.Exp2ServiceTest(), Toast.LENGTH_SHORT).show();
            }
        });
        final Button btn_exp2_unbind_service1 = findViewById(R.id.btn_exp2_unbind_service1);
        btn_exp2_unbind_service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Log.i("Exp2", "Exp2Activity 解绑服务 Exp2Service");
                    unbindService(connection1);
                }catch (IllegalArgumentException e) {
                    Toast.makeText(Exp2Activity.this,"服务未注册", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button btn_exp2_bind_service2 = findViewById(R.id.btn_exp2_bind_service2);
        btn_exp2_bind_service2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 绑定服务 Exp2Service");
                Intent intent = new Intent(Exp2Activity.this, Exp2Service.class);
                bindService(intent, connection2, BIND_AUTO_CREATE);
            }
        });
        final Button btn_exp2_test_service2 = findViewById(R.id.btn_exp2_test_service2);
        btn_exp2_test_service2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Exp2", "Exp2Activity 测试服务 Exp2Service");
                if(exp2Binder2 == null) {
                    Toast.makeText(Exp2Activity.this, "服务未绑定", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Exp2Activity.this, "返回值:" + exp2Binder2.Exp2BinderTest(), Toast.LENGTH_SHORT).show();
            }
        });
        final Button btn_exp2_unbind_service2 = findViewById(R.id.btn_exp2_unbind_service2);
        btn_exp2_unbind_service2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Log.i("Exp2", "Exp2Activity 解绑服务 Exp2Service");
                    unbindService(connection2);
                }catch (IllegalArgumentException e) {
                    Toast.makeText(Exp2Activity.this,"服务未注册", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}