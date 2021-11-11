package com.example.lab4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Task4 extends AppCompatActivity {
    ImageView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        result = findViewById(R.id.imageView3);

        Bitmap img1_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo);
        int width1 = img1_bit.getWidth();
        int height1 = img1_bit.getHeight();

        Bitmap img2_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo1);

        Bitmap res_bit = Bitmap.createBitmap(width1, height1, Bitmap.Config.ARGB_8888);

        int pix1, pix2, newPix, alpha, red, green, blue;
        double a = 0.5;
        for (int i = 0; i < width1; i++) {
            for ( int j=0; j < height1; j++){
                pix1 = img1_bit.getPixel(i, j);
                pix2 = img2_bit.getPixel(i, j);
                alpha = (int)(a* Color.alpha(pix1) + (1-a)* Color.alpha(pix2));
                red = (int)(a* Color.red(pix1) + (1-a)* Color.red(pix2));
                green =(int)(a* Color.green(pix1) + (1-a)* Color.green(pix2));
                blue = (int)(a* Color.blue(pix1) + (1-a)* Color.blue(pix2));

                newPix = Color.argb(alpha, red, green, blue);
                res_bit.setPixel(i, j, newPix);
            }
        }
        result.setImageBitmap(res_bit);
        System.out.println("Photo finised");

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
