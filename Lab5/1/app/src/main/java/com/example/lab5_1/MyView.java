package com.example.lab5_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
public class MyView extends View {
    int x = 0; // Координата по горизонталі лівого верхнього кута
    //прямокутника
    int widthRect = 300; // Ширина прямокутника
    int vx = 10; // Скорость по оси Ox

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        // Рухається одна сторона
//        x++;
//        canvas.drawRect(x,200,300,500,paint);
//        invalidate();

        // Рухається без зупинки
//        x = x + 10;
//        canvas.drawRect(x,200,300 + x,500,paint);
//        invalidate();

        // Рухається до однієї сторони екрану

//        int widthRect = 300;
//        x = x + 10;
//        if (x > canvas.getWidth() - widthRect)
//            x = canvas.getWidth() - widthRect;
//        canvas.drawRect(x,200,widthRect + x,500,paint);
//        invalidate();

        // Рухіється між "стінками екрану"
        x = x + vx;
        if (x > canvas.getWidth() - widthRect) vx = vx * -1;
        if (x < 0) vx = vx * -1;
        canvas.drawRect(x,200,widthRect + x,500,paint);
        invalidate();

    }
}
