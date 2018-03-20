package com.firstlinecode.web;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firstlinecode.R;

public class WebManagerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_manager);
        findViewById(R.id.startHttpActivity).setOnClickListener(this);
        findViewById(R.id.startXMLActivity).setOnClickListener(this);
        findViewById(R.id.startJsonActivity).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.startHttpActivity:
                Intent intent=new Intent(this,HttpActivity.class);
                startActivity(intent);
                break;
            case R.id.startXMLActivity:
                Intent XMLActivity=new Intent(this,XMLActivity.class);
                startActivity(XMLActivity);
                break;
            case R.id.startJsonActivity:
                Intent jsonActivity=new Intent(this,JsonActivity.class);
                startActivity(jsonActivity);
                break;
        }
    }
}
