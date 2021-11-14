package com.example.lab4;

import static java.lang.Math.max;
import static java.lang.Math.min;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class Task5 extends AppCompatActivity {
    ImageView result;
    Bitmap img_bit, result_bit;
    int width, height;

    final int SIZE = 3;

    int pix, newPix, alpha, red, green, blue;

    RadioButton blur, sharp, median, eroz, build, sobel;

    void blurFilter(){
        int A, R, G, B;
//        int sumR, sumG, sumB;
        int[][] pixels = new int[SIZE][SIZE];

        int[][] filter = new int[][] {
                { 1, 2, 1 },
                { 2, 4, 2 },
                { 1, 2, 1 }
        };
//        double[][] filter = new double[][] {
//                { 1, 1, 1 },
//                { 1, 1, 1 },
//                { 1, 1, 1 }
//        };

//                double[][] filter = new double[][] {
//                { 0.077847, 0.123317, 0.077847 },
//                { 0.123317, 0.195346, 0.123317 },
//                { 0.077847, 0.123317, 0.077847 }
//        };

//        double[][] filter = new double[][] {
//                { -1, -1, -1 },
//                { -1, 9, -1 },
//                { -1, -1, -1 }
//        };

        int div = 16;
        int offset = 0;


            for (int y = 0; y < height-2; y ++){
                for(int x = 0; x < width-2; x ++){
                    for (int i = 0; i < SIZE; i ++){
                        for (int j = 0; j < SIZE; j++) {
                            pixels[i][j] = img_bit.getPixel(x + i, y + j);
                        }
                    }
                    A = Color.alpha(img_bit.getPixel(x+1, y+1));

                    int sumR=0, sumG=0, sumB=0;
                    for (int i = 0; i < SIZE; i ++){
                        for (int j = 0; j < SIZE; j++){
                            sumR += (Color.red(pixels[i][j])*filter[i][j]);
                            sumG += (Color.green(pixels[i][j])*filter[i][j]);
                            sumB += (Color.blue(pixels[i][j])*filter[i][j]);
                        }
                    }

                    R = min(max((sumR / div + offset), 0), 255);
                    G = min(max((sumG / div + offset), 0), 255);
                    B = min(max((sumB / div + offset), 0), 255);
                    result_bit.setPixel(x+1, y+1, Color.argb(A, R, G, B));
                }

        }
        result.setImageBitmap(result_bit);
    }

    void sharpFilter(){
        int A, R, G, B;
        int sumR, sumG, sumB;
        int[][] pixels = new int[SIZE][SIZE];

        int[][] filter = new int[][] {
                { -1, -1, -1 },
                { -1, 9, -1 },
                { -1, -1, -1 }
        };
//        double[][] filter = new double[][] {
//                { 0, -1, 0 },
//                { -1, 5, -1 },
//                { 0, -1, 0 }
//        };

        int div = 1;

        for(int y = 0; y < height - 2; y++) {
            for(int x = 0; x < width - 2; x++) {

                for(int i = 0; i < SIZE; i++) {
                    for(int j = 0; j < SIZE; j++) {
                        pixels[i][j] = img_bit.getPixel(x + i, y + j);
                    }
                }

                A = Color.alpha(img_bit.getPixel(x+1, y+1));

                sumR = sumG = sumB = 0;

                for(int i = 0; i < SIZE; i++) {
                    for(int j = 0; j < SIZE; j++) {
                        sumR += (Color.red(pixels[i][j]) * filter[i][j]);
                        sumG += (Color.green(pixels[i][j]) * filter[i][j]);
                        sumB += (Color.blue(pixels[i][j]) * filter[i][j]);
                    }
                }

                R = min(max((sumR / div), 0), 255);
                G = min(max((sumG / div), 0), 255);
                B = min(max((sumB / div), 0), 255);

                // apply new pixel
                result_bit.setPixel(x + 1, y + 1, Color.argb(A, R, G, B));

            }

        }
        result.setImageBitmap(result_bit);
    }

    void medianFilter(){
        int A, R, G, B;
        int sumR, sumG, sumB;
        int[] red_pixels = new int[SIZE*SIZE];
        int[] green_pixels = new int[SIZE*SIZE];
        int[] blue_pixels = new int[SIZE*SIZE];

        for(int y = 1; y < height - 2; y++) {
            for(int x = 1; x < width - 2; x++) {
                int num = 0;
                for(int i = y - 1; i <= y + 1; i++) {
                    for(int j = x - 1; j <= x + 1; j++) {
                        int pix = img_bit.getPixel(j, i);
                        red_pixels[num] = Color.red(pix);
                        green_pixels[num] = Color.green(pix);
                        blue_pixels[num] = Color.blue(pix);
                        num++;
                    }
                }
                Arrays.sort(red_pixels);
                Arrays.sort(green_pixels);
                Arrays.sort(blue_pixels);

                R = red_pixels[(red_pixels.length+1) / 2];
                G = green_pixels[(green_pixels.length+1) / 2];
                B = blue_pixels[(blue_pixels.length+1) / 2];


                // apply new pixel
                result_bit.setPixel(x , y, Color.argb(255, R, G, B));

            }

        }
        result.setImageBitmap(result_bit);
    }

    void erozFilter(){

    }
    void buildFilter(){

    }

    void sobelFilter(){

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);

        result = findViewById(R.id.imageView2);
        img_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.p1);
        width = img_bit.getWidth();
        height = img_bit.getHeight();
        result_bit = Bitmap.createBitmap(width, height, img_bit.getConfig());

        blur = findViewById(R.id.radioButton6);
        sharp = findViewById(R.id.radioButton7);
        median = findViewById(R.id.radioButton8);
        eroz = findViewById(R.id.radioButton9);
        build = findViewById(R.id.radioButton10);
        sobel = findViewById(R.id.radioButton11);


        View.OnClickListener radioOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton)v;
                switch (rb.getId()){
                    case R.id.radioButton6: blurFilter();
                        break;
                    case R.id.radioButton7: sharpFilter();
                        break;
                    case R.id.radioButton8: medianFilter();
                        break;
                    case R.id.radioButton9: erozFilter();
                        break;
                    case R.id.radioButton10: buildFilter();
                        break;
                    case R.id.radioButton11: sobelFilter();
                        break;
                }
            }
        };

        blur.setOnClickListener(radioOnClickListener);
        sharp.setOnClickListener(radioOnClickListener);
        median.setOnClickListener(radioOnClickListener);
        eroz.setOnClickListener(radioOnClickListener);
        build.setOnClickListener(radioOnClickListener);
        sobel.setOnClickListener(radioOnClickListener);

//        double[][] filter = new double[][] {
//                { 1,  4,  6,  4,  1 },
//                { 4, 16, 24, 16,  4},
//                {6, 24, 36, 24,  6},
//                {4, 16, 24, 16,  4},
//                {1,  4,  6,  4,  1}
//        };








    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
