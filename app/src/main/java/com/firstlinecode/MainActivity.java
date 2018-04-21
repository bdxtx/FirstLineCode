package com.firstlinecode;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.firstlinecode.androidpermission.PermissionActivity;
import com.firstlinecode.datasave.DataSaveActivity;
import com.firstlinecode.datasave.SaveInFileActivity;
import com.firstlinecode.fourComponents.MainComponentActivity;
import com.firstlinecode.frame.DatabindingActivity;
import com.firstlinecode.multiThread.ThreadActivity;
import com.firstlinecode.multimedia.MultimediaActivity;
import com.firstlinecode.ui.UiManagerActivity;
import com.firstlinecode.web.WebManagerActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.startComponent).setOnClickListener(this);
        findViewById(R.id.startPermission).setOnClickListener(this);
        findViewById(R.id.startDataSave).setOnClickListener(this);
        findViewById(R.id.startMultimedia).setOnClickListener(this);
        findViewById(R.id.startMultiThread).setOnClickListener(this);
        findViewById(R.id.startUI).setOnClickListener(this);
        findViewById(R.id.startWeb).setOnClickListener(this);
        findViewById(R.id.startDataBinding).setOnClickListener(this);
        findViewById(R.id.fab).setOnClickListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawerLayout);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        NavigationView nav_view= (NavigationView) findViewById(R.id.nav_view);
        nav_view.setCheckedItem(R.id.nav_call);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
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
            case R.id.startWeb:
                Intent webManager=new Intent(MainActivity.this, WebManagerActivity.class);
                startActivity(webManager);
                break;
            case R.id.startDataBinding:
                Intent databinding=new Intent(MainActivity.this, DatabindingActivity.class);
                startActivity(databinding);
                break;
            case R.id.fab:
                Snackbar.make(v,"我们的第一个SnackBar",Snackbar.LENGTH_SHORT).setAction("取消", new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"我们点击了悬浮按钮",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this,"您点击了Backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"您点击了delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this,"您点击了setting",Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}
