package com.example;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-10
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
public class BlueListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "蓝牙状态改变了" + intent.getExtras().get(BluetoothAdapter.EXTRA_STATE), Toast.LENGTH_LONG).show();
    }
}
