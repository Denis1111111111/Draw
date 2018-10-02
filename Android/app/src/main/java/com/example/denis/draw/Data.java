package com.example.denis.draw;

import android.graphics.Color;
import android.util.Log;

public class Data
{
    private int clr = Color.BLACK;
    private String type = "curves";
    private int width = 10;
    private static Data instance = null;

    private Data()
    {}

    public static Data getInstance()
    {
        if (instance == null)
        {
            instance  = new Data();
        }
        return instance;
    }

    public void setColor(int clr)
    {
        this.clr = clr;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getColor()
    {
        return clr;
    }

    public String getType()
    {
        return type;
    }

    public int getWidth()
    {
        return width;
    }
}
