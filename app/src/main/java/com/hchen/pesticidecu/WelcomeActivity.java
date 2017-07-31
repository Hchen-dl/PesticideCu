package com.hchen.pesticidecu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {
    private TextView message;
    private String username;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent intent=getIntent();
        Bundle bd=intent.getExtras();
        username=bd.getCharSequence("username").toString();
        password=bd.getCharSequence("password").toString();
        message=(TextView)findViewById(R.id.txt_message);
        message.setText("用户名"+username+"密码"+password);
    }
}
