package com.firstlinecode.fourComponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firstlinecode.R;

public class ContentProviderManagerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_manager);
        findViewById(R.id.gotoGetContacts).setOnClickListener(this);
        findViewById(R.id.gotoProvideData).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gotoGetContacts:
                Intent intent=new Intent(ContentProviderManagerActivity.this,ContentProviderGetContactActivity.class);
                startActivity(intent);
                break;
            case R.id.gotoProvideData:
                Intent provideData=new Intent(ContentProviderManagerActivity.this,ContentProviderCustomActivity.class);
                startActivity(provideData);
                break;
        }
    }
}
