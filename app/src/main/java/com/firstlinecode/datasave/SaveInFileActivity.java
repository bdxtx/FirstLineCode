package com.firstlinecode.datasave;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.firstlinecode.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SaveInFileActivity extends AppCompatActivity {

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_in_file);
        et = (EditText) findViewById(R.id.et_saveInFile);
        String string=read();
        if (!TextUtils.isEmpty(string)){
            et.setText(string);
            et.setSelection(string.length());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save();
    }
    private void save(){
        FileOutputStream fileOutputStream;
        BufferedWriter writer=null;
        try {
            fileOutputStream = openFileOutput("data", Context.MODE_PRIVATE);
            writer= new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            writer.write(et.getText().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private String read(){
        BufferedReader reader=null;
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("");
        try {
            FileInputStream fileInputStream = openFileInput("data");
            reader=new BufferedReader(new InputStreamReader(fileInputStream));
            String line="";
            while ((line=reader.readLine())!=null){
                stringBuffer.append(line);
            }
        } catch (FileNotFoundException e) {
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
        }
        return stringBuffer.toString();
    }
}
