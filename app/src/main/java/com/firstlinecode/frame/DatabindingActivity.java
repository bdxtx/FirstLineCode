package com.firstlinecode.frame;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firstlinecode.R;
import com.firstlinecode.databinding.ActivityDatabindingBinding;

public class DatabindingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingBinding databind=DataBindingUtil.setContentView(this,R.layout.activity_databinding);
        databind.setLoginViewHelper(new LoginViewHelper());
        databind.setMyHandler(new MyHandler());
    }
}
