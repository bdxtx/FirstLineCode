package com.firstlinecode.fourComponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firstlinecode.R;

public class ActivityThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button goBackFirst= (Button) findViewById(R.id.goBackFirst);
        goBackFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(ActivityThirdActivity.this,ActivityFirstActivity.class);
                Intent intent=new Intent();
                intent.putExtra("backData","从第三个界面返回的数据");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
