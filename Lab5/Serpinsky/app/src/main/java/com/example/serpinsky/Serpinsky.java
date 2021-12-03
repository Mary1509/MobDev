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

    int k = 3;

    private void serp (int x, int y, int a, Canvas canvas, Paint paint){
        canvas.drawRect(x-a/2, y-a/2, x+a/2, y+a/2, paint);
    }



    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(20);
        canvas.drawRect(0, 0, getWidth(), getWidth(), paint);

        paint.setColor(Color.WHITE);
        int x0=0; int y0=0;
        int width = getWidth();
        int centerX = x0 + width/2;
        int centerY = y0 + width/2;
        int a = width/3;
        canvas.drawRect(centerX-a/2, centerY-a/2, centerX+a/2, centerY+a/2, paint);
        for (int i=0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int centerX1 = 2*centerX/6+i*a;
                int centerY1 = 2*centerY/6+j*a;
                while (k >= 0){
                    a=a/3;
                    for (int m = 1; m<6; m+=2){
                        for (int n=1; n<6; n+=2){
                            if (m==3 && n == 3) continue;
                            serp(m*centerX1, n*centerY1, a, canvas, paint);
                        }
                    }
                    centerX1 = 2*centerX1/6;
                    centerY1 = 2*centerY1/6;
                    k--;
                }

        }

        }





    }
}
