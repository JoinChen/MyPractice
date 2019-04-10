package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Toast;

import com.bksx.changxindian.mypractice.R;
import com.bksx.changxindian.mypractice.utils.AppDebug;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ToastUtils;

public class DrawImageView extends AppCompatImageView {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    Context mContext;

    public DrawImageView(Context context) {
        super(context);
    }

    public DrawImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(30);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Drawable drawable = getDrawable();
        if (drawable != null) {
            canvas.save();
//            canvas.concat(getImageMatrix());
            Rect bounds = drawable.getBounds();
            mPaint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("尺寸:" + ConvertUtils.px2dp( bounds.width())+ "X" + ConvertUtils.px2dp( bounds.height()), 0, 30, mPaint);
            canvas.restore();
            mPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("onDraw后插",bounds.width()/2,bounds.height()/2,mPaint);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }
}
