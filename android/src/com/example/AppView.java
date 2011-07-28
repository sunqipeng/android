package com.example;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-7-28
 * Time: 上午8:53
 * To change this template use File | Settings | File Templates.
 */
public class AppView extends View {

    public AppView(Context context) {
        super(context);
    }

    public AppView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);    //To change body of overridden methods use File | Settings | File Templates.
        Paint p = new Paint();
        p.setColor(R.color.line_color);
        p.setStrokeCap(Paint.Cap.BUTT);
        p.setTextAlign(Paint.Align.LEFT);
        canvas.drawRect(new Rect(20, 20, 50, 50), p);

    }
}
