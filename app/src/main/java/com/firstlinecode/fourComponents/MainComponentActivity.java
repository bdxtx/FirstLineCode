package com.firstlinecode.fourComponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firstlinecode.R;

public class MainComponentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_component);
        findViewById(R.id.activity_).setOnClickListener(this);
        findViewById(R.id.broadcast_).setOnClickListener(this);
        findViewById(R.id.contentProvider_).setOnClickListener(this);
        findViewById(R.id.service_).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_:
                Intent intent=new Intent(MainComponentActivity.this,ActivityFirstActivity.class);
                startActivity(intent);
                break;
            case R.id.broadcast_:
                Intent bm=new Intent(MainComponentActivity.this,BroadcastReceiverManagerActivity.class);
                startActivity(bm);
                break;
            case R.id.contentProvider_:
                Intent contentProvider=new Intent(MainComponentActivity.this,ContentProviderManagerActivity.class);
                startActivity(contentProvider);
                break;
            case R.id.service_:
                Intent service=new Intent(MainComponentActivity.this,ServiceActivity.class);
                startActivity(service);
                break;
            default:
                break;
        }
    }
}
