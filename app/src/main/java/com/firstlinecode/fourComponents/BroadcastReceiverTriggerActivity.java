package com.firstlinecode.fourComponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firstlinecode.R;

public class BroadcastReceiverTriggerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_trigger);
        Button button= (Button) findViewById(R.id.triggerBroadcastReceiver);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.firstlinecode.fourComponents.broadcastReceiver.MyBroadcastReceiver");
//                sendBroadcast(intent);
                sendOrderedBroadcast(intent,null);
            }
        });
    }
}
