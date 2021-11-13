package com.example.lab4;

import static java.lang.Math.max;
import static java.lang.Math.min;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Task5 extends AppCompatActivity {
    ImageView original, result;
    int filterHeight, filterWidth;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);

        result = findViewById(R.id.imageView2);

        Bitmap img_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo2);
        int width = img_bit.getWidth();
        int height = img_bit.getHeight();

        Bitmap result_bit = Bitmap.createBitmap(width, height, img_bit.getConfig());

        final int SIZE = 5;

        int pix, newPix, alpha, red, green, blue;
        filterHeight = SIZE;
        filterWidth = SIZE;


//        double filter[filterHeight][filterWidth] =
//        {
//            1,  4,  6,  4,  1,
//                    4, 16, 24, 16,  4,
//                    6, 24, 36, 24,  6,
//                    4, 16, 24, 16,  4,
//                    1,  4,  6,  4,  1,
//        };

        double[][] filter = new double[][] {
                { 1,  4,  6,  4,  1 },
                { 4, 16, 24, 16,  4},
                {6, 24, 36, 24,  6},
                {4, 16, 24, 16,  4},
                {1,  4,  6,  4,  1}
        };



//        {
//            1, 2, 1,
//                    2, 4, 2,
//                    1, 2, 1,
//        };
        //Гауссово размытние (не факт...)
//        double[][] filter = new double[][] {
//                { 1, 2, 1 },
//                { 2, 4, 2 },
//                { 1, 2, 1 }
//        };

        //Повышение резкости
//        double[][] filter = new double[][] {
//                { -1, -1, -1 },
//                { -1, 9, -1 },
//                { -1, -1, -1 }
//        };
//
//        double filter[filterHeight][filterWidth] =
//        {
//            0.077847, 0.123317, 0.077847,
//                    0.123317, 0.195346, 0.123317,
//                    0.077847, 0.123317, 0.077847,
//        };

//        double[][] filter = new double[][] {
//                { 0.077847, 0.123317, 0.077847 },
//                { 0.123317, 0.195346, 0.123317 },
//                { 0.077847, 0.123317, 0.077847 }
//        };
        double factor = 1.0 / 256.0;
//        double factor = 1.0;
        double offset = 0.0;

        int A, R, G, B;
        int sumR, sumG, sumB;
        int[][] pixels = new int[SIZE][SIZE];

        for(int y = 0; y < height - 4; ++y) {
            for(int x = 0; x < width - 4; ++x) {

                for(int i = 0; i < SIZE; ++i) {
                    for(int j = 0; j < SIZE; ++j) {
                        pixels[i][j] = img_bit.getPixel(x + i, y + j);
                    }
                }

                A = Color.alpha(pixels[1][1]);

                sumR = sumG = sumB = 0;

                for(int i = 0; i < SIZE; ++i) {
                    for(int j = 0; j < SIZE; ++j) {
                        sumR += (Color.red(pixels[i][j]) * filter[i][j]);
                        sumG += (Color.green(pixels[i][j]) * filter[i][j]);
                        sumB += (Color.blue(pixels[i][j]) * filter[i][j]);
                    }
                }

                R = min(max((int)(factor * sumR + offset), 0), 255);
                G = min(max((int)(factor * sumG + offset), 0), 255);
                B = min(max((int)(factor * sumB + offset), 0), 255);

                // apply new pixel
                result_bit.setPixel(x + 1, y + 1, Color.argb(A, R, G, B));

            }

        }
        result.setImageBitmap(result_bit);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
