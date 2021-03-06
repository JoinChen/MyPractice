package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class DrawMyImageView extends AppCompatImageView {


    public DrawMyImageView(Context context) {
        super(context);
    }

    public DrawMyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawMyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight > measuredWidth){
            measuredHeight = measuredWidth;
        }else {
            measuredWidth = measuredHeight;
        }

        setMeasuredDimension(measuredWidth,measuredHeight);
    }


}
