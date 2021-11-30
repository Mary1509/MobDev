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

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() /2;
        int centerY = getHeight() /2;
        int radius = 500;

        int x = centerX + radius;

        double alpha = Math.PI / 3;
        double k = Math.tan(alpha);

        int y = (int)(k*x);

        int a = 100;




        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawPoint(x, y, paint);
        canvas.drawRect(centerX+radius-a, centerY-radius+a, centerX+radius+a, centerY-radius-a, paint);
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

}
