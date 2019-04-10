package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;

public class DrawAnimatorDegree extends View {
    float progress = 0;
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public DrawAnimatorDegree(Context context) {
        super(context);
    }

    public DrawAnimatorDegree(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawAnimatorDegree(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        RectF rectF = new RectF(100,100,600,600);
        canvas.drawArc(rectF,0,progress * 3.6f,false,mPaint);

        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(25);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText((int)progress+"%",350,350,mPaint);
    }
}
