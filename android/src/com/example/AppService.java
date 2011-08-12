package com.example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-11
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
public class AppService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("app", "oncreate");

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("app", "onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("app", "onStartCommand");
        Log.e("app", "service thread id is " + Thread.currentThread().getId());

        try {
            Thread.currentThread().join(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent in = new Intent("edu.sun.android.BC");
        this.sendBroadcast(in);
        return super.onStartCommand(intent, flags, startId);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
