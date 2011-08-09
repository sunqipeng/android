package com.example;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-8
 * Time: 下午11:54
 * To change this template use File | Settings | File Templates.
 */
public class CurrentLocation extends Overlay {

    @Override
    public void draw(Canvas canvas, MapView mapView, boolean b) {

        super.draw(canvas, mapView, b);    //To change body of overridden methods use File | Settings | File Templates.
        Paint p = new Paint();
        p.setColor(Color.rgb(255, 255, 0));


    }
}
