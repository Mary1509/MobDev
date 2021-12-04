package com.example.serpinsky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Serpinsky extends View {
    public Serpinsky(Context context) {
        super(context);
    }

    int k = 5;

    private void SerpinskiyDraw(int xi, int yi, int width, int height, int currentDeep, Canvas canvas, Paint paint) {
        int newWidth = width / 3;
        int newHeight = height / 3;
        int x = (width / 3) + xi;
        int y = (height / 3) + yi;
        canvas.drawRect(x, y, x+newWidth, y+newHeight, paint);

        int sX = 0;
        int sY = 0;
        if (currentDeep > 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sX = i * (width / 3) + xi;
                    sY = j * (height / 3) + yi;

                    SerpinskiyDraw(sX, sY, newWidth, newHeight, currentDeep - 1, canvas, paint);
                }
            }
        }
    }



    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(20);
        canvas.drawRect(0, 0, getWidth(), getWidth(), paint);

        paint.setColor(Color.WHITE);

        SerpinskiyDraw(0, 0, getWidth(), getWidth(), k, canvas, paint);






    }
}
