package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.changxindian.mypractice.R;

public class DrawGridentView extends View {
    public Paint mPaintLinner = new Paint(Paint.ANTI_ALIAS_FLAG);
    public Paint mPaintRadial = new Paint(Paint.ANTI_ALIAS_FLAG);
    public Paint mPaintSweep = new Paint(Paint.ANTI_ALIAS_FLAG);
    public Paint mPaintBitmap = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawGridentView(Context context) {
        super(context);
    }

    public DrawGridentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawGridentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到
        mPaintLinner.setShader(new LinearGradient(10,10,400,400, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP));
        mPaintRadial.setShader(new RadialGradient(600,200,190, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP));
        mPaintSweep.setShader(new SweepGradient(200,600,Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3")));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mPaintBitmap.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200,200,190,mPaintLinner);
        canvas.save();
        canvas.drawCircle(600,200,190,mPaintRadial);
        canvas.save();
        canvas.drawCircle(200,600,190,mPaintSweep);
        canvas.save();
        canvas.translate(400,400);
        canvas.drawCircle(200,200,200,mPaintBitmap);
        canvas.restore();
        canvas.drawCircle(0,0,20,mPaintBitmap);
    }
}
