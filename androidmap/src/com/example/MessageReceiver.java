package com.example;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-10
 * Time: 下午6:32
 * To change this template use File | Settings | File Templates.
 */
public class MessageReceiver extends BroadcastReceiver {

    public MessageReceiver(MyActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Object[] puds = (Object[]) intent.getExtras().get("pdus");
        for (Object obj : puds) {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);
            if (message.getDisplayMessageBody().indexOf("requst_location") >= 0) {
                Toast.makeText(context, "接收到了位置短信-准备更新", Toast.LENGTH_SHORT).show();
                updateUI(message);
            }
            if (message.getDisplayMessageBody().equals("request")) {
                Toast.makeText(context, "接收到了请求位置的短信", Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(Contant.SMS_SEND_STATUS);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, ii, PendingIntent.FLAG_UPDATE_CURRENT);
                SmsManager.getDefault().sendTextMessage("13506481929", null, getReplyString(), null, null);
            }
        }
    }

    public String getReplyString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("前缀:");
        stringBuilder.append("requst_location:");
        stringBuilder.append(activity.getMapView().getMapCenter().getLatitudeE6());
        stringBuilder.append(":");
        stringBuilder.append(activity.getMapView().getMapCenter().getLongitudeE6());
        return stringBuilder.toString();
    }

    public MyActivity getActivity() {
        return activity;
    }

    public void setActivity(MyActivity activity) {
        this.activity = activity;
    }

    MyActivity activity;

    public void updateUI(SmsMessage message) {
        String[] messages = message.getDisplayMessageBody().split(":");
        for (String str : messages) {
            Log.e("app", str);
        }
        String la = messages[2];
        String lo = messages[3];
        GeoPoint point = new GeoPoint(Integer.parseInt(la), Integer.parseInt(lo));
        activity.mapController.animateTo(point);
    }
}
