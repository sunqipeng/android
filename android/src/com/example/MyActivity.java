package com.example;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout ll;
        ll = (LinearLayout) this.findViewById(R.id.mainlo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.main);
        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(MyActivity.this, second.class);
                MyActivity.this.startActivity(intent);
            }

            public void onAnimationRepeat(Animation animation) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        ll.startAnimation(animation);
        initButtonController();
    }

    /**
     * 初始化控件的事件
     */
    private void initButtonController() {

        final Button button = (Button) this.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //sendBroadcast();
                startService();
            }
        });

        Button stop = (Button) this.findViewById(R.id.stopService);
        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MyActivity.this, AppService.class);
                MyActivity.this.stopService(intent);
            }
        });


        Button bc = (Button) this.findViewById(R.id.bc);
        bc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NotificationManager nm = (NotificationManager) MyActivity.this.getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification(R.drawable.icon, "Hello", System.currentTimeMillis());
                notification.vibrate = new long[]{1000, 2000};
                Context context = MyActivity.this.getApplicationContext();
                Intent intent = new Intent("edu.sun.android.BC");
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                notification.setLatestEventInfo(context, "来消息了", "呢哦荣", pendingIntent);
                nm.notify(1, notification);
            }
        });
        Button bc2 = (Button) this.findViewById(R.id.bc2);
        bc2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.e("app", "main thread id is " + Thread.currentThread().getId());
                Intent intent = new Intent(MyActivity.this, AppIntentService.class);
                MyActivity.this.startService(intent);

            }
        });

        Button service2 = (Button) this.findViewById(R.id.service2);
        service2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.e("app", "Begin Bind Service");
                MyActivity.this.bindService(new Intent(MyActivity.this, BindService.class), serviceConnection, BIND_AUTO_CREATE);
            }
        });
    }

    Messenger messenger = null;

    AIDLApp stub;
    final ServiceConnection serviceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("app", "Service Connected");
            stub = AIDLApp.Stub.asInterface(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("app", "Service DisConnected");
        }
    };


    private void startService() {
        Intent intent = new Intent(this, AppService.class);
        Log.e("app", "main thread id is " + Thread.currentThread().getId());

        this.startService(intent);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

        }
    };

    private void sendBroadcast() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    MyActivity.this.sendBroadcast(new Intent("edu.sun.android.BC"));
                    try {
                        Thread.currentThread().join(3000);
                    } catch (InterruptedException e) {
                        Log.e("app", e.getMessage());
                    }
                }
            }
        });
        t.start();
    }

}
