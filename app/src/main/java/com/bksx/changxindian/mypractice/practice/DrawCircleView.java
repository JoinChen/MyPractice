package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawCircleView extends View {
    private Paint paint;
    private Paint strokenPaint;
    private Paint bluePaint;
    private Paint ringPaint;
    private Paint pointPaint;
    private Paint rectpointPaint;


    public DrawCircleView(Context context) {
        super(context);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawCircle(getWidth()/4,150,150,paint);
        canvas.drawPoint(getWidth()/2,getHeight()/2,paint);

        //空心圆
        strokenPaint = new Paint();
        strokenPaint.setColor(Color.BLACK);
        strokenPaint.setStyle(Paint.Style.STROKE);
        strokenPaint.setAntiAlias(true);
        strokenPaint.setFilterBitmap(true);
        strokenPaint.setStrokeWidth(3);
        canvas.drawCircle(getWidth()*3/4,150,150,strokenPaint);

        //蓝色实心圆
        bluePaint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawCircle(getWidth()/4,500,150,paint);

        //线宽为20的空心圆
        ringPaint = new Paint();
        ringPaint.setColor(Color.BLACK);
        ringPaint.setStyle(Paint.Style.STROKE);
        ringPaint.setStrokeWidth(50);
        ringPaint.setAntiAlias(true);
        ringPaint.setFilterBitmap(true);
        canvas.drawCircle(getWidth()*3/4,500,150,ringPaint);

        //圆点
        pointPaint = new Paint();
        pointPaint.setColor(Color.BLACK);
        pointPaint.setStrokeCap(Paint.Cap.ROUND);
        pointPaint.setStrokeWidth(10);
        canvas.drawPoint(getWidth()/2,getHeight()/2,pointPaint);

        //方点
        rectpointPaint = new Paint();
        rectpointPaint.setColor(Color.BLACK);
        rectpointPaint.setStrokeWidth(10);
        rectpointPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(getWidth()*3/4,150,rectpointPaint);
    }
}
