package com.example.denis.draw;

import android.graphics.Canvas;
import android.graphics.Paint;


public class PRectangle implements PShape {
    float x, y, x1, y1;
    int width, clr;
    String type;
    Paint p;


    @Override
    public void init(float x, float y, float x1, float y1, int clr, int width) {
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
        gg.drawRect(x, y, x1 , y1 , p);
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
