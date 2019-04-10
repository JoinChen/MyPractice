package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.blankj.utilcode.util.ConvertUtils;

public class DrawQianChaImageView extends AppCompatImageView {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Rect bounds;

    public DrawQianChaImageView(Context context) {
        super(context);
    }

    public DrawQianChaImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawQianChaImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable!=null){
            canvas.save();
            bounds = drawable.getBounds();
            mPaint.setColor(Color.BLACK);
            mPaint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("尺寸:" + ConvertUtils.px2dp( bounds.width())+ "X" + ConvertUtils.px2dp( bounds.height()), 0, 30, mPaint);
            canvas.restore();
        }
        super.onDraw(canvas);
        if (drawable != null){
            mPaint.setColor(Color.YELLOW);
            mPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("onDraw前插->后面也是",bounds.width()/2,bounds.height()/2,mPaint);
        }
    }
}
