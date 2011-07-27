package com.example;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-7-27
 * Time: 上午10:17
 * To change this template use File | Settings | File Templates.
 */
public class BoundService extends Service {

    private LocalBinder binder = new LocalBinder();

    class LocalBinder extends Binder {

        public BoundService getService() {
            return BoundService.this;
        }
    }

    /**
     * 服务类的方法
     *
     * @return
     */
    public String getCurrentDate() {
        return new Date().toLocaleString();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.binder;
    }
}
