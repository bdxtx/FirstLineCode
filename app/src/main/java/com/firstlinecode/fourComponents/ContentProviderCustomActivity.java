package com.firstlinecode.fourComponents;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firstlinecode.R;
import com.firstlinecode.datasave.SQLiteActivity;

public class ContentProviderCustomActivity extends AppCompatActivity implements View.OnClickListener {

    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_custom);
        findViewById(R.id.custom_insert).setOnClickListener(this);
        findViewById(R.id.custom_update).setOnClickListener(this);
        findViewById(R.id.custom_delete).setOnClickListener(this);
        findViewById(R.id.custom_query).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.custom_insert:
                Uri uri=Uri.parse("content://com.firstlinecode.provider/book");//定义内容提供则时候的authorityName，打开androidManifest.xml看一下就可以了
                ContentValues values=new ContentValues();
                values.put("name","第一行代码");
                values.put("author","郭林");
                values.put("price",20.0);
                values.put("pages",400);
                Uri newUri=getContentResolver().insert(uri,values);
                newId = newUri.getPathSegments().get(1);
                Toast.makeText(this,"新添加的数据的id为"+newId,Toast.LENGTH_SHORT).show();
                break;
            case R.id.custom_query:
                Uri queryUri=Uri.parse("content://com.firstlinecode.provider/book");
                Cursor cursor=getContentResolver().query(queryUri,null,null,null,null);
                if (cursor!=null){
                    while (cursor.moveToNext()){
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("csc",name+author+pages+price);
                    }
                    cursor.close();
                    Toast.makeText(this,"数据查询成功",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.custom_update:
                Uri updateUri=Uri.parse("content://com.firstlinecode.provider/book");
                ContentValues contentValues=new ContentValues();
                contentValues.put("price",40.0);
                int updateRows=getContentResolver().update(updateUri,contentValues,null,null);
                Toast.makeText(this,"改变的数据行为"+updateRows,Toast.LENGTH_SHORT).show();
                break;
            case R.id.custom_delete:
                Uri deleteUri=Uri.parse("content://com.firstlinecode.provider/book");
                int deleteRows=getContentResolver().delete(deleteUri,null,null);
                Toast.makeText(this,"删除的数据行为"+deleteRows,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
