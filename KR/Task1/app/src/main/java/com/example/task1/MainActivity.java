package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Hypocycloid(this));
    }

    static class Hypocycloid extends View {

        public Hypocycloid(Context context) {
            super(context);
        }

        static class Point {
            int x;
            int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        Paint hypoPaint() {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);
            return paint;
        }
        Paint subPaint() {
            Paint paint = new Paint();
            paint.setColor(Color.TRANSPARENT);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);
            return paint;
        }

        ArrayList<Point> points = new ArrayList<>();
        int rot_speed = 90;
        double t = 0;
        int R = 500;
        int r = (int)(Math.random()*400);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        double k = (double)(R) / (double) r;
        Point circleB = new Point(centerX, centerY);
        Point circleS = new Point(centerX + R - r, centerY);
        Point line_radius = new Point(centerX + R - r, centerY);

        @SuppressLint("DrawAllocation")
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            t = t + Math.PI / rot_speed;
            circleB.x = getWidth() / 2;
            circleB.y = getHeight() / 2;
            circleS.x = (int) (circleB.x + r * (k - 1) * Math.cos(t));
            circleS.y = (int) (circleB.y + r * (k - 1) * Math.sin(t));
            line_radius.x = (int) (circleS.x + r * Math.cos((k - 1) * t));
            line_radius.y = (int) (circleS.y - r * Math.sin((k - 1) * t));

            points.add(new Point(line_radius.x, line_radius.y));

            canvas.drawCircle(circleB.x, circleB.y, R, subPaint());
            canvas.drawCircle(circleS.x, circleS.y, r, subPaint());
            canvas.drawLine(circleS.x, circleS.y, line_radius.x, line_radius.y, subPaint());
            for (Point p : points) {
                canvas.drawPoint(p.x, p.y, hypoPaint());
            }
            invalidate();
        }
    }
}