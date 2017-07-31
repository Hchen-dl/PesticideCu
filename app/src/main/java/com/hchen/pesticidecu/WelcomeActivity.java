package com.hchen.pesticidecu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private TextView txtshow;
    private String name;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txtshow = (TextView)findViewById(R.id.txt_message);
        //获得Intent对象,并且用Bundle出去里面的数据
        Intent it = getIntent();
        Bundle bd = it.getExtras();

        //按键值的方式取出Bundle中的数据
        name = bd.getCharSequence("username").toString();
        password = bd.getCharSequence("password").toString();
        txtshow.setText("尊敬的"+name +"恭喜你,注册成功~");
    }
}
