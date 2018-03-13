package com.firstlinecode.multiThread;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firstlinecode.R;

public class ThreadActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int UPDATE_TEXT=1;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE_TEXT:
                    textChange.setText("我在这儿等着你回来");
                    break;
            }
        }
    };
    private TextView textChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        textChange = (TextView) findViewById(R.id.textChange);
        findViewById(R.id.thread).setOnClickListener(this);
        findViewById(R.id.changUI).setOnClickListener(this);
        findViewById(R.id.asyncTask).setOnClickListener(this);
        findViewById(R.id.runOnUiThread).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.thread:
                createNewThread();
                break;
            case R.id.changUI:
                Message message=new Message();
                message.what=UPDATE_TEXT;
                handler.sendMessage(message);
                break;
            case R.id.asyncTask:
                new DownloadTask().execute();
                break;
            case R.id.runOnUiThread:
                ThreadActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textChange.setText("使用了runOnUiThread改变界面");
                        Toast.makeText(ThreadActivity.this,"正在使用runOnUiThread改变界面",Toast.LENGTH_SHORT).show();
                    }
                });
                break;

        }
    }
    private void createNewThread(){
        //1.用继承Thread的方式创建子线程，耦合性比较大
        MyNewThread thread=new MyNewThread();
        thread.start();

        //2.用Runnable的方式创建子线程
        MyThread mThread=new MyThread();
        Thread myThread=new Thread(mThread);
        myThread.start();

        //3.用匿名内部类的方式创建子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("csc","正在用匿名内类方式创建子线程，当前线程的id为"+Thread.currentThread().getId());
            }
        }).start();

    }
    class MyNewThread extends Thread{
        @Override
        public void run() {
            super.run();
            Log.d("csc","正在用继承Thread方式创建子线程，当前线程的id为"+Thread.currentThread().getId());
        }
    }
    class MyThread implements Runnable{

        @Override
        public void run() {
            Log.d("csc","正在用接口实现方式创建子线程，当前线程的id为"+Thread.currentThread().getId());
        }
    }
    class DownloadTask extends AsyncTask{
        @Override
        protected void onPreExecute() {
            //执行任务前调用
            Log.d("csc","在执行耗时操作之前被调用");
        }

        @Override
        protected Object doInBackground(Object[] params) {
            //这里进行耗时操作
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(2000);
                    Log.d("csc","正在执行第"+(i+1)+"次耗时操作");
                    publishProgress((i+1)*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            //对UI进行更新操作,调用publishProgress()得到执行
            Toast.makeText(ThreadActivity.this,"当前进度是"+values[0],Toast.LENGTH_SHORT).show();
            Log.d("csc","当前进度是"+values[0]);
        }

        @Override
        protected void onPostExecute(Object o) {
            //执行任务后调用
            boolean result=(boolean)o;
            if (result){
                Log.d("csc","耗时任务已经执行完毕");
                Toast.makeText(ThreadActivity.this,"耗时任务已经执行完毕",Toast.LENGTH_SHORT).show();
            }else {
                Log.d("csc","任务执行失败");
                Toast.makeText(ThreadActivity.this,"任务执行失败",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
