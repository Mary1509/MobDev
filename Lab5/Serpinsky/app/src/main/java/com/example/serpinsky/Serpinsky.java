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

    int k = 10;

    private void serp (int x, int y, int a, Canvas canvas, Paint paint){
        canvas.drawRect(x-a/2, y-a/2, x+a/2, y+a/2, paint);
    }

    private int printSquares(int xi, int yi, int width, int height, int currentDeep, Canvas canvas, Paint paint) {
        //Quadrado central
        int newWidth = width / 3;
        int newHeight = height / 3;
        int x = (width / 3) + xi;
        int y = (height / 3) + yi;
        canvas.drawRect(x, y, x+newWidth, y+newHeight, paint);

        int sX = 0;
        int sY = 0;
        if (currentDeep > 1) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    //This is the position of each of the small rectangles
                    sX = i * (width / 3) + xi;
                    sY = j * (height / 3) + yi;

                    // Call the method recursively in order to draw the smaller rectangles
                    sum += printSquares(sX, sY, newWidth, newHeight, currentDeep - 1, canvas, paint);
                }
            }
            return 1 + sum;
        } else
            return 1;
    }



    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(20);
        canvas.drawRect(0, 0, getWidth(), getWidth(), paint);

        paint.setColor(Color.WHITE);
//        int x0=0; int y0=0;
//        int width = getWidth();
//        int centerX = x0 + width/2;
//        int centerY = y0 + width/2;
//        int a = width/3;
//        canvas.drawRect(centerX-a/2, centerY-a/2, centerX+a/2, centerY+a/2, paint);
//        for (int i=0; i < 3; i++){
//            for (int j = 0; j < 3; j++){
//                int centerX1 = 2*centerX/6+i*a;
//                int centerY1 = 2*centerY/6+j*a;
//                while (k > 0){
//                    a=a/3;
//                    for (int m = 1; m<6; m+=2){
//                        for (int n=1; n<6; n+=2){
//                            if (m==3 && n == 3) continue;
//                            serp(m*centerX1, n*centerY1, a, canvas, paint);
//                        }
//                    }
//                    centerX1 = 2*centerX1/6;
//                    centerY1 = 2*centerY1/6;
//                    k--;
//                }
//            k=10;
//                a=width/3;
//        }

//        }
        int  n = printSquares(0, 0, getWidth(), getWidth(), 5, canvas, paint);






    }
}
