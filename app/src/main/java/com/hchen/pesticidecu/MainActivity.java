package com.hchen.pesticidecu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] strs = {"基神","B神","翔神","曹神","J神"};
        //创建ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,strs);
        //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器
        ListView list_test = (ListView) findViewById(R.id.list_test);
        list_test.setAdapter(adapter);
    }
}
