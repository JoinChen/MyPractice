package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class DrawLinerLayoutForeground extends LinearLayout {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public DrawLinerLayoutForeground(Context context) {
        super(context);
    }

    public DrawLinerLayoutForeground(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawLinerLayoutForeground(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setWillNotDraw(false);

    }
    /*
    * 前插-子view和前景之间
    * 后插-覆盖前景
    * */
    @Override
    public void onDrawForeground(Canvas canvas) {
        mPaint.setColor(Color.RED);
        canvas.drawRect(0,50,200,100,mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(30);
        canvas.drawText("NEW",0+10,50+10,mPaint);
        super.onDrawForeground(canvas);

    }
}
