package com.bksx.changxindian.mypractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.bksx.changxindian.mypractice.Count;

import java.util.ArrayList;
import java.util.List;

public class DrawHistogramView extends View {
    private String NAME = "直方图";

    private List<Count> counts;
    private Paint paint;
    private float startX;
    private float space;
    private float width;
    private float max;

    public DrawHistogramView(Context context) {
        super(context);
        init();
    }

    public DrawHistogramView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawHistogramView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        counts = new ArrayList<>();
        Count count = new Count("Froyo", 1.0f, Color.GREEN);
        counts.add(count);
        count = new Count("GB", 2.0f, Color.GREEN);
        counts.add(count);
        count = new Count("ICS", 2.0f, Color.GREEN);
        counts.add(count);
        count = new Count("JB", 5.0f, Color.GREEN);
        counts.add(count);
        count = new Count("KitKat", 10.0f, Color.GREEN);
        counts.add(count);
        count = new Count("L", 12.0f, Color.GREEN);
        counts.add(count);
        count = new Count("M", 4.0f, Color.GREEN);
        counts.add(count);
        max = Float.MIN_VALUE;
        for (Count c : counts) {
            max = Math.max(max, c.getTrans());
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(2);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        paint.setColor(Color.BLUE);
        paint.setTextSize(72);
        canvas.drawText(NAME, (canvas.getWidth() - paint.measureText(NAME)) / 2, canvas.getHeight() * 0.9f, paint);

        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.6f); // 将画图原点移动直方图的原点位置
        //直方图的宽度
        width = 100;
        //直方图之间的间距
        space = (canvas.getWidth() * 0.9f - 100) / counts.size() * 0.2f;

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, canvas.getWidth() * 0.8f, 0, paint);   // 画x轴
        canvas.drawLine(0, 0, 0, -canvas.getHeight() * 0.6f, paint); // 画y轴

        startX = 0f;

        paint.setTextSize(36);
        paint.setStyle(Paint.Style.FILL);
        for (Count count : counts) {
            paint.setColor(count.getImage());
            canvas.drawRect(startX + space, -(count.getTrans() / max * canvas.getHeight() * 0.6f), startX + space + width, 0, paint);
            paint.setColor(Color.BLUE);
            canvas.drawText(count.getName(), startX + space + (width - paint.measureText(count.getName())) / 2, 40, paint);
            startX += width + space;
        }
    }
}
