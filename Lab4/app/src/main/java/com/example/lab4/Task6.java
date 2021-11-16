package com.example.lab4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class Task6 extends AppCompatActivity {
    SeekBar layer_n;
    ImageView origin, result;
    int width, height, w_width, w_height;

    Bitmap orig_bit, water_bit, res_bit;

    int[] pixels, w_pixels, w_binary;

    private void insertIntoLayer(int layer_num){
        int A, R, G, B;
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                int pixel = pixels[y * width + x];
                A = Color.alpha(pixel);
                R = Color.red(pixel);
                G = Color.green(pixel);
                B = Color.blue(pixel);
                if (y < w_height && x < w_width){
                    StringBuilder B_bin = new StringBuilder(Integer.toBinaryString(B));
                    while (B_bin.length() != 8){
                        B_bin.insert(0, '0');
                    }
                    char [] B_bin_arr = B_bin.toString().toCharArray();
                    B_bin_arr[8 - layer_num] = Integer.toString(w_binary[y * w_width + x]).toCharArray()[0];
                    B_bin = new StringBuilder(new String(B_bin_arr));
                    B = Integer.parseInt(B_bin.toString(), 2);
                }
                res_bit.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }
        result.setImageBitmap(res_bit);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task6);

        layer_n = findViewById(R.id.seekBar2);
        origin = findViewById(R.id.imageView1);
        result = findViewById(R.id.imageView2);

        orig_bit = BitmapFactory.decodeResource(getResources(), R.drawable.photo);
        width = orig_bit.getWidth();
        height = orig_bit.getHeight();
        pixels = new int[width*height];
        orig_bit.getPixels(pixels, 0, width, 0, 0, width, height);

        water_bit = BitmapFactory.decodeResource(getResources(), R.drawable.sign);
        w_width = water_bit.getWidth();
        w_height = water_bit.getHeight();
        w_pixels = new int[w_width*w_height];
        water_bit.getPixels(w_pixels, 0, w_width, 0, 0, w_width, w_height);

        res_bit = Bitmap.createBitmap(width, height, orig_bit.getConfig());

        //Convert to binary
        w_binary = new int[w_width*w_height];
        for (int i = 0; i < w_pixels.length; i++){
            int R = Color.red(w_pixels[i]);
            int G = Color.green(w_pixels[i]);
            int B = Color.blue(w_pixels[i]);
            int avg = (R + G + B)/3;
            if (avg >= 225) w_binary[i] = 1;
            else w_binary[i] = 0;
        }

        layer_n.setProgress(1);
        insertIntoLayer(layer_n.getProgress());

        layer_n.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                insertIntoLayer(layer_n.getProgress());
            }
        });


    }
}
