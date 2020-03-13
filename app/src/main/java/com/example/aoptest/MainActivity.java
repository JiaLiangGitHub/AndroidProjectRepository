package com.example.aoptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @BehaviorTrace(value = "登录",type = 1)
    public void login(View view) {
        long beginTime = System.currentTimeMillis();
        SystemClock.sleep(50);
        long duration = System.currentTimeMillis() - beginTime;
        //保存到数据库
        Log.d("jia", "myLogin: duration=" + duration);
    }
}
