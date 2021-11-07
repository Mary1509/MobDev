package com.example.lab4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Task1 extends AppCompatActivity {

    ImageView original, result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        result = findViewById(R.id.imageView2);

        Bitmap img_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo);
        int width = img_bit.getWidth();
        int heigth = img_bit.getHeight();

        Bitmap res_bit = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);

        int pix, newPix, alpha, red, green, blue;

        for (int i = 0; i < width; i++) {
            for ( int j=0; j < heigth; j++){
                pix = img_bit.getPixel(i, j);
                alpha = Color.alpha(pix);
                red = 255 - Color.red(pix);
                green = 255 - Color.green(pix);
                blue = 255 - Color.blue(pix);

                newPix = Color.argb(alpha, red, green, blue);
                res_bit.setPixel(i, j, newPix);
            }
        }
        result.setImageBitmap(res_bit);

    }
}
