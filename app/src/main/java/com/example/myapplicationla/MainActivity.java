package com.example.myapplicationla;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

public class MainActivity extends BaseActivity {
    TextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello=(TextView)findViewById(R.id.hello);
        hello.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                MobclickAgent.onEvent(MainActivity.this,"796534");
                Log.e("shoucang","lllllllll");
            }
        });

          //当用户使用自有账号登录时，可以这样统计：
          MobclickAgent.onProfileSignIn("1234");
         //当用户使用第三方账号（如新浪微博）登录时，可以这样：
//        MobclickAgent.onProfileSignIn("WB"，"userID");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //登出
        MobclickAgent.onProfileSignOff();
    }
}