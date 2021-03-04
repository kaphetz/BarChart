package com.developer.arsltech.barchartgraph;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BarChart extends View {
    private Paint paint;
    private int width;
    private int range;
    private List<Integer> mHeightList = new ArrayList<>();

    public void setWidth(int width) {
        this.width = width;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public BarChart(Context context) {
        super(context);
    }

    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public BarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(2);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setDither(true);

        //Draw the coordinates first
        //X axis
        /**
         * Draw X axis
         * The parameters are: start X-axis coordinate, Y-axis coordinate, end X-axis coordinate, Y-axis coordinate, pen
         * X axis: the Y axis coordinate value of the start and end remains unchanged
         */
        canvas.drawLine(0, getHeight() - 40, getWidth(), getHeight() - 40, paint);
        Paint fgPaintSel = new Paint();
        fgPaintSel.setColor(Color.GREEN);
        fgPaintSel.setStyle(Paint.Style.STROKE);
        fgPaintSel.setPathEffect(new DashPathEffect(new float[]{10f, 20f}, 1f));

        canvas.drawLine(0, (getHeight() - 40) / 2, getWidth(), (getHeight() - 40) / 2, fgPaintSel);
        canvas.drawLine(0, 0, getWidth(), 0, fgPaintSel);
        /**
         * The small arrow on the right of the X axis
         * Here you need to find the X and Y coordinate values ​​at the end of the X axis, which is the code above (850, 550)
         * Then draw two diagonal lines with this coordinate as the starting point
         * The X axis is completed here
         *//*
        canvas.drawLine(850, 550, 840, 540, paint);
        canvas.drawLine(850, 550, 840, 560, paint);
*/
        /**
         * In the same way, draw the Y axis
         * Y-axis and X-axis coordinate values ​​remain unchanged
         */
        /*canvas.drawLine(0, getHeight(), 0, 0, paint);
        canvas.drawLine(50, 50, 40, 60, paint);
        canvas.drawLine(50, 50, 60, 60, paint);*/

        /**
         * Draw a cylinder
         * It's actually a rectangle
         * Width = right-left
         * Height = bottom-top
         * The width is fixed at 50
         */
        paint.setColor(getResources().getColor(R.color.barchart));
        paint.setTextSize(30);
        Paint textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(20);
        if (mHeightList.size() != 0) {
            for (int i = 0; i < mHeightList.size(); i++) {
                @SuppressLint("DrawAllocation") RectF rectF =
                        new RectF((width + range) * i, getHeight() - 40 - lengthPerBar(mHeightList.get(i)),
                                width + (width + range) * i, getHeight() - 40);
                canvas.drawRect(rectF, paint);

                canvas.drawText("" + i, (width + range) * i, getHeight(), textPaint);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setmHeightList(List<Integer> heightList) {
        mHeightList = heightList;
        postInvalidate();
    }

    private int getMaxValue() {
        return Collections.max(mHeightList);
    }

    private int lengthPerBar(int value) {
        int unit = getMaxValue() / getHeight();
        return unit * value;
    }
}
