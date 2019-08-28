package com.mll.writenumber2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends Activity {       //AboutActivity类头部

    @Override
    protected void onCreate(Bundle savedInstanceState) {        //onCreate()方法头部
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }       //onCreate()方法尾部

    public void OnBack(View v){
        AboutActivity.this.finish();
    }
}       //AboutActivity类尾部
