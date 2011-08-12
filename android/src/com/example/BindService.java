package com.example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-11
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
public class BindService extends Service {
    android.os.Handler handler = new android.os.Handler() {

        @Override
        public void handleMessage(Message msg) {
            Log.e("app", "handler a empty message");
        }
    };

    private AIDLApp.Stub stub = new AIDLApp.Stub() {
        public void printMessage() throws RemoteException {

        }
    };


    Messenger message = new Messenger(handler);

    public IBinder onBind(Intent intent) {
        Log.e("app", "service onbinder");
        return stub.asBinder();
    }
}
