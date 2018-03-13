package com.firstlinecode.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.firstlinecode.R;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webView= (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);//让webview支持javascript
        webView.setWebViewClient(new WebViewClient());//从一个网页跳转到另一个网页时，目标网页依然在当前webView中打开，而不是去系统浏览器打开网页
        webView.loadUrl("http://www.baidu.com");//设置网站地址

    }
}
