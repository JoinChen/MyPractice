package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

public class DrawPathView extends View {

    private Paint mPaint;
    private Path mPath;
    public DrawPathView(Context context) {
        super(context);
    }

    public DrawPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPath = new Path();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPath.addArc(200,200,400,400,-225,225);
            mPath.arcTo(400,200,600,400,-180,225,false);
            mPath.lineTo(400,542);
        }
        canvas.drawPath(mPath,mPaint);
    }
}
