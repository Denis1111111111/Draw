package com.example.denis.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class POval implements PShape {
    float x, y, x1, y1;
    int width, clr;
    String type;
    Paint p;

    @Override
    public void init(float x, float y, float x1, float y1, int clr, int width) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.width = width;
        this.x1 = x1;
        this.y1 = y1;
        this.clr = clr;
        p = new Paint();

    }

    @Override
    public void draw(Canvas gg) {
        p.setColor(clr);
        p.setStrokeWidth(width);
        float radius;
        float x3 = x1 - x;
        float y3 = y1 - y;
        if (x > x + x3) {
            radius = x - (x + x3);
        } else radius = (x + x3) - x;
        gg.drawCircle(x + x3, y + y3, radius, p);
    }

    @Override
    public float getStartX() {
        return x;
    }

    @Override
    public float getStartY() {
        return y;
    }

    @Override
    public float getEndX() {
        return x1;
    }

    @Override
    public float getEndY() {
        return y1;
    }

    @Override
    public int getStroke() {
        return width;
    }

    @Override
    public int getColor() {
        return clr;
    }

    @Override
    public String getShape() {
        return this.getClass().getName();
    }
}
