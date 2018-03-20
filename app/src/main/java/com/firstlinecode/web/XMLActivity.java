package com.firstlinecode.web;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firstlinecode.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

public class XMLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        parseXMLWithPull();
    }

    //用pull解析xml
    private void parseXMLWithPull(){
        File file = new File("/mnt/sdcard/1/myXML.xml");
        BufferedReader reader=null;
        StringBuilder stringBuilder=new StringBuilder();
        try {
            if (ActivityCompat.checkSelfPermission(XMLActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED) {//读取SD卡需要运行时权限
                InputStream in = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                reader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                String xmlContent=stringBuilder.toString();
                Log.d("csc", "xml的内容是" + xmlContent);
                XmlPullParserFactory pullParserFactory=XmlPullParserFactory.newInstance();
                XmlPullParser xmlPullParser=pullParserFactory.newPullParser();
                xmlPullParser.setInput(new StringReader(xmlContent));
                int eventType=xmlPullParser.getEventType();
                String id="";
                String name="";
                String version="";
                while (eventType!=XmlPullParser.END_DOCUMENT){
                    String nodeName=xmlPullParser.getName();
                    switch (eventType){
                        case XmlPullParser.START_TAG:
                            if ("id".equals(nodeName)){
                                id=xmlPullParser.nextText();
                            }else if ("name".equals(nodeName)){
                                name=xmlPullParser.nextText();
                            }else if ("version".equals(nodeName)){
                                version=xmlPullParser.nextText();
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            if ("app".equals(nodeName)){
                                Log.d("csc",id+name+version);
                            }
                            break;
                        default:
                            break;
                    }
                eventType=xmlPullParser.next();
                }
            }else{
                ActivityCompat.requestPermissions(XMLActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    parseXMLWithPull();
                }else {
                    Toast.makeText(this,"必须授权了访问SD卡权限之后，才能使用",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
