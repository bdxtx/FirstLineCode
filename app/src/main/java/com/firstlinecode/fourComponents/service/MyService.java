package com.firstlinecode.fourComponents.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.firstlinecode.MainActivity;
import com.firstlinecode.R;

public class MyService extends Service {
    public MyService() {
    }
    private DownloadBinder mBinder=new DownloadBinder();
    public class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("csc","myService 中startDownload被执行了");
        }
        public void getProgress(){
            Log.d("csc","myService 中getProgress被执行了");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("csc","服务被绑定了onBind");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("csc","服务被创建了onCreate");
        Intent intent=new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        Notification notification=new NotificationCompat.Builder(this)
                .setContentTitle("这是标题")
                .setContentText("这是内容")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("csc","服务启动了onStart");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("csc","服务被销毁了onDestroy");
    }
}
