package com.example;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ZoomControls;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MyActivity extends MapActivity {
    public MapController getMapController() {
        return mapController;
    }

    public MapView getMapView() {
        return mapView;
    }

    MapController mapController;
    MapView mapView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);    //To change body of overridden methods use File | Settings | File Templates.
        this.setContentView(R.layout.main);

        mapView = (MapView) this.findViewById(R.id.map);
        mapController = mapView.getController();

        initZoomController();

        locationSelf();

        initReceiver();

        initDear();
    }

    /**
     *
     */
    private void initDear() {
        Button button = (Button) this.findViewById(R.id.location_her);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(MyActivity.this, "发送请求位置短信", Toast.LENGTH_LONG).show();

                SmsManager.getDefault().sendTextMessage("13506481929", null, "request", null, null);
            }
        });
    }


    private void initReceiver() {
        MessageReceiver receiver = new MessageReceiver(this);
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.setPriority(Integer.MAX_VALUE);
        intentFilter.addCategory("android.intent.category.DEFAULT");
        this.registerReceiver(receiver, intentFilter);
    }

    /**
     * 定位自己的位置
     */
    private void locationSelf() {
        final LocationUtil locationUtil = LocationUtil.getInstance(this);
        final Button button = (Button) this.findViewById(R.id.location_self);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mapController.animateTo(locationUtil.getSelfLocation());
                //button.setText(stringBuilder.toString());
            }
        });
    }


    /**
     * 放大缩小地图
     */
    private void initZoomController() {

        ZoomControls zoomControls = (ZoomControls) this.findViewById(R.id.zoom);
        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MyActivity.this.mapController.zoomIn();
            }
        });
        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MyActivity.this.mapController.zoomOut();
            }
        });


    }

    @Override
    public void onNewIntent(Intent intent) {
        String message = intent.getExtras().getString("sms_body");
        Toast.makeText(this, message, Toast.LENGTH_LONG);
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for (String menuTitle : OptionMenu.getMenuContent()) {
            menu.add(menuTitle);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuProcess.process(item, this);
        return true;
    }
}
