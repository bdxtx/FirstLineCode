package com.firstlinecode.fourComponents.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *调用父类的有参构造函数
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("csc","当前线程ID为"+Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        Log.d("csc","myIntentService被销毁了");
    }
}
