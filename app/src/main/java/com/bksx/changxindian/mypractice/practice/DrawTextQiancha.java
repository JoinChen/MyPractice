package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;

public class DrawTextQiancha extends AppCompatTextView {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF rectF = new RectF();
    public DrawTextQiancha(Context context) {
        super(context);
    }

    public DrawTextQiancha(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawTextQiancha(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Layout layout = getLayout();
        if (layout!=null){
            mPaint.setColor(Color.YELLOW);
            canvas.save();
            rectF.left = layout.getLineLeft(0);
            rectF.top = layout.getLineTop(0);
            rectF.right = layout.getLineRight(0);
            rectF.bottom = layout.getLineBottom(0);
            canvas.drawRect(rectF,mPaint);
            rectF.left = layout.getLineLeft(layout.getLineCount()-2);
            rectF.top = layout.getLineTop(layout.getLineCount()-2);
            rectF.right = layout.getLineRight(layout.getLineCount()-2);
            rectF.bottom = layout.getLineBottom(layout.getLineCount()-2);
            canvas.drawRect(rectF,mPaint);
            canvas.restore();
        }
        super.onDraw(canvas);
    }
}
