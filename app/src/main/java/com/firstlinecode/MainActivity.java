package com.firstlinecode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.firstlinecode.androidpermission.PermissionActivity;
import com.firstlinecode.datasave.DataSaveActivity;
import com.firstlinecode.datasave.SaveInFileActivity;
import com.firstlinecode.fourComponents.MainComponentActivity;
import com.firstlinecode.multiThread.ThreadActivity;
import com.firstlinecode.multimedia.MultimediaActivity;
import com.firstlinecode.ui.UiManagerActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startComponent).setOnClickListener(this);
        findViewById(R.id.startPermission).setOnClickListener(this);
        findViewById(R.id.startDataSave).setOnClickListener(this);
        findViewById(R.id.startMultimedia).setOnClickListener(this);
        findViewById(R.id.startMultiThread).setOnClickListener(this);
        findViewById(R.id.startUI).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startComponent:
                Intent intent=new Intent(MainActivity.this, MainComponentActivity.class);
                startActivity(intent);
                break;
            case R.id.startPermission:
                Intent permission=new Intent(MainActivity.this, PermissionActivity.class);
                startActivity(permission);
                break;
            case R.id.startDataSave:
                Intent dataSave=new Intent(MainActivity.this, DataSaveActivity.class);
                startActivity(dataSave);
                break;
            case R.id.startMultimedia:
                Intent multimedia=new Intent(MainActivity.this, MultimediaActivity.class);
                startActivity(multimedia);
                break;
            case R.id.startMultiThread:
                Intent multiThread=new Intent(MainActivity.this, ThreadActivity.class);
                startActivity(multiThread);
                break;
            case R.id.startUI:
                Intent uiManager=new Intent(MainActivity.this, UiManagerActivity.class);
                startActivity(uiManager);
                break;
        }
    }
}
