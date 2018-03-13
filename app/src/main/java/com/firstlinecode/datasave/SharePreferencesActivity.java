package com.firstlinecode.datasave;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firstlinecode.R;

public class SharePreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepreferences);
        Button save= (Button) findViewById(R.id.saveInSharePreferences);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name="小明";
                int age=22;
                boolean isBoy=true;
                SharedPreferences sharedPreferences=getSharedPreferences("saveInSP", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",name);
                editor.putInt("age",age);
                editor.putBoolean("isBoy",isBoy);
                editor.apply();
                Toast.makeText(SharePreferencesActivity.this,"数据保存完毕",Toast.LENGTH_SHORT).show();
            }
        });
        Button read= (Button) findViewById(R.id.readInSharePreferences);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("saveInSP",Context.MODE_PRIVATE);
                String name=sharedPreferences.getString("name","");
                int age=sharedPreferences.getInt("age",0);
                boolean isBoy=sharedPreferences.getBoolean("isBoy",false);
                Toast.makeText(SharePreferencesActivity.this,name+age+isBoy,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
