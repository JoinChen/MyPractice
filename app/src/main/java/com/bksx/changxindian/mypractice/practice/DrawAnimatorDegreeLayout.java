package com.bksx.changxindian.mypractice.practice;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bksx.changxindian.mypractice.R;

public class DrawAnimatorDegreeLayout extends RelativeLayout {
    int index = 0;
    DrawAnimatorDegree drawAnimatorDegree;
    Button btnAnimator;
    ObjectAnimator objectAnimator;

    public DrawAnimatorDegreeLayout(Context context) {
        super(context);
    }

    public DrawAnimatorDegreeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawAnimatorDegreeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        drawAnimatorDegree = findViewById(R.id.degreeView);
        btnAnimator = findViewById(R.id.btn_animator);
        btnAnimator.setOnClickListener(new OnClickListener() {
            @SuppressLint("ObjectAnimatorBinding")
            @Override
            public void onClick(View v) {
                if (index == 0){
                    objectAnimator =  ObjectAnimator.ofFloat(drawAnimatorDegree,"progress",0,75,65);
                    index = 1;
                }else {
                    objectAnimator = ObjectAnimator.ofFloat(drawAnimatorDegree,"progress",0,75,65);
                    index = 0;
                }
                objectAnimator.setDuration(2000)
                        .setInterpolator(new LinearInterpolator());
                objectAnimator.start();
            }
        });

    }
}
