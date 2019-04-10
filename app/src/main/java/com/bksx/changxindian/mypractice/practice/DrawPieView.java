package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.View;

import com.bksx.changxindian.mypractice.Count;

import java.util.ArrayList;
import java.util.List;

public class DrawPieView extends View {

    private String NAME = "饼图";

    private List<Count> counts;
    private Paint paint;
    private float max;
    private float startC,startCC,sweepEnd;
    private float centerX;
    private float sweep;

    public DrawPieView(Context context) {
        super(context);
        init();
    }

    public DrawPieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawPieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        counts = new ArrayList<>();
        Count count = new Count("Froyo", 1.0f, Color.GREEN);
        counts.add(count);
        count = new Count("GB", 2.0f, Color.BLUE);
        counts.add(count);
        count = new Count("ICS", 2.0f, Color.BLACK);
        counts.add(count);
        count = new Count("JB", 5.0f, Color.RED);
        counts.add(count);
        count = new Count("KitKat", 10.0f, Color.YELLOW);
        counts.add(count);
        count = new Count("L", 12.0f, Color.CYAN);
        counts.add(count);
        count = new Count("M", 4.0f, Color.GRAY);
        counts.add(count);
        max = Float.MIN_VALUE;
        for (Count c : counts) {
            max = Math.max(max, c.getTrans());
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(2);
        paint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
//        canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);
        startC = 0;
        startCC = 0;
        centerX = 0;
        float fTY = 0;
        float fTX = 0;
        for (Count c : counts) {
            sweep = c.getTrans()/36f * 360;
            float length = 600;
            paint.setColor(c.getImage());
            RectF rectF = new RectF(100, 100, length, length);
            float radius = length - 100;
            if (c.getName().equals("L")){
                //计算偏移量
                float fTranslate = 180 - (360 - startC - sweep/2);
                fTY = (float) (Math.sin(fTranslate * Math.PI/180) * 30);
                fTX = (float) (Math.cos(fTranslate * Math.PI/180) * 30);
                RectF rectF1 = new RectF(100 - fTX, 100 - fTY,length - fTX, length - fTY);
                canvas.drawArc(rectF1, startC,sweep, true, paint);
            }else {
                canvas.drawArc(rectF, startC,sweep, true, paint);
            }
            paint.setColor(Color.LTGRAY);
            paint.setStrokeWidth(3);
            startCC = startC + sweep/2;
            startC += sweep;
            if (startCC >= 0 && startCC < 90) {
                float floatX = (float) (Math.cos(startCC * Math.PI/180) * (radius / 2) + radius / 2 + 100);
                float floatY = (float) (Math.sin(startCC * Math.PI/180) * (radius / 2) + radius / 2 + 100);
                float floatToX = (float) ((Math.cos(startCC * Math.PI/180) * 20) + floatX);
                float floatToY = (float) ((Math.sin(startCC * Math.PI/180) * 20) + floatY);
                canvas.drawLine(floatX, floatY, floatToX, floatToY, paint);
                canvas.drawLine(floatToX, floatToY, 650, floatToY, paint);
                canvas.drawText(c.getName(),650,floatToY,paint);
            }else if (startCC >= 90 && startCC < 180){
                startCC = startCC - 90;
                float floatY = (float) (radius / 2  + Math.cos(startCC * Math.PI/180) * (radius / 2) + 100);
                float floatX = (float) (radius / 2 - Math.sin(startCC * Math.PI/180) * (radius / 2) + 100);
                float floatToY = (float) (floatY + (Math.cos(startCC * Math.PI/180) * 20));
                float floatToX = (float) (floatX - (Math.sin(startCC * Math.PI/180) * 20));
                Log.d("floatToX:",floatToX+"");
                canvas.drawLine(floatX, floatY, floatToX, floatToY, paint);
                canvas.drawLine(floatToX, floatToY, 110, floatToY, paint);
                canvas.drawText(c.getName(),110 -100,floatToY,paint);
            }else if (startCC >= 180 && startCC < 270){
                startCC = startCC - 180;
                float floatX = (float) (radius / 2 - Math.cos(startCC * Math.PI/180) * (radius / 2) + 100 - fTX);
                float floatY = (float) (radius / 2 - Math.sin(startCC * Math.PI/180) * (radius / 2) + 100 - fTY);
                float floatToX = (float) (floatX - (Math.cos(startCC * Math.PI/180) * 20));
                float floatToY = (float) (floatY - (Math.sin(startCC * Math.PI/180) * 20));
                canvas.drawLine(floatX, floatY, floatToX, floatToY, paint);
                canvas.drawLine(floatToX, floatToY, 110, floatToY, paint);
                canvas.drawText(c.getName(),110 - 50,floatToY,paint);
            }else if (startCC >= 270 && startCC < 360){
                startCC = startCC - 270;
                Log.d("startCC:",startCC+"");
                float floatY = (float) ( radius / 2 - Math.cos(startCC * Math.PI/180) * (radius / 2) + 100);
                float floatX = (float) (radius / 2 + Math.sin(startCC * Math.PI/180) * (radius / 2) + 100);
                float floatToY = (float) (floatY - (Math.cos(startCC * Math.PI/180) * 20));
                float floatToX = (float) (floatX + (Math.sin(startCC * Math.PI/180) * 20));
                canvas.drawLine(floatX, floatY, floatToX, floatToY, paint);
                canvas.drawLine(floatToX, floatToY, 650, floatToY, paint);
                canvas.drawText(c.getName(),650,floatToY,paint);
            }
        }

        drawLine(canvas,paint);
    }

    /*绘制分割线*/
    public void drawLine(Canvas canvas ,Paint mPaint){
        float floatEndX = 0;
        float floatEndY = 0;
        sweepEnd = 0;
        float sweeped = 0;
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(3);
        for (Count c : counts) {
            sweep = c.getTrans()/36f * 360;
            sweepEnd += sweep;
            Log.d("sweepEnd:",sweepEnd+"");
            if (sweepEnd >= 0 && sweepEnd < 90){
                sweeped = sweepEnd;
                floatEndX = (float) (Math.cos(sweeped * Math.PI/180) * 250 + 250 + 100);
                floatEndY = (float) (Math.sin(sweeped * Math.PI/180) * 250 + 250 + 100);
                canvas.drawLine(350,350,floatEndX,floatEndY,mPaint);
            }else if (sweepEnd >= 90 && sweepEnd < 180){
                sweeped = sweepEnd - 90;
                floatEndY = (float) (Math.cos(sweeped * Math.PI/180) * 250 + 250 + 100);
                floatEndX = (float) (-Math.sin(sweeped * Math.PI/180) * 250 + 250 + 100);
                canvas.drawLine(350,350,floatEndX,floatEndY,mPaint);
            }else if (sweepEnd >= 180 && sweepEnd < 270){
                sweeped = sweepEnd - 180;
                floatEndX = (float) (-Math.cos(sweeped * Math.PI/180) * 250 + 250 + 100);
                floatEndY = (float) (-Math.sin(sweeped * Math.PI/180) * 250 + 250 + 100);
                canvas.drawLine(350,350,floatEndX,floatEndY,mPaint);
            }else if (sweepEnd >= 270 && sweepEnd <= 360){
                sweeped = sweepEnd - 270;
                floatEndY = (float) (-Math.cos(sweeped * Math.PI/180) * 250 + 250 + 100);
                floatEndX = (float) (Math.sin(sweeped * Math.PI/180) * 250 + 250 + 100);
                canvas.drawLine(350,350,floatEndX,floatEndY,mPaint);
            }
        }
    }
}
