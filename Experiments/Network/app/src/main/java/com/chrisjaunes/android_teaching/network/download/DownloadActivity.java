package com.chrisjaunes.android_teaching.network.download;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chrisjaunes.android_teaching.network.ExpConfig;
import com.chrisjaunes.android_teaching.network.R;

public class DownloadActivity extends AppCompatActivity{
    private DownloadService.DownloadBinder downloadBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            downloadBinder = (DownloadService.DownloadBinder) binder;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) { }
    };

    /** Created By ChrisJaunes
     * 创建了采用绑定模式绑定服务
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        Intent intent = new Intent(DownloadActivity.this, DownloadService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);

        TextView textView = findViewById(R.id.tv_url);
        textView.setText(ExpConfig.DownLoadURL);

        Button btn_startDownload = findViewById(R.id.btn_startDownload);
        btn_startDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadBinder.startDownload(ExpConfig.DownLoadURL);
            }
        });

        Button pauseDownload = (Button)findViewById(R.id.pause_download);
        pauseDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadBinder.pauseDownload();
            }
        });

        Button cancelDownload = (Button)findViewById(R.id.cancel_download);
        cancelDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadBinder.cancelDownload();
            }
        });

        if(ContextCompat.checkSelfPermission(DownloadActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(DownloadActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unbindService(connection);
    }
}
