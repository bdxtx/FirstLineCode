package com.firstlinecode.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firstlinecode.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpActivity extends AppCompatActivity {

    private TextView httpShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        Button httpBtn= (Button) findViewById(R.id.httpBtn);
        httpShow = (TextView) findViewById(R.id.httpShow);
        httpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithHttpUrlConnect();
            }
        });
        Button okHttpBtn= (Button) findViewById(R.id.okHttpBtn);
        okHttpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequestWithOkHttp();
            }
        });
    }
    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url="https://zhidao.baidu.com/question/457099811.html";
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url(url).build();
                Call call=client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
//                        String result=response.body().string();
                        String result=new String(response.body().bytes(),"GBK");//默认转换的编码格式是UTF-8，这里指定为GBK
                        showResponse(result);
                    }
                });
            }
        }).start();
    }
    private void sendRequestWithHttpUrlConnect(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection=null;
                BufferedReader reader=null;
                try {
                    URL url=new URL("https://zhidao.baidu.com/question/457099811.html");
                    httpURLConnection= (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        reader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        showResponse(response.toString());
                    }else{
                        Log.d("csc","连接失败");
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (reader!=null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (httpURLConnection!=null){
                        httpURLConnection.disconnect();
                    }
                }
            }
        }).start();
    }
    private void showResponse(final String response){
        HttpActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                httpShow.setText(response);
            }
        });
    }
    interface CallBackToShow{
        void backSuccess();
        void backFail();
    }
}
