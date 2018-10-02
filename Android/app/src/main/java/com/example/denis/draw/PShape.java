package com.example.denis.draw;


import android.graphics.Canvas;
import android.graphics.Paint;

public interface PShape
{
    void init (float x,float y,float x1, float y1, int clr,int width);
    void draw(Canvas gg);
    float getStartX();
    float getStartY();
    float getEndX();
    float getEndY();
    int getStroke();
    int getColor();
    String getShape();
}
