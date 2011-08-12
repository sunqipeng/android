package com.example.secondpkg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.example.R;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-12
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 */
public class ViewTest extends View {

    Paint paint = null;


    public ViewTest(Context context) {
        super(context);

        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.rgb(153, 190, 39));

    }

    public ViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ViewTest(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawRect(100, 200, 200, 300, paint);
        canvas.save();
        canvas.rotate(45);
        //paint.setColor(Color.BLUE);
        canvas.scale(2, 2);
        canvas.drawRect(150, 10, 200, 60, paint);
        android.graphics.Matrix matrix = new android.graphics.Matrix();

        //canvas.drawRect(150, 80, 200, 60, paint);
        canvas.restore();
        canvas.save();
        canvas.rotate(45);

        canvas.drawRect(150, 10, 200, 60, paint);
        canvas.restore();
        this.setBackgroundResource(R.drawable.aaaa);

    }
}
