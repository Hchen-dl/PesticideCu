package com.hchen.pesticidecu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    private EditText txt_user;
    private EditText txt_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txt_user=(EditText) findViewById(R.id.txt_user_name);
        txt_password=(EditText)findViewById(R.id.txt_password);

        Button btn_register=(Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(register_listener);
    }
    Button.OnClickListener register_listener=new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent_register=new Intent(RegisterActivity.this,WelcomeActivity.class);
            Bundle bd=new Bundle();
            String username= txt_user.getText().toString();
            bd.putCharSequence("username",username);
            String password= txt_password.getText().toString();
            bd.putCharSequence("password",password);
            intent_register.putExtras(bd);
            startActivity(intent_register);
            RegisterActivity.this.finish();
        }
    };
}
