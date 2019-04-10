package com.bksx.changxindian.mypractice.practice;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bksx.changxindian.mypractice.R;

public class DrawEvaluatorLayout extends RelativeLayout {
    DrawEvaluator drawEvaluator;
    Button btnAnimator;
    public DrawEvaluatorLayout(Context context) {
        super(context);
    }

    public DrawEvaluatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        drawEvaluator = findViewById(R.id.evaluator);
        btnAnimator = findViewById(R.id.btn_evaluator_animator);
        btnAnimator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofInt(drawEvaluator,"color",0xffff0000,0xff00ff00);
                //5.0 以上可以直接用这种方式
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ObjectAnimator objectAnimator1 = ObjectAnimator.ofArgb(drawEvaluator,"color",0xffff0000,0xff00ff00);
                    objectAnimator1.setDuration(2500);
                    objectAnimator1.start();
                } else {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                    objectAnimator.setInterpolator(new LinearInterpolator());
                    objectAnimator.setDuration(2500);
                    objectAnimator.start();
                }
            }
        });
    }
}
