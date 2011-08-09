package com.example;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.maps.*;

public class MyActivity extends MapActivity {
    MapController mapController;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MapView mv = (MapView) this.findViewById(R.id.map);

        mapController = mv.getController();
        mv.getController().setZoom(15);
        MyLocationOverlay myLocationOverlay = new MyLocationOverlay(this, mv);
        myLocationOverlay.enableCompass();
        myLocationOverlay.enableMyLocation();
        mv.getOverlays().add(myLocationOverlay);
        mv.postInvalidate();
        initLocation();
        final Projection projection = mv.getProjection();
        mv.setOnTouchListener(new android.view.View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mapController.animateTo(projection.fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()));
                return true;

            }
        });
    }


    private void initLocation() {
        //To change body of created methods use File | Settings | File Templates.
        LocationManager locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        TextView textView = (TextView) this.findViewById(R.id.tv);
        textView.setText("");
        for (String l : locationManager.getAllProviders()) {
            textView.append(l);
            textView.append("=");
        }

        Location location = locationManager.getLastKnownLocation("network");
        final Double la = location.getLatitude() * 1E6;
        final Double lo = location.getLongitude() * 1E6;
        mapController.setCenter(new GeoPoint(la.intValue(), lo.intValue()));

        final android.os.Handler handler = new android.os.Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);    //To change body of overridden methods use File | Settings | File Templates.
                mapController.animateTo(new GeoPoint(la.intValue() + 12345, lo.intValue() + 12345));
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.currentThread().join(5000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                handler.sendMessage(new Message());
            }
        });
        //t.start();
        Button button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mapController.zoomIn();
            }
        });
        Button button2 = (Button) this.findViewById(R.id.out);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mapController.zoomOut();
            }
        });

    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}
