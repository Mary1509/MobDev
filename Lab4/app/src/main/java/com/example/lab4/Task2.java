package com.example.lab4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Task2 extends AppCompatActivity {
    ImageView original, result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        result = findViewById(R.id.imageView2);

        Bitmap img_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo);
        int width = img_bit.getWidth();
        int heigth = img_bit.getHeight();

        Bitmap res_bit = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);

        int pix, newPix, alpha, red, green, blue;

        final int random = new Random().nextInt(3);

        for (int i = 0; i < width; i++) {
            for ( int j=0; j < heigth; j++){
                pix = img_bit.getPixel(i, j);
                alpha = Color.alpha(pix);
                switch (random) {
                    case 0: {
                        red = 255 - Color.red(pix) + 50;
                        green = Color.green(pix);
                        blue = Color.blue(pix);
                        break;
                    }
                    case 1: {
                        red = Color.red(pix);
                        green = 255 - Color.green(pix) + 50;
                        blue = Color.blue(pix);
                        break;
                    }
                    case 2: {
                        red = Color.red(pix);
                        green = Color.green(pix);
                        blue = 255 - Color.blue(pix) + 50;
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + random);
                }

                newPix = Color.argb(alpha, red, green, blue);
                res_bit.setPixel(i, j, newPix);
            }
        }
        result.setImageBitmap(res_bit);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
