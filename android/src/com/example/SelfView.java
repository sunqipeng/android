package com.example;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-7
 * Time: 上午12:34
 * To change this template use File | Settings | File Templates.
 */
public class SelfView extends View {

    public SelfView(Context context) {
        super(context);
    }

    public SelfView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelfView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.setClickable(true);
        this.setFocusableInTouchMode(true);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);    //To change body of overridden methods use File | Settings | File Templates.
        this.setMeasuredDimension(400, 800);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);    //To change body of overridden methods use File | Settings | File Templates.
        Paint p = new Paint();
        p.setColor(Color.rgb(255, 255, 0));
        canvas.drawText("2222222", 10, 20, p);

    }

    @Override
    protected void onCreateContextMenu(ContextMenu menu) {
        super.onCreateContextMenu(menu);    //To change body of overridden methods use File | Settings | File Templates.
        menu.add("aaaaaaaa");
        menu.add("aaaaaaaa");
        menu.add("aaaaaaaa");
        menu.add("aaaaaaaa");

    }
}
