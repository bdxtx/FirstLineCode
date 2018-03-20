package com.firstlinecode.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.firstlinecode.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonActivity extends AppCompatActivity implements View.OnClickListener {
    String json="[{'id':'5','name':'google','version':'1.0'},{'id':'6','name':'baidu','version':'2.2'},{'id':'7','name':'ali','version':'3.3'}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        findViewById(R.id.JsonObject).setOnClickListener(this);
        findViewById(R.id.gson).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.JsonObject:
                parseJsonWithJsonObject();
                break;
            case R.id.gson:
                parseJsonWithGson();
                break;
        }
    }
    private void parseJsonWithJsonObject(){
        try {
            JSONArray jsonArray=new JSONArray(json);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String id=jsonObject.getString("id");
                String name=jsonObject.getString("name");
                String version=jsonObject.getString("version");
                Log.d("csc",id+name+version);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJsonWithGson(){
        Gson gson=new Gson();
        List<App> appList=gson.fromJson(json,new TypeToken<List<App>>(){}.getType());
        for (App app :appList) {
            Log.d("csc",app.getId()+app.getName()+app.getVersion());
        }
    }
}
