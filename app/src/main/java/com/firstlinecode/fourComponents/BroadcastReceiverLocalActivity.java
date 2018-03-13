package com.firstlinecode.fourComponents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firstlinecode.R;

public class BroadcastReceiverLocalActivity extends AppCompatActivity {

    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_local);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button button= (Button) findViewById(R.id.localReceiver);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.firstlinecode.fourComponents.broadcastReceiver.LocalBroadcastReceiver");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.firstlinecode.fourComponents.broadcastReceiver.LocalBroadcastReceiver");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,filter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"接收到了本地广播",Toast.LENGTH_SHORT).show();
        }
    }
}
