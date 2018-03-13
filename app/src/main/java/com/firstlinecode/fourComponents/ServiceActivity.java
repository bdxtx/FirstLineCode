package com.firstlinecode.fourComponents;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.firstlinecode.R;
import com.firstlinecode.fourComponents.service.MyIntentService;
import com.firstlinecode.fourComponents.service.MyService;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        findViewById(R.id.startService).setOnClickListener(this);
        findViewById(R.id.stopService).setOnClickListener(this);
        findViewById(R.id.bindService).setOnClickListener(this);
        findViewById(R.id.unBindService).setOnClickListener(this);
        findViewById(R.id.intentService).setOnClickListener(this);

    }
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.DownloadBinder binder=(MyService.DownloadBinder)service;
            binder.startDownload();
            binder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startService:
                Intent startService=new Intent(ServiceActivity.this, MyService.class);
                startService(startService);
                break;
            case R.id.stopService:
                Intent stopService=new Intent(ServiceActivity.this, MyService.class);
                stopService(stopService);
                break;
            case R.id.bindService:
                Intent bindService=new Intent(ServiceActivity.this, MyService.class);
                bindService(bindService,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unBindService:
                unbindService(connection);
                break;
            case R.id.intentService:
                Log.d("csc","当前线程ID为"+Thread.currentThread().getId());
                Intent intentService=new Intent(ServiceActivity.this, MyIntentService.class);
                startService(intentService);
                break;
        }
    }
}
