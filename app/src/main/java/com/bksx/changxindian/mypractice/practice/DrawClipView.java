package com.bksx.changxindian.mypractice.practice;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.changxindian.mypractice.R;

public class DrawClipView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    Path path = new Path();
    int degree;
    @SuppressLint("ObjectAnimatorBinding")
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 180);


    public DrawClipView(Context context) {
        super(context);
    }

    public DrawClipView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawClipView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(30);

        animator.setDuration(5000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipRect(50,50,bitmap.getWidth(),bitmap.getHeight()-50);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.restore();
        canvas.drawText("clipRect",bitmap.getWidth()/2,bitmap.getHeight()/2,mPaint);

        canvas.save();
        path.addCircle(bitmap.getWidth()/2+bitmap.getWidth(),bitmap.getHeight()/2,bitmap.getWidth()/2, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,bitmap.getWidth(),0,mPaint);
        canvas.restore();
        canvas.drawText("clipPath",bitmap.getWidth()/2+bitmap.getWidth(),bitmap.getHeight()/2,mPaint);

        /**
         * @params sx 将画布在x方向上倾斜相应的角度，sx倾斜角度的tan值，其实就是将y逆时针旋转相应的角度
         * @params sy 将画布在y方向上倾斜相应的角度，sx倾斜角度的tan值，其实就是将x顺时针旋转相应的角度
         *
         * 水平错切
         */
        canvas.save();
        canvas.skew((float) Math.sqrt(0.5), 0);
        canvas.drawBitmap(bitmap,bitmap.getWidth()*2,0,mPaint);
        canvas.drawText("skew:sx=0.5(tan30°)",bitmap.getWidth()/2+bitmap.getWidth()*2,bitmap.getHeight()/2,mPaint);
        canvas.restore();

        //matrix
        Matrix matrix = new Matrix();
        float pointsSrc[] = {0, bitmap.getHeight(), bitmap.getWidth(), bitmap.getHeight(), 0, bitmap.getHeight()*2, bitmap.getWidth(), bitmap.getHeight()*2};
        float pointsDst[] = {0 - 10, bitmap.getHeight() + 50, bitmap.getWidth() + 120, bitmap.getHeight() - 90, 0 + 20,
                bitmap.getHeight()*2 + 30, bitmap.getWidth() + 20, bitmap.getHeight()*2 + 60};
        matrix.reset();
        matrix.setPolyToPoly(pointsSrc,0,pointsDst,0,4);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,0,bitmap.getHeight(),mPaint);
        canvas.drawText("matrix:自定义变换",bitmap.getWidth()/2,bitmap.getHeight()/2+bitmap.getHeight(),mPaint);
        canvas.restore();

        //camera三维变换 坐标系:右:x正向 上:y正向 手机屏幕里:z正向  左手坐标系 投影是在z轴的负向
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        //canvas中心点
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;
        canvas.save();
        Camera camera = new Camera();
        camera.save();
        camera.rotateX(30);
        canvas.translate(centerX,centerY);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX,-centerY);
        canvas.drawBitmap(bitmap,x+bitmapWidth,y,mPaint);
        canvas.restore();
        canvas.drawText("camera三维变换",bitmapWidth*5/2,bitmapHeight*3/2,mPaint);

        //翻页效果
        canvas.save();
        camera.save();
        camera.rotateX(degree);
        canvas.translate(centerX, centerY);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        camera.restore();

        canvas.drawBitmap(bitmap, x, y, mPaint);
        canvas.restore();
    }
}
