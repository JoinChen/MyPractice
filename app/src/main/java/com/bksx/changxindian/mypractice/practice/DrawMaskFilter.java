package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.changxindian.mypractice.R;

public class DrawMaskFilter extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mPaintT = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;

    public DrawMaskFilter(Context context) {
        super(context);
    }

    public DrawMaskFilter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawMaskFilter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fuck);
        mPaintT.setTextAlign(Paint.Align.CENTER);
        mPaintT.setTextSize(30);
        mPaintT.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        MaskFilter maskFilter = new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER);
        mPaint.setMaskFilter(maskFilter);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.drawText("BlurMaskFilter"+"\n"+"INNER",bitmap.getWidth()/2,bitmap.getHeight()/2,mPaintT);

        MaskFilter maskFilter1 = new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);
        mPaint.setMaskFilter(maskFilter1);
        canvas.drawBitmap(bitmap,bitmap.getWidth()+30,0,mPaint);
        canvas.drawText("NORMAL",bitmap.getWidth()/2+bitmap.getWidth(),bitmap.getHeight()/2,mPaintT);

        MaskFilter maskFilter2 = new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID);
        mPaint.setMaskFilter(maskFilter2);
        canvas.drawBitmap(bitmap,bitmap.getWidth()*2+30,0,mPaint);
        canvas.drawText("SOLID",bitmap.getWidth()/2+bitmap.getWidth()*2,bitmap.getHeight()/2,mPaintT);

        MaskFilter maskFilter3 = new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER);
        mPaint.setMaskFilter(maskFilter3);
        canvas.drawBitmap(bitmap,0,bitmap.getHeight(),mPaint);
        canvas.drawText("OUTER",bitmap.getWidth()/2,bitmap.getHeight()/2+bitmap.getHeight(),mPaintT);

        //direction 是一个 3 个元素的数组，指定了光源的方向； ambient 是环境光的强度，数值范围是 0 到 1； specular 是炫光的系数； blurRadius 是应用光线的范围
        MaskFilter maskFilter4 = new EmbossMaskFilter(new float[]{0,3,3},0.2f,8,10);
        mPaint.setMaskFilter(maskFilter4);
        canvas.drawBitmap(bitmap,bitmap.getWidth(),bitmap.getHeight(),mPaint);
        canvas.drawText("EmbossMaskFilter",bitmap.getWidth()/2+bitmap.getWidth(),bitmap.getHeight()/2+bitmap.getHeight(),mPaintT);

    }
}
