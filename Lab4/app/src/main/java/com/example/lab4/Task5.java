package com.example.lab4;

import static java.lang.Math.max;
import static java.lang.Math.min;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;



public class Task5 extends AppCompatActivity {
    ImageView result;
    Bitmap img_bit, result_bit;
    int width, height;

    final int SIZE = 3;

    RadioGroup radioGroup;

    void Convolution(int[][] filter, int div, int offset){
        int A, R, G, B;
        int sumR, sumG, sumB;
        int[][] pixels = new int[SIZE][SIZE];
        for (int y = 0; y < height - 2; y++)
        {
            for (int x = 0; x < width - 2; x++)
            {
                pixels[0][0] = img_bit.getPixel(x, y);
                pixels[0][1] = img_bit.getPixel(x, y + 1);
                pixels[0][2] = img_bit.getPixel(x, y + 2);
                pixels[1][0] = img_bit.getPixel(x + 1, y);
                pixels[1][1] = img_bit.getPixel(x + 1, y + 1);
                pixels[1][2] = img_bit.getPixel(x + 1, y + 2);
                pixels[2][0] = img_bit.getPixel(x + 2, y);
                pixels[2][1] = img_bit.getPixel(x + 2, y + 1);
                pixels[2][2] = img_bit.getPixel(x + 2, y + 2);

                A = Color.alpha(img_bit.getPixel(1, 1));

                R = ((((Color.red(pixels[0][0])* filter[0][0]) +
                    (Color.red(pixels[1][0]) * filter[1][0]) +
                    (Color.red(pixels[2][0]) * filter[2][0]) +
                    (Color.red(pixels[0][1] )* filter[0][1]) +
                    (Color.red(pixels[1][1] )* filter[1][1]) +
                    (Color.red(pixels[2][1] )*filter[2][1]) +
                    (Color.red(pixels[0][2] )* filter[0][2]) +
                    (Color.red(pixels[1][2] )* filter[1][2]) +
                    (Color.red(pixels[2][2])* filter[2][2]))
                                / div) + offset);

                if (R < 0)
                {
                    R = 0;
                }
                else if (R > 255)
                {
                    R = 255;
                }

                G = ((((Color.green(pixels[0][0])* filter[0][0]) +
                        (Color.green(pixels[1][0]) * filter[1][0]) +
                        (Color.green(pixels[2][0]) * filter[2][0]) +
                        (Color.green(pixels[0][1] )* filter[0][1]) +
                        (Color.green(pixels[1][1] )* filter[1][1]) +
                        (Color.green(pixels[2][1] )*filter[2][1]) +
                        (Color.green(pixels[0][2] )* filter[0][2]) +
                        (Color.green(pixels[1][2] )* filter[1][2]) +
                        (Color.green(pixels[2][2])* filter[2][2]))
                        / div) + offset);

                if (G < 0)
                {
                    G = 0;
                }
                else if (G > 255)
                {
                    G = 255;
                }

                B = ((((Color.blue(pixels[0][0])* filter[0][0]) +
                        (Color.blue(pixels[1][0]) * filter[1][0]) +
                        (Color.blue(pixels[2][0]) * filter[2][0]) +
                        (Color.blue(pixels[0][1] )* filter[0][1]) +
                        (Color.blue(pixels[1][1] )* filter[1][1]) +
                        (Color.blue(pixels[2][1] )*filter[2][1]) +
                        (Color.blue(pixels[0][2] )* filter[0][2]) +
                        (Color.blue(pixels[1][2] )* filter[1][2]) +
                        (Color.blue(pixels[2][2])* filter[2][2]))
                        / div) + offset);

                if (B < 0)
                {
                    B = 0;
                }
                else if (B > 255)
                {
                    B = 255;
                }
                result_bit.setPixel(x + 1, y + 1, Color.argb(A, R, G, B));
            }
        }
    }

    void blurFilter(){
        int A, R, G, B;
        int[][] pixels = new int[SIZE][SIZE];

        int[][] filter = new int[][] {
                { 1, 2, 1 },
                { 2, 4, 2 },
                { 1, 2, 1 }
        };

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

//        Convolution(filter, div, offset);
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

        int div = 1;
        int offset = 0;

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
//        Convolution(filter, div, offset);
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

                R = (red_pixels[(red_pixels.length) / 2] + red_pixels[(red_pixels.length+1) / 2])/2;
                G = (green_pixels[(green_pixels.length) / 2] + green_pixels[(green_pixels.length+1) / 2])/2;
                B = (blue_pixels[(blue_pixels.length) / 2] + blue_pixels[(blue_pixels.length+1) / 2])/2;


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
                R.drawable.photo3);
        width = img_bit.getWidth();
        height = img_bit.getHeight();
        result_bit = Bitmap.createBitmap(width, height, img_bit.getConfig());

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
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
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
