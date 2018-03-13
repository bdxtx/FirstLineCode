package com.firstlinecode.fourComponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firstlinecode.R;
import com.firstlinecode.fourComponents.broadcastReceiver.MyBroadcastReceiver;

public class BroadcastReceiverManagerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_manager);
        findViewById(R.id.dynamicReceiver).setOnClickListener(this);
        findViewById(R.id.myOwnReceiver).setOnClickListener(this);
        findViewById(R.id.localReceiver).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dynamicReceiver:
                Intent br=new Intent(BroadcastReceiverManagerActivity.this,BroadcastReceiverDynamicActivity.class);
                startActivity(br);
                break;
            case R.id.myOwnReceiver:
                Intent myBr=new Intent(BroadcastReceiverManagerActivity.this,BroadcastReceiverTriggerActivity.class);
                startActivity(myBr);
                break;
            case R.id.localReceiver:
                Intent local=new Intent(BroadcastReceiverManagerActivity.this,BroadcastReceiverLocalActivity.class);
                startActivity(local);
                break;
        }
    }
}
