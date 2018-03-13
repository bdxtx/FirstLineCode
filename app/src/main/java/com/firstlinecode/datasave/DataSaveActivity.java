package com.firstlinecode.datasave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firstlinecode.MainActivity;
import com.firstlinecode.R;
import com.firstlinecode.datasave.litepal.LitePalActivity;

public class DataSaveActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_save);
        findViewById(R.id.gotoSaveInFile).setOnClickListener(this);
        findViewById(R.id.gotoSaveInSharePreferences).setOnClickListener(this);
        findViewById(R.id.gotoSaveInDB).setOnClickListener(this);
        findViewById(R.id.gotoLitePal).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gotoSaveInFile:
                Intent gotoSaveInFile=new Intent(DataSaveActivity.this, SaveInFileActivity.class);
                startActivity(gotoSaveInFile);
                break;
            case R.id.gotoSaveInSharePreferences:
                Intent gotoSaveInSharePreferences=new Intent(DataSaveActivity.this, SharePreferencesActivity.class);
                startActivity(gotoSaveInSharePreferences);
                break;
            case R.id.gotoSaveInDB:
                Intent gotoSaveInDB=new Intent(DataSaveActivity.this, SQLiteActivity.class);
                startActivity(gotoSaveInDB);
                break;
            case R.id.gotoLitePal:
                Intent gotoLitePal=new Intent(DataSaveActivity.this, LitePalActivity.class);
                startActivity(gotoLitePal);
                break;
        }
    }
}
