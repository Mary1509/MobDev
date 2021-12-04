package com.example.question1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    int y=0;
    int vy = 30;
    int radius = 500;
    int centerX;
    Paint paint = new Paint();


    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);

        centerX = getWidth()/2;

        y += vy;

        if (y > getHeight() - radius)
            vy *= -1;
        if (y < radius && y < 0)
            vy *= -1;
        canvas.drawCircle(centerX, y, radius, paint);
        invalidate();



    }
}
