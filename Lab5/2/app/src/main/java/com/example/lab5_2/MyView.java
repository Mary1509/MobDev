package com.example.lab5_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    int x = 0; // Координата по горизонталі лівого верхнього кута прямокутника
    int y = 0; // Координата по вертикалі лівого верхнього кута прямокутника
    int widthRect = 300; // Ширина прямокутника
    int heightRect = 200; // Висота прямокутника
    int strokeWidth = 20; // Товщина лінії прямокутника
    int vx = 10; // Швидкість прямокутника по горизонталі
    int vy = 10; // Швидкість прямокутника по вертикалі

    int blue = 0;
    int green = 0;
    int red = 0;

    public MyView(Context context) {
        super(context);
    }

    void modifyRect() {
        strokeWidth = (int)(Math.random()*100);
        blue = (int)(Math.random()*255);
        green = (int)(Math.random()*255);
        red = (int)(Math.random()*255);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.rgb(red, green, blue));
//        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        x = x + vx;
        y = y + vy;
        if (x > canvas.getWidth() - widthRect) {
            vx = vx * -1;
            modifyRect();
//            strokeWidth+=30;
        }
        if (x < 0) {
            vx = vx * -1;
            modifyRect();
//            strokeWidth+=30;

        }
        if (y > canvas.getHeight() - heightRect) {
            vy = vy * -1;
            modifyRect();
//            strokeWidth+=30;
        }
        if (y < 0) {
            vy = vy * -1;
            modifyRect();
//            strokeWidth+=30;
        }

        canvas.drawRect(x,y,widthRect + x,heightRect+y,paint);
        invalidate();


    }
}
