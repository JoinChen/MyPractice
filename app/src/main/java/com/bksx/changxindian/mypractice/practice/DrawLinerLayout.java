package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class DrawLinerLayout extends LinearLayout {
    Paint mPaint = new Paint();

    public DrawLinerLayout(Context context) {
        super(context);
    }

    public DrawLinerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawLinerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mPaint.setColor(Color.parseColor("#A0E91E63"));
        canvas.drawCircle(50,50,20,mPaint);
        canvas.drawCircle(250,80,35,mPaint);
        canvas.drawCircle(getWidth()/2,getHeight()/2,45,mPaint);
        canvas.drawCircle(80,getHeight()-50,42,mPaint);
    }
}
