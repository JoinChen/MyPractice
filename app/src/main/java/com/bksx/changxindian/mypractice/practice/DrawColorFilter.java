package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import com.bksx.changxindian.mypractice.R;

public class DrawColorFilter extends View {
    Paint mPaintLignt = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mPaintPorterDuff = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mPaintLigntMatrix = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    ColorFilter colorFilter1 = new LightingColorFilter(0x00ffff, 0x000000);
    ColorFilter colorFilter2 = new LightingColorFilter(0xffffff, 0x003000);
    ColorMatrix colorMatrix = new ColorMatrix();

    public DrawColorFilter(Context context) {
        super(context);
    }

    public DrawColorFilter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawColorFilter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        mPaintLignt.setColorFilter(colorFilter1);
        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(bitmap, 0, 0, mPaintLignt);
        canvas.drawText("LigntColorFilter",bitmap.getWidth()/2,bitmap.getHeight()/2,mPaint);

        // 第二个 LightingColorFilter：增强绿色部分
        mPaintLignt.setColorFilter(colorFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 20, 0, mPaintLignt);
        canvas.drawText("LigntColorFilter+强化绿色",bitmap.getWidth()/2+bitmap.getWidth() + 20,bitmap.getHeight()/2,mPaint);

        //使用Matrix(矩阵)设置颜色
        colorMatrix.setSaturation(0);//饱和度
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        mPaintLigntMatrix.setColorFilter(colorFilter);
        mPaint.setColor(Color.RED);
        canvas.drawBitmap(bitmap, 0, bitmap.getHeight()+20, mPaintLigntMatrix);
        canvas.drawText("ColorMatrixColorFilter+矩阵",bitmap.getWidth()/2 ,
                bitmap.getHeight()/2 + bitmap.getHeight() + 20,mPaint);

    }
}
