package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawEvaluator extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int color = 0xffff0000;

    public DrawEvaluator(Context context) {
        super(context);
    }

    public DrawEvaluator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawEvaluator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(color);
        canvas.drawCircle(getWidth()/2,getHeight()/2,200,mPaint);
    }
}
