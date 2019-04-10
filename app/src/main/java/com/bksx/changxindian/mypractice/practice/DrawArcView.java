package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class DrawArcView extends View {
    private Paint mPaint;
    private Paint centerPaint;
    private Paint stokenPaint;

    public DrawArcView(Context context) {
        super(context);
    }

    public DrawArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        RectF rectF= new RectF(10,50,getWidth()-10,getHeight()-50);
        canvas.drawArc(rectF,20,140,false,mPaint);

        //通过中心
        centerPaint = new Paint();
        centerPaint.setColor(Color.BLACK);
        centerPaint.setStyle(Paint.Style.FILL);
        centerPaint.setAntiAlias(true);
        canvas.drawArc(rectF,-20,-100,true,centerPaint);

        //圆弧
        stokenPaint = new Paint();
        stokenPaint.setColor(Color.BLACK);
        stokenPaint.setStyle(Paint.Style.STROKE);
        stokenPaint.setStrokeWidth(5);
        stokenPaint.setAntiAlias(true);
        canvas.drawArc(rectF,-130,-50,false,stokenPaint);
    }
}
