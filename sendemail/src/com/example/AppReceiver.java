package com.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-12
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class AppReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "the airline mode is open", Toast.LENGTH_SHORT).show();
        if (intent.getExtras().getBoolean("state")) {
            Toast.makeText(context, "the airline mode is open", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "the airline mode is off", Toast.LENGTH_LONG).show();
        }
    }
}
