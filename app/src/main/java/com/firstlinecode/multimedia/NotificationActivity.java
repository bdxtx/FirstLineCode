package com.firstlinecode.multimedia;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firstlinecode.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button button= (Button) findViewById(R.id.startNotification);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Intent intent=new Intent(NotificationActivity.this,MultimediaActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(NotificationActivity.this,0,intent,0);//PendingIntent可以认为是延迟的Intent
                Notification notification=new NotificationCompat.Builder(NotificationActivity.this).setContentIntent(pendingIntent)//点击事件的处理
                        .setContentTitle("这是一个通知的标题")
                        .setContentText("这是通知的内容")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setAutoCancel(true)//点击后通知自动消失
                        .setDefaults(Notification.DEFAULT_ALL)//提示音和提示灯都显示默认效果
                        .build();
                manager.notify(1,notification);
            }
        });
    }
}
