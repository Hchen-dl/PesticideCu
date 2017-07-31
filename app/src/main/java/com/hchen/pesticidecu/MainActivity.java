package com.hchen.pesticidecu;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private NotificationManager mNManager;
    private Notification notify1;
    Bitmap LargeBitmap = null;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
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

        for(int n=0;n<apps.size();n++)
        {
            if(apps.get(n).processName.contains("com.tencent.tmgp.sgame"))
            {
                mContext = MainActivity.this;
                //创建大图标的Bitmap
                LargeBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.lighthouse);
                mNManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notify_a();
                break;
            };
        }

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
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void notify_a()
    {
        //Toast.makeText(getApplicationContext(), "默认Toast样式",Toast.LENGTH_SHORT).show();

        Intent it = new Intent(mContext, OtherActivity.class);
        PendingIntent pit = PendingIntent.getActivity(mContext, 0, it, 0);

        Notification.Builder mBuilder = new Notification.Builder(this);
        mBuilder.setContentTitle("叶良辰")                        //标题
                .setContentText("我有一百种方法让你呆不下去~")      //内容
                .setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
                .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
                .setWhen(System.currentTimeMillis())           //设置通知时间
                .setSmallIcon(R.mipmap.penguins)            //设置小图标
                .setLargeIcon(LargeBitmap)                     //设置大图标
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.zhizunbao))  //设置自定义的提示音
                .setAutoCancel(true)                           //设置点击后取消Notification
                .setContentIntent(pit);                        //设置PendingIntent
        notify1 = mBuilder.build();
        mNManager.notify(1, notify1);
    }
}
