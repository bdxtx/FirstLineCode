package com.firstlinecode.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by chensc on 2018/2/6.
 */

public class BaseActivity extends AppCompatActivity {
    private String TAG="firstLineCode";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,getClass().getSimpleName()+" onCreate");
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,getClass().getSimpleName()+" onDestroy");
        ActivityCollector.removeActivity(this);
    }
}
