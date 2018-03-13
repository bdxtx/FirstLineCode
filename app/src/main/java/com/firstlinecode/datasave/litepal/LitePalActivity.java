package com.firstlinecode.datasave.litepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firstlinecode.R;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class LitePalActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        findViewById(R.id.litePal_create).setOnClickListener(this);
        findViewById(R.id.litePal_insert).setOnClickListener(this);
        findViewById(R.id.litePal_update).setOnClickListener(this);
        findViewById(R.id.litePal_delete).setOnClickListener(this);
        findViewById(R.id.litePal_query).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.litePal_create:
                Connector.getDatabase();
                Toast.makeText(LitePalActivity.this,"创建了数据库",Toast.LENGTH_SHORT).show();
                break;
            case R.id.litePal_insert:
                Book book=new Book();
                book.setName("第一行代码");
                book.setAuthor("郭林");
                book.setPages(800);
                book.setPrice(29.0);
                book.setPress("kkwee");
                book.save();
                Toast.makeText(LitePalActivity.this,"插入数据",Toast.LENGTH_SHORT).show();
                break;
            case R.id.litePal_update:
                Book updateBook=new Book();
                updateBook.setPrice(55.0);
                updateBook.setPress("kk");
                updateBook.updateAll("name=?","第一行代码");
                Toast.makeText(LitePalActivity.this,"修改数据",Toast.LENGTH_SHORT).show();
                break;
            case R.id.litePal_delete:
                DataSupport.deleteAll(Book.class,"price>?","30");
                Toast.makeText(LitePalActivity.this,"删除数据",Toast.LENGTH_SHORT).show();
                break;
            case R.id.litePal_query:
                List<Book>bookList= DataSupport.findAll(Book.class);//表示select* from book
//                List<Book>bookList= DataSupport.select("name","author","pages","price").where("pages>?","700").order("pages").limit(10).offset(1).find(Book.class);//查找这四列pages大于300，按照pages排列，查找前10行，从第二行开始排列
                for (Book book1:bookList){
                    Log.d("csc",book1.toString());
                }
                Toast.makeText(LitePalActivity.this,"数据查询成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
