package com.firstlinecode.fourComponents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firstlinecode.R;
import com.firstlinecode.base.BaseActivity;

public class ActivityFirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        if (savedInstanceState!=null){
            String string=savedInstanceState.getString("destroySave");
            Toast.makeText(ActivityFirstActivity.this,string,Toast.LENGTH_LONG).show();
        }
        final Button startSecActivity= (Button) findViewById(R.id.startActivity);
        startSecActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSecondActivity=new Intent(ActivityFirstActivity.this,ActivitySecondActivity.class);
                startSecondActivity.putExtra("data","从第一个activity传递过来的数据");
                startActivity(startSecondActivity);
            }
        });
        Button startTirActivity= (Button) findViewById(R.id.startThirdActivity);
        startTirActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.firstlinecode.action.third");
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (RESULT_OK==resultCode) {
                    String backData = data.getStringExtra("backData");
                    Toast.makeText(ActivityFirstActivity.this, backData, Toast.LENGTH_SHORT).show();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("destroySave","被销毁时保存的数据");
    }
}
