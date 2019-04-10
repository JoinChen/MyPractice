package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.bksx.changxindian.mypractice.R;
import com.bksx.changxindian.mypractice.utils.Utils;

public class DrawCommonAdjust extends RelativeLayout {
    SeekBar seekBarHeight;
    SeekBar seekBarWidth;
    FrameLayout parentFramLayout;
    float bottomMargin = Utils.dpToPixel(48);
    float minWidth = Utils.dpToPixel(80);
    float minHeight = Utils.dpToPixel(100);

    public DrawCommonAdjust(Context context) {
        super(context);
    }

    public DrawCommonAdjust(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCommonAdjust(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        seekBarHeight = findViewById(R.id.heightBar);
        seekBarWidth = findViewById(R.id.widthBar);
        parentFramLayout = findViewById(R.id.parentLayout);
        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ViewGroup.LayoutParams layoutParams = parentFramLayout.getLayoutParams();
                layoutParams.height = (int) (minHeight + (DrawCommonAdjust.this.getHeight()-minHeight)*seekBarHeight.getProgress()/100);
                layoutParams.width = (int) (minWidth + (DrawCommonAdjust.this.getWidth()-minWidth)*seekBarWidth.getProgress()/100);
                parentFramLayout.setLayoutParams(layoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        seekBarHeight.setOnSeekBarChangeListener(listener);
        seekBarWidth.setOnSeekBarChangeListener(listener);
    }
}
