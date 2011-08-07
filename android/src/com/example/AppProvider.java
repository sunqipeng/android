package com.example;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-4
 * Time: 上午10:03
 * To change this template use File | Settings | File Templates.
 */
public class AppProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);    //To change body of overridden methods use File | Settings | File Templates.
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget);

        rv.setTextViewText(R.id.tv2, String.valueOf(System.currentTimeMillis()));
        appWidgetManager.updateAppWidget(appWidgetIds, rv);
    }
}
