package com.firstlinecode.fourComponents.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"这边也接收到了自定义的广播",Toast.LENGTH_SHORT).show();
    }
}
