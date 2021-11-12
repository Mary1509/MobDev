package com.example.lab4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

public class Task4 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    ImageView result;
    int width1, height1;
    Bitmap img1_bit, img2_bit, res_bit;
    double a;

    Button change;

    Runnable swapImage = new Runnable() {
        @Override
        public void run() {
            result.setImageBitmap(res_bit);
        }
    };

    void changePhotos(){
        int pix1, pix2, newPix, alpha, red, green, blue;
        res_bit = Bitmap.createBitmap(width1, height1, Bitmap.Config.ARGB_8888);
        result.setImageBitmap(res_bit);
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
        result.postDelayed(swapImage, 3000);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMin(0);
        seekBar.setMax(100);

        change = findViewById(R.id.button);

        seekBar.setOnSeekBarChangeListener(this);

        result = findViewById(R.id.imageView3);

        img1_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo);
        width1 = img1_bit.getWidth();
        height1 = img1_bit.getHeight();

        res_bit = Bitmap.createBitmap(width1, height1, Bitmap.Config.ARGB_8888);

        img2_bit = BitmapFactory.decodeResource(getResources(),
                R.drawable.photo1);

        a = seekBar.getProgress() / 100.0;
        changePhotos();




        change.setOnClickListener(v -> {
            a = 0;
            while (a <= 100){
                a += 10;
                seekBar.setProgress((int)a);
                SystemClock.sleep(1000);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        a = seekBar.getProgress() / 100.0;
        changePhotos();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        a = seekBar.getProgress() / 100.0;
        changePhotos();
    }
}
