package com.example;

import android.content.Context;
import android.location.LocationManager;
import com.google.android.maps.GeoPoint;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-10
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */
public class LocationUtil {

    private static LocationManager locationManager;

    /**
     * 不允许自己new这个对象
     */
    private LocationUtil() {

    }

    /**
     * 初始化操作
     *
     * @param context
     * @return
     */
    public static LocationUtil getInstance(Context context) {

        if (locationManager == null) {

            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        }
        return new LocationUtil();
    }


    /**
     * 获取当前自己自己的位置
     *
     * @return
     */
    public GeoPoint getSelfLocation() {

        //Double la = locationManager.getLastKnownLocation("network").getLatitude() * 1E6 + 1000000;
        //Double lo = locationManager.getLastKnownLocation("network").getLongitude() * 1E6 + 2000000;
        return new GeoPoint(34190903, 122341522);
    }


    public boolean OpenGps() {
        return true;
    }

}
