package com.firstlinecode.datasave;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firstlinecode.R;

public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener{

    private MyDatabaseHelper myDatabaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        myDatabaseHelper = new MyDatabaseHelper(SQLiteActivity.this,"Book.db",null,4);
        findViewById(R.id.createDB).setOnClickListener(this);
        findViewById(R.id.insert).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.query).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createDB:
                myDatabaseHelper.getWritableDatabase();
                break;
            case R.id.insert:
                db= myDatabaseHelper.getWritableDatabase();
                db.execSQL("insert into book (name,author,pages,price) values (?,?,?,?)",new String[]{"第一行代码","郭林","600","50"});
                db.execSQL("insert into book (name,author,pages,price) values (?,?,?,?)",new String[]{"第二行代码","郭林","700","60"});
//                ContentValues values=new ContentValues();
//                values.put("name","第一行代码");
//                values.put("author","郭林");
//                values.put("pages","600");
//                values.put("price","50");
//                db.insert("book",null,values);
                Toast.makeText(SQLiteActivity.this,"添加数据成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.update:
                db= myDatabaseHelper.getWritableDatabase();
                db.execSQL("update book set price=? where name=?",new String[]{"30","第一行代码"});
                Toast.makeText(SQLiteActivity.this,"修改数据成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                db= myDatabaseHelper.getWritableDatabase();
                db.execSQL("delete from book where pages>?",new String[]{"600"});
                Toast.makeText(SQLiteActivity.this,"删除数据成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.query:
                db= myDatabaseHelper.getWritableDatabase();
                Cursor cursor=db.rawQuery("select * from book",null);
                if (cursor.moveToFirst()){
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));
                        Toast.makeText(SQLiteActivity.this,name+author+pages+price,Toast.LENGTH_SHORT).show();
                    }while (cursor.moveToNext());
                }
                Toast.makeText(SQLiteActivity.this,"查询数据成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
