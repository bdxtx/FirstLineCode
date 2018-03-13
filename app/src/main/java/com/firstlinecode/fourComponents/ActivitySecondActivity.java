package com.firstlinecode.fourComponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firstlinecode.R;

public class ActivitySecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        String data=intent.getStringExtra("data");

        Toast.makeText(ActivitySecondActivity.this,data,Toast.LENGTH_SHORT).show();
    }
}
