package com.example.lab5_task1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }
    Paint paint = new Paint();

    int radius = 500;
    int speed = 200;
    boolean flag = false;
    double alpha = 0;
    int a = 300;
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() /2;
        int centerY = getHeight() /2;


        if (speed == 20) flag = true;
        if (speed == 200) flag = false;
        alpha += Math.PI / speed;
        if (alpha > 2 * Math.PI){
            alpha -= 2 * Math.PI;
            if (!flag) speed -= 20;
            else speed += 20;

        }

        int centerRectX = (int)(centerX + radius * Math.cos(alpha));
        int centerRectY = (int)(centerY + radius * Math.sin(alpha));
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawRect(centerRectX - a/2, centerRectY - a/2, centerRectX + a/2, centerRectY+a/2, paint);
        canvas.drawCircle(centerX, centerY, radius, paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30);
        canvas.drawPoint(centerRectX, centerRectY, paint);
        invalidate();
    }

}
