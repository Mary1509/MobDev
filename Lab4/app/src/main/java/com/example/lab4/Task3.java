package com.example.lab4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Task3 extends AppCompatActivity {
    ImageView original, result_red, result_green, result_blue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        result_red = findViewById(R.id.imageView2);
        result_green = findViewById(R.id.imageView3);
        result_blue = findViewById(R.id.imageView4);

        Bitmap img_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo);
        int width = img_bit.getWidth();
        int heigth = img_bit.getHeight();

        Bitmap res_bit_red = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);
        Bitmap res_bit_green = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);
        Bitmap res_bit_blue = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);

        int pix, newPix_red, newPix_blue, newPix_green, alpha, red, green, blue;

        for (int i = 0; i < width; i++) {
            for ( int j=0; j < heigth; j++){
                pix = img_bit.getPixel(i, j);
                alpha = Color.alpha(pix);
                red = Color.red(pix);
                green = Color.green(pix);
                blue = Color.blue(pix);

                newPix_red = Color.argb(alpha, red, 0, 0);
                newPix_green = Color.argb(alpha, 0, green, 0);
                newPix_blue = Color.argb(alpha, 0, 0, blue);
                res_bit_red.setPixel(i, j, newPix_red);
                res_bit_green.setPixel(i, j, newPix_green);
                res_bit_blue.setPixel(i, j, newPix_blue);
            }
        }
        result_red.setImageBitmap(res_bit_red);
        result_green.setImageBitmap(res_bit_green);
        result_blue.setImageBitmap(res_bit_blue);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
