package com.firstlinecode.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firstlinecode.R;
import com.firstlinecode.ui.listview.ListviewActivity;

public class UiManagerActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_manager);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        findViewById(R.id.alertDialog).setOnClickListener(this);
        findViewById(R.id.progressDialog).setOnClickListener(this);
        findViewById(R.id.percentFrameLayout).setOnClickListener(this);
        findViewById(R.id.listView).setOnClickListener(this);
        findViewById(R.id.startWebView).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alertDialog:
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
                alertDialog.setTitle("这是dialog的标题");
                alertDialog.setMessage("你想说什么");
                alertDialog.setCancelable(true);
                alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UiManagerActivity.this,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UiManagerActivity.this,"点击了确定按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
                break;
            case R.id.progressDialog:
                ProgressDialog progressDialog=new ProgressDialog(this);
                progressDialog.setTitle("正在加载");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.percentFrameLayout:
                Intent percent=new Intent(this,PercentActivity.class);
                startActivity(percent);
                break;
            case R.id.listView:
                Intent listView=new Intent(this,ListviewActivity.class);
                startActivity(listView);
                break;
            case R.id.startWebView:
                Intent startWebView=new Intent(this,WebViewActivity.class);
                startActivity(startWebView);
                break;
        }
    }
}
