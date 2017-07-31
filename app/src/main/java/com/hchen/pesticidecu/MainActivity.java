package com.hchen.pesticidecu;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建ArrayAdapter

        //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器

        Button btn_nex=(Button) findViewById(R.id.btn_next);
        btn_nex.setOnClickListener(nex_listener);
        Button btn_reg=(Button) findViewById(R.id.btn_register_main);
        btn_reg.setOnClickListener(reg_listener);
        ActivityManager am=(ActivityManager)this.getSystemService((ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> apps=am.getRunningAppProcesses();
        String[] strapps=new String[apps.size()];

        for(int n=0;n<apps.size();n++)
        {
            strapps[n]=apps.get(n).processName;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,strapps);
        ListView listapps=(ListView)findViewById(R.id.list_apps);
        listapps.setAdapter(adapter);

    }
    Button.OnClickListener nex_listener=new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent_notice=new Intent(MainActivity.this,NotificationActivity.class);
            startActivity(intent_notice);
            MainActivity.this.finish();
        }
    };
    Button.OnClickListener reg_listener=new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent_main_regi=new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent_main_regi);
            MainActivity.this.finish();
        }
    };
}
