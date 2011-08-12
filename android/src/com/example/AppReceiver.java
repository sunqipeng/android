package com.example;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-11
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
public class AppReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.e("app", context.getClass().getPackage().getName() + context.getClass().getCanonicalName());

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        //notificationManager.cancelAll();
        notificationManager.cancel(1);
        Toast toast = Toast.makeText(context, "服务执行完毕！", Toast.LENGTH_SHORT);
        toast.show();
    }
}
