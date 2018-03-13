package com.firstlinecode.multimedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.firstlinecode.R;

public class MultimediaActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        findViewById(R.id.gotoNotification).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gotoNotification:
                Intent notification=new Intent(MultimediaActivity.this,NotificationActivity.class);
                startActivity(notification);
                break;
        }
    }
}
