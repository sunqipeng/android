package com.example;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-11
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
public class AppIntentService extends IntentService {

    public AppIntentService() {
        super("");
    }

    public AppIntentService(String name) {
        super("app");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("app", "Service Thread id is " + String.valueOf(Thread.currentThread().getId()));
    }
}
