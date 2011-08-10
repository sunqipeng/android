package com.example;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-10
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 */
public class AppAdapter extends ArrayAdapter<Map<String, String>> {
    public AppAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

}
