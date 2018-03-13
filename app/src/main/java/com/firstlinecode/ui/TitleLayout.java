package com.firstlinecode.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firstlinecode.R;

/**
 * Created by chensc on 2018/3/2.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);//LayoutInflater的from方法可以构建一个LayoutInflater对象，然后调用inflate方法可以动态加载布局，第一个参数是布局文件，第二个参数代表添加一个父布局，这里指定为TitleLayout
        Button back=findViewById(R.id.back);
        TextView title=findViewById(R.id.title);
        Button edit=findViewById(R.id.edit);
        TypedArray attr=context.obtainStyledAttributes(attrs,R.styleable.TitleLayout);
        //自定义的属性赋值给title
        if (attr!=null){
            String titleName=attr.getString(R.styleable.TitleLayout_titleName);
            if (!TextUtils.isEmpty(titleName)){
                title.setText(titleName);
            }
            attr.recycle();
        }
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).finish();
            }
        });
        edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"您点击了编辑按钮",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
