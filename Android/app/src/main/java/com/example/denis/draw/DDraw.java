package com.example.denis.draw;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DDraw extends View implements View.OnTouchListener
{
    Data data = null;
    float x,y,x2,y2;
    ArrayList<PShape> pp = new ArrayList<PShape>();


    public DDraw(Data data, Context context)
    {
        super(context);
        this.data = data;
        setOnTouchListener(this);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(80, 102, 204, 255);
        for (PShape shape : pp)
        {
            shape.draw(canvas);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                x = event.getX();
                y = event.getY();
                break;
            }

            case MotionEvent.ACTION_MOVE: {

                if (!data.getType().equals("curves"))
                    return false;

                x2 = event.getX();
                y2 = event.getY();
                PLine line = new PLine();
                line.init(x, y, x2, y2, data.getColor(), data.getWidth());
                x = x2;
                y = y2;
                pp.add(line);
                invalidate();
                break;
            }

            case MotionEvent.ACTION_UP:{
                 x2 = event.getX();
                 y2 = event.getY();

                if(data.getType().equals("curves"))
                    return false;

                Canvas  canvas = new Canvas();
                Paint p = new Paint();

                p.setColor(data.getColor());
                p.setStrokeWidth(data.getWidth());

                switch (data.getType())
                {
                    case "rectangle":
                        PRectangle rect = new PRectangle();
                        rect.init(x, y, x2, y2, data.getColor(), data.getWidth());
                        pp.add(rect);
                       invalidate();
                        break;

                    case "oval":
                        POval ellipse = new POval();
                        ellipse.init(x, y, x2, y2, data.getColor(), data.getWidth());
                        pp.add(ellipse);
                        invalidate();
                        break;
                    case "line":
                        PLine line = new PLine();
                        line.init(x, y, x2, y2, data.getColor(), data.getWidth());
                        pp.add(line);
                        invalidate();
                        break;
                    default:
                        break;
                }
                break;
            }
        }
        return true;
    }


}
