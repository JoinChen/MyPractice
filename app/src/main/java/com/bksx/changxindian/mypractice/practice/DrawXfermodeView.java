package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.changxindian.mypractice.R;

import java.math.BigInteger;

public class DrawXfermodeView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mPaintXfermode = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap ,bitmap1;

    public DrawXfermodeView(Context context) {
        super(context);
    }

    public DrawXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawXfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        bitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.batman_logo);
        mPaint.setColor(Color.RED);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //默认方式
        canvas.drawBitmap(bitmap,0,0,mPaintXfermode);
        Xfermode xfermode = new Xfermode();
        mPaintXfermode.setXfermode(xfermode);
        canvas.drawBitmap(bitmap1,0,0,mPaintXfermode);
        mPaintXfermode.setXfermode(null);
        canvas.drawText("默认方式",bitmap.getWidth()/2,bitmap.getHeight()/2,mPaint);

        //Xfermode - DST_IN
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        int layerId = canvas.saveLayer(bitmap.getWidth()+100, 0,
                bitmap.getWidth()+100+bitmap.getWidth(), bitmap.getHeight(), null, Canvas.ALL_SAVE_FLAG);
//        canvas.saveLayerAlpha(0, 0, canvas.getWidth(), canvas.getHeight(), 0x88, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(bitmap,bitmap.getWidth()+100,0,mPaintXfermode);
        Xfermode xfermode1 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        mPaintXfermode.setXfermode(xfermode1);
        canvas.drawBitmap(bitmap1,bitmap.getWidth()+100,0,mPaintXfermode);
        mPaintXfermode.setXfermode(null);
        canvas.restoreToCount(layerId);
        canvas.drawText("PorterDuffXfermode"+"\n"+"-DST_IN",bitmap.getWidth()/2 + bitmap.getWidth()+100,bitmap.getHeight()/2,mPaint);

        //Xfermode - DST_OUT
        int layerId1 = canvas.saveLayer(0, bitmap.getHeight()+100,
                bitmap.getWidth(), bitmap.getHeight()+100+bitmap.getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(bitmap,0,bitmap.getHeight()+100,mPaintXfermode);
        Xfermode xfermode2 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        mPaintXfermode.setXfermode(xfermode2);
        canvas.drawBitmap(bitmap1,0,bitmap.getHeight()+100,mPaintXfermode);
        mPaintXfermode.setXfermode(null);
        canvas.restoreToCount(layerId1);
        canvas.drawText("PorterDuffXfermode"+"\n"+"-DST_OUT",bitmap.getWidth()/2 ,bitmap.getHeight()/2 + bitmap.getHeight() + 100,mPaint);

        //Xfermode - DST_OUT
        int layerId2 = canvas.saveLayer(bitmap.getWidth()+100, bitmap.getHeight()+100,
                bitmap.getWidth()+100+bitmap.getWidth(), bitmap.getHeight()+100+bitmap.getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(bitmap,bitmap.getWidth()+100,bitmap.getHeight()+100,mPaintXfermode);
        Xfermode xfermode3 = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        mPaintXfermode.setXfermode(xfermode3);
        canvas.drawBitmap(bitmap1,bitmap.getWidth()+100,bitmap.getHeight()+100,mPaintXfermode);
        mPaintXfermode.setXfermode(null);
        canvas.restoreToCount(layerId2);
        canvas.drawText("PorterDuffXfermode"+"\n"+"-MULTIPLY",bitmap.getWidth()/2+bitmap.getHeight()+100 ,bitmap.getHeight()/2 + bitmap.getHeight() + 100,mPaint);

    }
}
