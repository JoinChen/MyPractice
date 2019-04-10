package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;

import java.text.NumberFormat;
import java.text.ParseException;

public class MyGridProgressView extends View {

    Paint mPaint  = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
    int radius ;
    String persent = "";
    float degree;
    int colorStart,colorEnd,colorRemaining;
    private float mm;//百分数转化成float后的值
    private int[] colors;
    private float[] positions;

    public MyGridProgressView(Context context) {
        super(context);
    }

    public MyGridProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        colorRemaining = Color.WHITE;
        colorStart = Color.RED;
        colorEnd = Color.BLUE;
        radius = (canvas.getWidth()-100)/2;
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setAntiAlias(true);
        if (degree + 135 <= 360){
            colors = new int[]{colorRemaining,colorRemaining,colorStart,colorEnd,colorRemaining,colorRemaining};
            positions = new float[]{ 0f,0.125f,0.375f,mm,mm,1f};
        }else {
            colors = new int[]{colorEnd,colorEnd,colorRemaining,colorRemaining,colorStart,colorEnd};
            positions = new float[]{ 0f,mm,mm,0.375f,0.375f,1f};
        }
        SweepGradient sweepGradient = new SweepGradient((canvas.getWidth()-100) / 2 +50 , (canvas.getHeight()-100) / 2 + 50, colors, positions);
        mPaint.setShader(sweepGradient);
        RectF rectF = new RectF(50,50,canvas.getWidth()-50,canvas.getHeight()-50);
        canvas.drawArc(rectF,135,270,false,mPaint);

        drawCircles(canvas);
    }

    private void drawCircles(Canvas canvas){
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setStrokeWidth(2);
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setColor(colorStart);
        RectF rectF = new RectF(50 + 20,50 + 20,canvas.getWidth() - 50 - 20,canvas.getHeight() - 50 - 20);
        canvas.drawArc(rectF,135,270,false,mPaintCircle);
    }

    public void setProgressAndColor(String percent,int colorStart,int colorEnd,int colorRemaining){
        this.colorStart = colorStart;
        this.colorEnd = colorEnd;
        this.colorRemaining = colorRemaining;
        this.persent = percent;
        NumberFormat nf= NumberFormat.getPercentInstance();
        Number m = null;
        try {
            m = nf.parse(percent);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mm = Float.parseFloat(String.valueOf(m));
        degree = 270 * mm;
        if (degree + 135 > 360){
            mm = (degree + 135 - 360) / 360;
        }else {
            mm = (270 * mm + 135) / 360;
        }
        LogUtils.dTag("mm:",mm);
        invalidate();
    }
}
