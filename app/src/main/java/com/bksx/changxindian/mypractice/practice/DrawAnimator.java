package com.bksx.changxindian.mypractice.practice;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bksx.changxindian.mypractice.R;

import static android.os.Build.VERSION.SDK_INT;
import static com.bksx.changxindian.mypractice.utils.Utils.dpToPixel;

public class DrawAnimator extends RelativeLayout {
    ImageView  imageView;
    Button btn_animate;
    int index;
    boolean isAnim = false;

    public DrawAnimator(Context context) {
        super(context);
    }

    public DrawAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawAnimator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        imageView = findViewById(R.id.imageview);
        btn_animate = findViewById(R.id.btn_animate);

        btn_animate.setOnClickListener(new OnClickListener() {
            @SuppressLint("ObjectAnimatorBinding")
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (!isAnim) {
                    if (index == 0) {
                        imageView.animate().translationX(300);
                        imageView.animate().rotationX(180);
                        imageView.animate().rotationY(30);
                        imageView.animate().scaleX(1.5f);
                        imageView.animate().setDuration(600)
                                .setInterpolator(new DecelerateInterpolator());
                    } else if (index == 1) {
                        ObjectAnimator animator = new ObjectAnimator();
                        animator.ofFloat(imageView,"translationY",100).start();
                        animator.ofFloat(imageView,"alpha",0.2f).start();
//                        imageView.animate().translationY(100);
//                        imageView.animate().alpha(0.2f);
                    } else {
                        imageView.animate().translationZ(50);
                    }
                    isAnim = true;
                } else {
                    if (index == 0) {
                        imageView.animate().translationX(0);
                        imageView.animate().rotationX(0);
                        imageView.animate().rotationY(0);
                        imageView.animate().scaleX(1.0f);
                        index++;
                    } else if (index == 1) {

                        imageView.animate().translationY(0)
                                .alpha(1f);
                        index++;
                    } else {
                        imageView.animate().translationZ(0);
                        index = 0;
                    }
                    isAnim = false;
                }
            }
        });
    }

}
