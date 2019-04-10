package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

public class DrawRoundRect extends View {
    private Paint mPaint;

    public DrawRoundRect(Context context) {
        super(context);
    }

    public DrawRoundRect(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawRoundRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(10,100,getWidth()-10,getHeight()-100,150,150,mPaint);
        }
    }
}
