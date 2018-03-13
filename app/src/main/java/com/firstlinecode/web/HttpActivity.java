package com.firstlinecode.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firstlinecode.R;

import java.net.HttpURLConnection;

public class HttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        Button httpBtn= (Button) findViewById(R.id.httpBtn);
        TextView httpShow= (TextView) findViewById(R.id.httpShow);
        httpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void sendRequestWithHttpUrlConnect(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection
            }
        }).start();
    }
}
