package com.example.lab4;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.pow;

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
    ImageView origin, result;
    Bitmap img_bit, result_bit;
    int width, height;

    RadioGroup radioGroup;

    private Bitmap Convolution(double[][] filter, float div, int SIZE){
        Bitmap result_bitm = Bitmap.createBitmap(width, height, img_bit.getConfig());
        int A, R, G, B;
        int[][] pixels = new int[SIZE][SIZE];

        for (int y = 0; y < height- SIZE + 1; y ++){
            for(int x = 0; x < width- SIZE + 1; x ++){
                for (int i = 0; i < SIZE; i ++){
                    for (int j = 0; j < SIZE; j++) {
                        pixels[i][j] = img_bit.getPixel(x + i, y + j);
                    }
                }
                A = Color.alpha(img_bit.getPixel(x+SIZE-2, y+SIZE-2));

                float sumR=0, sumG=0, sumB=0;
                for (int i = 0; i < SIZE; i ++){
                    for (int j = 0; j < SIZE; j++){
                        sumR += (Color.red(pixels[i][j])*filter[i][j]);
                        sumG += (Color.green(pixels[i][j])*filter[i][j]);
                        sumB += (Color.blue(pixels[i][j])*filter[i][j]);
                    }
                }

                R = (int)min(max((sumR / div), 0), 255);
                G = (int)min(max((sumG / div), 0), 255);
                B = (int)min(max((sumB / div), 0), 255);

                result_bitm.setPixel(x+SIZE-2, y+SIZE-2, Color.argb(A, R, G, B));
            }

        }
        return result_bitm;
    }

    private void blurFilter(){
        double[][] filter = new double[][] {
                { 0.000789, 0.006581, 0.013347, 0.006581, 0.000789 },
                { 0.006581, 0.054901, 0.111345, 0.054901, 0.006581 },
                { 0.013347, 0.111345, 0.225821, 0.111345, 0.013347 },
                { 0.006581, 0.054901, 0.111345, 0.054901, 0.006581 },
                { 0.000789, 0.006581, 0.013347, 0.006581, 0.000789 }
        };

        float div = 1;

        result_bit = Convolution(filter, div, 5);
        result.setImageBitmap(result_bit);
    }

    private void sharpFilter(){
        double[][] filter = new double[][] {
                { -1, -1, -1 },
                { -1, 9, -1 },
                { -1, -1, -1 }
        };

        float div = 1;

        result_bit = Convolution(filter, div, 3);
        result.setImageBitmap(result_bit);
    }

    private void medianFilter(){
        int A, R, G, B;
        int SIZE = 3;
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

    private void erozFilter(){
        int [][] region = new int[3][3];
        for(int y = 0; y < height - 3 + 1; y ++){
            for (int x=0; x < width - 3 + 1; x ++){
                int[] red_pixels = new int[3*3];
                int[] green_pixels = new int[3*3];
                int[] blue_pixels = new int[3*3];
                int num = 0;
                for (int i = 0; i < 3; i ++){
                    for (int j = 0; j < 3; j++) {
                        region[i][j] = img_bit.getPixel(x + i, y + j);
                        red_pixels[num] = Color.red(region[i][j]);
                        green_pixels[num] = Color.green(region[i][j]);
                        blue_pixels[num] = Color.blue(region[i][j]);
                        num++;
                    }
                }
                Arrays.sort(red_pixels);
                Arrays.sort(green_pixels);
                Arrays.sort(blue_pixels);

                result_bit.setPixel(x+1, y+1, Color.argb(255,
                        red_pixels[red_pixels.length-1],
                        green_pixels[green_pixels.length-1],
                        blue_pixels[blue_pixels.length-1]));
            }
        }
       result.setImageBitmap(result_bit);

    }
    private void buildFilter(){
        int [][] region = new int[3][3];
        for(int y = 0; y < height - 3 + 1; y ++){
            for (int x=0; x < width - 3 + 1; x ++){
                int[] red_pixels = new int[3*3];
                int[] green_pixels = new int[3*3];
                int[] blue_pixels = new int[3*3];
                int num = 0;
                for (int i = 0; i < 3; i ++){
                    for (int j = 0; j < 3; j++) {
                        region[i][j] = img_bit.getPixel(x + i, y + j);
                        red_pixels[num] = Color.red(region[i][j]);
                        green_pixels[num] = Color.green(region[i][j]);
                        blue_pixels[num] = Color.blue(region[i][j]);
                        num++;
                    }
                }
                Arrays.sort(red_pixels);
                Arrays.sort(green_pixels);
                Arrays.sort(blue_pixels);

                result_bit.setPixel(x+1, y+1, Color.argb(255,
                        red_pixels[0],
                        green_pixels[0],
                        blue_pixels[0]));

            }
        }
        result.setImageBitmap(result_bit);
    }

    private void sobelFilter(){
        int A, R, G, B,
                R_X, G_X, B_X,
                R_Y, G_Y, B_Y;
        double[][] filter_Y = new double[][] {
                { -1, -2, -1 },
                { 0, 0, 0 },
                { 1, 2, 1 }
        };
        double[][] filter_X = new double[][] {
                { -1, 0, 1 },
                { -2, 0, 2 },
                { -1, 0, 1 }
        };

        Bitmap res_X = Bitmap.createBitmap(width, height, img_bit.getConfig());
        Bitmap res_Y = Bitmap.createBitmap(width, height, img_bit.getConfig());

        res_X = Convolution(filter_X, 1, 3);
        res_Y = Convolution(filter_Y, 1, 3);

        for (int y = 0; y < height; y++ ){
            for (int x = 0; x < width; x ++){
                int pixel_X = res_X.getPixel(x, y);
                int pixel_Y = res_Y.getPixel(x, y);

                A = Color.alpha(pixel_X);
                R_X = Color.red(pixel_X);
                G_X = Color.green(pixel_X);
                B_X = Color.blue(pixel_X);

                R_Y = Color.red(pixel_Y);
                G_Y = Color.green(pixel_Y);
                B_Y = Color.blue(pixel_Y);

                R = (int)Math.sqrt(pow(R_X, 2) + pow(R_Y, 2));
                G = (int)Math.sqrt(pow(G_X, 2) + pow(G_Y, 2));
                B = (int)Math.sqrt(pow(B_X, 2) + pow(B_Y, 2));

                result_bit.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }
        result.setImageBitmap(result_bit);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);

        result = findViewById(R.id.imageView2);
        img_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo100);
        width = img_bit.getWidth();
        height = img_bit.getHeight();
        result_bit = Bitmap.createBitmap(width, height, img_bit.getConfig());

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
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
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
