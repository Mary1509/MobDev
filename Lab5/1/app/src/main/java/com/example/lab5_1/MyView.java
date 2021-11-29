package com.example.lab5_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(100);
        paint.setAntiAlias(true);
        canvas.drawColor(Color.BLUE);
        canvas.drawText("Hello Kitty", 200, 150, paint);
        Bitmap image = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo2);
        canvas.drawBitmap(image, 40, 200, null);
    }
}
